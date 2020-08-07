
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
 * <p>BaseResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡclientID���Ե�ֵ��
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
     * ����clientID���Ե�ֵ��
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
     * ��ȡserverID���Ե�ֵ��
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
     * ����serverID���Ե�ֵ��
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
     * ��ȡterminalID���Ե�ֵ��
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
     * ����terminalID���Ե�ֵ��
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
     * ��ȡreqMsgID���Ե�ֵ��
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
     * ����reqMsgID���Ե�ֵ��
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
     * ��ȡrespDateTime���Ե�ֵ��
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
     * ����respDateTime���Ե�ֵ��
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
     * ��ȡdispHeader���Ե�ֵ��
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
     * ����dispHeader���Ե�ֵ��
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
     * ��ȡoperatorMsg���Ե�ֵ��
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
     * ����operatorMsg���Ե�ֵ��
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
     * ��ȡcustMsg���Ե�ֵ��
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
     * ����custMsg���Ե�ֵ��
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
