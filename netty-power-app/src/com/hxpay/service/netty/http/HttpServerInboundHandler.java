package com.hxpay.service.netty.http;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.hexing.pay.oss.common.logger.Logger;
import com.hexing.pay.oss.common.logger.LoggerFactory;
import com.hxpay.service.netty.startServices;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import net.sf.json.JSONObject;
import tangdi.ws.service.HexingWs;
import tangdi.ws.service.HexingWsService;
import tangdi.ws.service.HexingWsServiceLocator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.EndOfDataDecoderException;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.InterfaceHttpData.HttpDataType;

public class HttpServerInboundHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory
			.getLogger(HttpServerInboundHandler.class);
	private HttpRequest request;
	private String current_time = "";
	// 半包问题
	private String temHttpContent = "";// 部分消息体
	private String AllHttpContent = "";// 消息体字符串

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// 设置日期格式

		current_time = df.format(new Date());
		String req_time = df.format(new Date());
		if (msg instanceof HttpRequest) {
			request = (HttpRequest) msg;
			String uri = request.getUri();
			current_time = df.format(new Date());
			System.out.println(current_time + "==Uri:" + uri
					+ "-----------------------------------------------------");
			if (request.getMethod().equals(HttpMethod.POST)) {

			}

			temHttpContent = "";
			AllHttpContent = "";
		}
		if (msg instanceof HttpContent) {
			System.out.println(current_time + "==获取请求");

			HttpContent content = (HttpContent) msg;
			SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
			FileWriter writer = new FileWriter("orig_req.bin", true);

			ByteBuf buf = content.content();
			for (int i = 0; i < buf.capacity(); i++) {
				byte b = buf.getByte(i);
				writer.write(b);
				// System.out.println(b);
			}
			writer.close();
			temHttpContent = buf.toString(io.netty.util.CharsetUtil.UTF_8);

			// System.out.println(temHttpContent);
			buf.release();
			AllHttpContent = AllHttpContent + temHttpContent;
			System.out.println(current_time + "==请求内容：" + AllHttpContent);
		}

		if (msg instanceof LastHttpContent) {
			// body消息必须使用json
			String orgindata = AllHttpContent;
			current_time = df.format(new Date());
			System.out.println(current_time + "==原始数据" + orgindata);

			if (!"".equals(orgindata)) {
				String responseStr ="";
				try {	/*解析返回串，如果是xml格式则表示调用API接口*/
					InputStream is = new ByteArrayInputStream(orgindata.getBytes("utf-8"));
					org.jdom.Document document = new SAXBuilder().build(new InputSource(is));
					System.out.println(current_time + "==调用hexpay接口");
					responseStr = sendPost(startServices.HEXPAY_ADDRESS,orgindata);
					
					current_time = df.format(new Date());
					System.out.println(current_time + "==服务器返回:"+responseStr);
					
					int start = responseStr.indexOf("<return>");
				    int finish = responseStr.indexOf("</return>");
				    if ((start >= 0) && (finish >= 0)) {
				    	responseStr = responseStr.substring(start + 8, finish);
				    }
				    responseStr = responseStr.replaceAll("&lt;", "<");
				} catch (Exception e) {
				
					// String jsonStr = URLDecoder.decode(orgindata);
					NettyHttpUtils dechttp = new NettyHttpUtils(AllHttpContent);
					dechttp.initData();
					String tran = dechttp.getParams("tran");
					String lang = "en";
					String jsonStr = "";
					String xmldata = "";
					jsonStr = dechttp.getParams("json");
					if (jsonStr == null || jsonStr.equals("")) {
						// orgindata= orgindata.replaceAll("\\\\U", "\\\\\\\\U");
						JSONObject json = JSONObject.fromObject(orgindata);
						String data = "";
						String auth = "";
						
						if (json.has("data")) {
							data = json.get("data").toString();
							// data= data.replaceAll("\\\\\\\\U", "\\\\U");
						}
						if (json.has("auth")) {
							auth = json.get("auth").toString();
							if (((JSONObject) json.get("auth")).has("LANG")) {
								lang = ((JSONObject) json.get("auth")).get("LANG").toString();
								// data= data.replaceAll("\\\\\\\\U", "\\\\U");
							}
						}
						tran = json.get("tran").toString();
						System.out.println("方法：" + tran + "\r\n" + "请求："
								+ json.toString() + "~");
						xmldata = dechttp.jsonArrayToXML(json.toString());
						// String responseXml = conn(tran,xmldata);
						// String responseStr =
						// NettyHttpUtils.xmltoJson_O(responseXml,tran);
					} else {
						System.out.println("方法" + tran + "\r\n" + "请求：" + jsonStr);
					}

					// 空极测试服务
					// JSONObject json = JSONObject.fromObject(orgindata);
					// tran = (String) json.get("tran");
					//
	
					// String xmldata = dechttp.jsontoXml(jsonStr);
					// // String xmldata = dechttp.jsontoXml(json.toString());
					System.out.println("xmldata:" + xmldata);
					current_time = df.format(new Date());
					System.out.println(current_time + "==调用hexpay接口");
					String responseXml = conn(tran, xmldata,lang);
	
					current_time = df.format(new Date());
					System.out.println(current_time + "==服务器返回");
					if (responseXml != "" && responseXml.contains("<")) {
						responseStr = NettyHttpUtils.xmltoJson_O(responseXml, tran);
					}
				// String responseStr = NettyHttpUtils.xmltoJson(responseXml);
				// responseStr= responseStr.replaceAll("\\\\\\\\U", "\\\\U");
				}
					
				System.out.println(responseStr);
				System.out
						.println("----------------------------------------------------");

				FullHttpResponse response = new DefaultFullHttpResponse(
						HTTP_1_1, OK, Unpooled.wrappedBuffer(responseStr
								.getBytes("UTF-8")));
				response.headers().set(CONTENT_TYPE, "text/plain");
				response.headers().set(CONTENT_LENGTH,
						response.content().readableBytes());
				if (HttpHeaders.isKeepAlive(request)) {
					response.headers().set(CONNECTION, Values.KEEP_ALIVE);
				}
				ctx.write(response);
				ctx.flush();
				current_time = df.format(new Date());
				String resp_time = df.format(new Date());
				System.out.println(current_time + "==中转返回");
				Date d1 = df.parse(resp_time);
				Date d2 = df.parse(req_time);
				long diff = d1.getTime() - d2.getTime();
				float timediff = (float) diff / 1000;
				System.out.println("耗时:" + timediff + "s");
			}
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		System.out.println("Exception：" + cause.toString());
		ctx.close();
	}

	public static String conn(String method, String reqxml, String lang)
			throws RemoteException, Exception {
		HexingWsService service = new HexingWsServiceLocator();
		HexingWs client = null;
		
		lang = lang;
		try {
			client = service.getHexingWsPort();
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("ServiceException()" + e.getClass());
		}
		String str = null;
		try {
			str = client.trans(method, reqxml);
			System.out.println("respxml:" + str);
		} catch (RemoteException e) {
			e.printStackTrace();

			System.out.println("e.getClass()" + e.getClass().toString());
			System.out.println("e.getCause()" + e.getCause());
			System.out.println("e.getMessage()" + e.getMessage());
			if (e.getClass().toString().contains("org.apache.axis.AxisFault")) {
				if (e.getMessage().contains("WstxLazyException")
						&& e.getMessage().contains("Illegal character entity")) {
					System.out.println("lang:" + lang.toLowerCase());
					if(lang.toLowerCase().equals("zh")){
						return "<ROOT><RSPCOD>22222</RSPCOD><RSPMSG>不合法输入！</RSPMSG></ROOT>";
					}else{
						return "<ROOT><RSPCOD>22222</RSPCOD><RSPMSG>Illegal character entity!</RSPMSG></ROOT>";
					}
				}
			}

		}
		System.out.println("str:" + str);
		return str;
	}
	
	private static String sendPost(String reqUrl,String reqStr){
		HttpClient client = new HttpClient();
		String response = null;
		PostMethod post = new PostMethod(reqUrl);
		
		
		try {
			post.setRequestHeader("Content-Type", "application/xml");
			post.setRequestBody(reqStr);
			int statusCode = client.executeMethod(post);
			
			BufferedReader read = new BufferedReader(new InputStreamReader(
					post.getResponseBodyAsStream()));
			StringBuilder sb3 = new StringBuilder();
			String line2;
			while ((line2 = read.readLine()) != null) {
				sb3.append(line2);
			}
			read.close();
			response = sb3.toString();
			post.releaseConnection();
			System.out.println("statusCode:" + statusCode);
			System.out.println("responseXml:" + response);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	private void main() {
		// TODO Auto-generated method stub
		try {
			conn("IQAmmeter","<ROOT><TOP><VERSION>1.0</VERSION><SOURCE>0</SOURCE><CUST_ID>A0000000001523</CUST_ID><REQUEST_TIME>2018-05-09 08:46:18</REQUEST_TIME></TOP><BODY><ENEL_ID>Y2015020700043</ENEL_ID><METER_NO>07051816713</METER_NO><PURCHASE_TYPE></PURCHASE_TYPE><PURCHARSE_VALUE></PURCHARSE_VALUE></BODY><TAIL><SIGN_TYPE>1</SIGN_TYPE><SIGNATURE>87da76eacbecbd89bf8f40403985022b</SIGNATURE></TAIL></ROOT>","zh");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}