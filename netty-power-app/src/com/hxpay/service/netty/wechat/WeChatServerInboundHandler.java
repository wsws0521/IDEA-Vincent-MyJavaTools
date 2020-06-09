package com.hxpay.service.netty.wechat;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

















import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import javax.xml.rpc.ServiceException;

import net.sf.json.JSONObject;

import org.apache.commons.lang.ArrayUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.hxpay.service.netty.http.NettyHttpUtils;

import tangdi.ws.service.HexingWs;
import tangdi.ws.service.HexingWsService;
import tangdi.ws.service.HexingWsServiceLocator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.DefaultHttpMessage;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;

public class WeChatServerInboundHandler extends ChannelInboundHandlerAdapter {


    private HttpRequest request;
    private String current_time = "";
//    半包问题
    private String temHttpContent = "";//部分消息体
    private String AllHttpContent ="";//消息体字符串
    private String authTagFromHttpHeader ="";
    private String ivFromHttpHeader ="";
    private boolean peach_flag=false;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//设置日期格式
    	current_time = df.format(new Date());
    	
    	System.out.println(current_time+"==回调");
    	System.out.println(current_time+"==请求内容："+msg);
        if (msg instanceof HttpRequest) {
            request = (HttpRequest) msg;
            
            String uri = request.getUri();
            current_time = df.format(new Date());
            System.out.println(current_time+"==Uri:" + uri+"-----------------------------------------------------");
            temHttpContent = "";
            AllHttpContent = "";
            authTagFromHttpHeader = "";
            ivFromHttpHeader = "";
            peach_flag = false;
            
        	current_time = df.format(new Date());
            System.out.println(current_time+"=="+HttpMethod.POST);
            
            
            HttpHeaders headers = ((DefaultHttpMessage)msg).headers();
            for (Map.Entry<String, String> h : headers) {
//	                System.out.println(h.getKey() + "：" + h.getValue());
	                if(h.getKey().equals("X-Authentication-Tag")){
	                	authTagFromHttpHeader = h.getValue();
	                	peach_flag = true;
	                }
	                if(h.getKey().equals("X-Initialization-Vector")){
	                	ivFromHttpHeader = h.getValue();
	                	peach_flag = true;
	                }
            }
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
            temHttpContent = buf.toString(io.netty.util.CharsetUtil.UTF_8);
//            System.out.println(temHttpContent);
            buf.release();
            AllHttpContent = AllHttpContent + temHttpContent;
        }
        
        if(msg instanceof LastHttpContent){
        	current_time = df.format(new Date());
            System.out.println(current_time+"==AllHttpContent:"+AllHttpContent);
        	String xmldata = "";
        	String tran = "";
        	peach_flag=false;
        	if(peach_flag){
        		System.out.println("PEACH:"+peach_flag);
        		
        		//decrypt
        		
        		String requestXml = decrypt(ivFromHttpHeader,authTagFromHttpHeader,AllHttpContent);
        		NettyHttpUtils dechttp = new NettyHttpUtils(requestXml);
        		//json转xml
        		if(requestXml==null||requestXml.equals("")){
	            	JSONObject json = JSONObject.fromObject(requestXml);
	            	requestXml = dechttp.jsontoXml(json.toString());
	            	StringBuilder sb = new StringBuilder(requestXml);//构造一个StringBuilder对象
	                sb.insert(requestXml.indexOf("</xml>"), "<orgindata>" + AllHttpContent + "</orgindata>");//在指定的位置1，插入指定的字符串
	                sb.insert(requestXml.indexOf("</xml>"), "<THIRD_PAY>" + "peach" + "</THIRD_PAY>");//在指定的位置1，插入指定的字符串
	                sb.insert(requestXml.indexOf("</xml>"), "<SOURCE>" + "5" + "</SOURCE>");//在指定的位置1，插入指定的字符串
	                requestXml = sb.toString();
	                xmldata = requestXml;
	                tran = "HPeachSuccess";
        		}
//        		String data ="success";
//        		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
//                        OK, Unpooled.wrappedBuffer(data.getBytes("UTF-8")));
//                response.headers().set(CONTENT_TYPE, "text/plain");
//                response.headers().set(CONTENT_LENGTH,
//                        response.content().readableBytes());
//                if (HttpHeaders.isKeepAlive(request)) {
//                    response.headers().set(CONNECTION, Values.KEEP_ALIVE);
//                }
//                ctx.write(response);
//                ctx.flush();
        	}else{
        	
	//        	String xmldata = AllHttpContent.replace("<xml>", "<ROOT>").replace("</xml>", "</ROOT>");
	        	
	//        	微信回调xml格式
	        	if(AllHttpContent.contains("<xml>")){
	        		xmldata = AllHttpContent;
	        		
	        		StringBuilder sb = new StringBuilder(xmldata);//构造一个StringBuilder对象
	                sb.insert(xmldata.indexOf("</xml>"), "<THIRD_PAY>" + "wechat" + "</THIRD_PAY>");//在指定的位置1，插入指定的字符串
	                sb.insert(xmldata.indexOf("</xml>"), "<SOURCE>" + "5" + "</SOURCE>");//在指定的位置1，插入指定的字符串
	                xmldata = sb.toString();
	            	tran = "HPaySuccess";
	        	}else if(AllHttpContent.contains("&")){//支付宝回调 字符串格式 :key=value &分隔
	        		NettyHttpUtils netutil = new NettyHttpUtils(AllHttpContent);
	        		netutil.initData();
	        		xmldata = NettyHttpUtils.maptoXml(netutil.getMap());
	//        		xmldata = xmldata + "<ORGINDATA>" + AllHttpContent + "</ORGINDATA>";
	        		StringBuilder sb = new StringBuilder(xmldata);//构造一个StringBuilder对象
	                sb.insert(xmldata.indexOf("</xml>"), "<orgindata>" + AllHttpContent + "</orgindata>");//在指定的位置1，插入指定的字符串
	                sb.insert(xmldata.indexOf("</xml>"), "<THIRD_PAY>" + "alipay" + "</THIRD_PAY>");//在指定的位置1，插入指定的字符串
	                sb.insert(xmldata.indexOf("</xml>"), "<SOURCE>" + "5" + "</SOURCE>");//在指定的位置1，插入指定的字符串
	                
	                xmldata = sb.toString().replaceAll("&", "&amp;");
	            	tran = "HPaySuccess";
	        		
	        	}/*else{
	        		current_time = df.format(new Date());
	        		String data =current_time+":"+"success";
	        		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
	                        OK, Unpooled.wrappedBuffer(data.getBytes("UTF-8")));
	                response.headers().set(CONTENT_TYPE, "text/plain");
	                response.headers().set(CONTENT_LENGTH,
	                        response.content().readableBytes());
	                if (HttpHeaders.isKeepAlive(request)) {
	                    response.headers().set(CONNECTION, Values.KEEP_ALIVE);
	                }
	                ctx.write(response);
	                ctx.flush();
	                return;
	        	}*/
        	}
        	System.out.println("请求hexpay交易码："+tran);
        	
        	if(tran!=""){
        		System.out.println("hexpay 请求xml参数"+xmldata);
        		current_time = df.format(new Date());
                System.out.println(current_time+"==调用hexpay接口");
        		String data  = conn(tran,xmldata);
        		current_time = df.format(new Date());
                System.out.println(current_time+"==服务器返回");
            	
            	if(!AllHttpContent.contains("<xml>")){//支付宝成功信息 只返回success
            		if(data.contains("SUCCESS")){
            			data = "success";
            		}
            	}
            	
            	System.out.println("----------------------------------------------------");
            	System.out.println(data);
            	
                 FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                         OK, Unpooled.wrappedBuffer(data.getBytes("UTF-8")));
                 response.headers().set(CONTENT_TYPE, "text/plain");
                 response.headers().set(CONTENT_LENGTH,
                         response.content().readableBytes());
                 if (HttpHeaders.isKeepAlive(request)) {
                     response.headers().set(CONNECTION, Values.KEEP_ALIVE);
                 }
                 ctx.write(response);
                 ctx.flush();
                 current_time = df.format(new Date());
                 System.out.println(current_time+"==中转返回");
        	}
        	
        	
        }
        
    }
    
    public static String conn(String method, String reqxml)
			throws RemoteException {
		HexingWsService service = new HexingWsServiceLocator();
		HexingWs client = null;
		try {
			client = service.getHexingWsPort();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String str = null;
		try {
			str = client.trans(method, reqxml);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return str;
	}
    
    public static String decrypt(String ivFromHttpHeader,String authTagFromHttpHeader,String httpBody) throws Exception {
		Security.addProvider(new BouncyCastleProvider());

		// Data from configuration,provided by peach
		String keyFromConfiguration = "";
		
		Properties pro = new Properties();
		System.out.println(System.getProperty("user.dir")+"/netty-power.properies");
		FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"/netty-power.properies");
		pro.load(in);
		keyFromConfiguration = pro.getProperty("notify.peachkey");

		// Data from server
		ivFromHttpHeader = "000000000000000000000000";
		authTagFromHttpHeader = "CE573FB7A41AB78E743180DC83FF09BD";
		httpBody = "6463E79C7A83D7112C2F22B57CEF4125A1F8DAEE8FAC47DAB44BDA5930881314EE4A26A3B687CD6A3B7D2D93910C3943ACFB97191EB5E03F6D628806A500C1EB8B8D1E6A96917179FE38AB52A031F462495C6EEC76EE6659665FE37A5D";

		// Convert data to process
		byte[] key = DatatypeConverter.parseHexBinary(keyFromConfiguration);
		byte[] iv = DatatypeConverter.parseHexBinary(ivFromHttpHeader);
		byte[] authTag = DatatypeConverter
				.parseHexBinary(authTagFromHttpHeader);
		byte[] encryptedText = DatatypeConverter.parseHexBinary(httpBody);

		// Unlike other programming language, We have to append auth tag at the
		// end of encrypted text in Java
		byte[] cipherText = ArrayUtils.addAll(encryptedText, authTag);

		// Prepare decryption
		SecretKeySpec keySpec = new SecretKeySpec(key, 0, 32, "AES");
		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));

		// Decrypt
		byte[] bytes = cipher.doFinal(cipherText);
		String res = new String(bytes, "UTF-8");
		System.out.println(res);
		return res;
	}

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

}