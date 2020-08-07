
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *  Returned in every response and defines the response message context.
 * 			
 * 
 * <p>BaseResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BaseResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}DeviceID"/>
 *         &lt;element name="serverID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}DeviceID"/>
 *         &lt;element name="terminalID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}DeviceID"/>
 *         &lt;element name="reqMsgID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MsgID"/>
 *         &lt;element name="respDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dispHeader" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Msg" minOccurs="0"/>
 *         &lt;element name="operatorMsg" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Msg" minOccurs="0"/>
 *         &lt;element name="custMsg" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Msg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResp", propOrder = {
    "clientID",
    "serverID",
    "terminalID",
    "reqMsgID",
    "respDateTime",
    "dispHeader",
    "operatorMsg",
    "custMsg"
})
@XmlSeeAlso({
    ReprintEndBatchResp.class,
    DepositResp.class,
    TotalBatchResp.class,
    ConfirmNodeResp.class,
    StartBatchResp.class,
    ReprintDepositResp.class,
    VendorStatementResp.class,
    EndBatchResp.class,
    ConfirmCustomerResp.class,
    ReprintResp.class,
    XMLVendFaultResp.class,
    AdviceResp.class,
    ConfirmMeterResp.class,
    CustReportFaultResp.class,
    BaseVendResp.class,
    NonMeterSpecificEngResp.class
})
public class BaseResp {

    @XmlElement(required = true)
    protected DeviceID clientID;
    @XmlElement(required = true)
    protected DeviceID serverID;
    @XmlElement(required = true)
    protected DeviceID terminalID;
    @XmlElement(required = true)
    protected MsgID reqMsgID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar respDateTime;
    protected String dispHeader;
    protected String operatorMsg;
    protected String custMsg;

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
     * 获取serverID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DeviceID }
     *     
     */
    public DeviceID getServerID() {
        return serverID;
    }

    /**
     * 设置serverID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceID }
     *     
     */
    public void setServerID(DeviceID value) {
        this.serverID = value;
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
     * 获取reqMsgID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MsgID }
     *     
     */
    public MsgID getReqMsgID() {
        return reqMsgID;
    }

    /**
     * 设置reqMsgID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MsgID }
     *     
     */
    public void setReqMsgID(MsgID value) {
        this.reqMsgID = value;
    }

    /**
     * 获取respDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRespDateTime() {
        return respDateTime;
    }

    /**
     * 设置respDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRespDateTime(XMLGregorianCalendar value) {
        this.respDateTime = value;
    }

    /**
     * 获取dispHeader属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispHeader() {
        return dispHeader;
    }

    /**
     * 设置dispHeader属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispHeader(String value) {
        this.dispHeader = value;
    }

    /**
     * 获取operatorMsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorMsg() {
        return operatorMsg;
    }

    /**
     * 设置operatorMsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorMsg(String value) {
        this.operatorMsg = value;
    }

    /**
     * 获取custMsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustMsg() {
        return custMsg;
    }

    /**
     * 设置custMsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustMsg(String value) {
        this.custMsg = value;
    }

}
