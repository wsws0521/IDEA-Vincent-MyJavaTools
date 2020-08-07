
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Present in all requests, defines the request message context.
 * 			
 * 
 * <p>BaseReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BaseReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}DeviceID"/>
 *         &lt;element name="terminalID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}DeviceID"/>
 *         &lt;element name="msgID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MsgID"/>
 *         &lt;element name="authCred" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AuthCred" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseReq", propOrder = {
    "clientID",
    "terminalID",
    "msgID",
    "authCred"
})
@XmlSeeAlso({
    PayAccReq.class,
    ReprintReq.class,
    VerifyReq.class,
    ConfirmNodeReq.class,
    DepositReq.class,
    VendorStatementReq.class,
    LoginReq.class,
    ConfirmCustomerReq.class,
    ReprintDepositReq.class,
    EndBatchReq.class,
    ReprintEndBatchReq.class,
    StartBatchReq.class,
    TotalBatchReq.class,
    AdviceReq.class,
    ConfirmMeterReq.class,
    CustReportFaultReq.class,
    UpdateMeterKeyReq.class,
    BaseVendReq.class,
    NonMeterSpecificEngReq.class
})
public class BaseReq {

    @XmlElement(required = true)
    protected DeviceID clientID;
    @XmlElement(required = true)
    protected DeviceID terminalID;
    @XmlElement(required = true)
    protected MsgID msgID;
    protected AuthCred authCred;

    /**
     * 获取clientID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DeviceID }
     *     
     */
    public DeviceID getClientID() {
        return clientID;
    }

    /**
     * 设置clientID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceID }
     *     
     */
    public void setClientID(DeviceID value) {
        this.clientID = value;
    }

    /**
     * 获取terminalID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DeviceID }
     *     
     */
    public DeviceID getTerminalID() {
        return terminalID;
    }

    /**
     * 设置terminalID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceID }
     *     
     */
    public void setTerminalID(DeviceID value) {
        this.terminalID = value;
    }

    /**
     * 获取msgID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MsgID }
     *     
     */
    public MsgID getMsgID() {
        return msgID;
    }

    /**
     * 设置msgID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MsgID }
     *     
     */
    public void setMsgID(MsgID value) {
        this.msgID = value;
    }

    /**
     * 获取authCred属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AuthCred }
     *     
     */
    public AuthCred getAuthCred() {
        return authCred;
    }

    /**
     * 设置authCred属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AuthCred }
     *     
     */
    public void setAuthCred(AuthCred value) {
        this.authCred = value;
    }

}
