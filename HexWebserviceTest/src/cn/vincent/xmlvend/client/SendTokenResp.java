
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SendTokenResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡsendTokenReqMsgID���Ե�ֵ��
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
     * ����sendTokenReqMsgID���Ե�ֵ��
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
     * ��ȡstatus���Ե�ֵ��
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
     * ����status���Ե�ֵ��
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
     * ��ȡmsg���Ե�ֵ��
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
     * ����msg���Ե�ֵ��
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
