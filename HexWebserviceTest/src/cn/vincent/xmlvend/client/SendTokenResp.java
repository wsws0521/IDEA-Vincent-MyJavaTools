
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SendTokenResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SendTokenResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SendTokenReqMsgID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MsgID"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Msg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendTokenResp", propOrder = {
    "sendTokenReqMsgID",
    "status",
    "msg"
})
public abstract class SendTokenResp {

    @XmlElement(name = "SendTokenReqMsgID", required = true)
    protected MsgID sendTokenReqMsgID;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "Msg", required = true)
    protected String msg;

    /**
     * 获取sendTokenReqMsgID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MsgID }
     *     
     */
    public MsgID getSendTokenReqMsgID() {
        return sendTokenReqMsgID;
    }

    /**
     * 设置sendTokenReqMsgID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MsgID }
     *     
     */
    public void setSendTokenReqMsgID(MsgID value) {
        this.sendTokenReqMsgID = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * 获取msg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置msg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

}
