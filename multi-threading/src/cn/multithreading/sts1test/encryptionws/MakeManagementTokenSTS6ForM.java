
package cn.multithreading.sts1test.encryptionws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeManagementTokenSTS6ForM complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MakeManagementTokenSTS6ForM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meterNo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="supplyGroupCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarrifIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="managementFunction" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transferAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="command" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeBaseLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeManagementTokenSTS6ForM", propOrder = {
    "meterNo",
    "supplyGroupCode",
    "tarrifIndex",
    "keyVersion",
    "managementFunction",
    "transferAmount",
    "command",
    "timeBaseLine",
    "ea",
    "tct"
})
public class MakeManagementTokenSTS6ForM {

    protected long meterNo;
    protected int supplyGroupCode;
    protected int tarrifIndex;
    protected int keyVersion;
    protected int managementFunction;
    protected BigDecimal transferAmount;
    protected int command;
    protected String timeBaseLine;
    @XmlElement(name = "EA")
    protected String ea;
    protected String tct;

    /**
     * ��ȡmeterNo���Ե�ֵ��
     * 
     */
    public long getMeterNo() {
        return meterNo;
    }

    /**
     * ����meterNo���Ե�ֵ��
     * 
     */
    public void setMeterNo(long value) {
        this.meterNo = value;
    }

    /**
     * ��ȡsupplyGroupCode���Ե�ֵ��
     * 
     */
    public int getSupplyGroupCode() {
        return supplyGroupCode;
    }

    /**
     * ����supplyGroupCode���Ե�ֵ��
     * 
     */
    public void setSupplyGroupCode(int value) {
        this.supplyGroupCode = value;
    }

    /**
     * ��ȡtarrifIndex���Ե�ֵ��
     * 
     */
    public int getTarrifIndex() {
        return tarrifIndex;
    }

    /**
     * ����tarrifIndex���Ե�ֵ��
     * 
     */
    public void setTarrifIndex(int value) {
        this.tarrifIndex = value;
    }

    /**
     * ��ȡkeyVersion���Ե�ֵ��
     * 
     */
    public int getKeyVersion() {
        return keyVersion;
    }

    /**
     * ����keyVersion���Ե�ֵ��
     * 
     */
    public void setKeyVersion(int value) {
        this.keyVersion = value;
    }

    /**
     * ��ȡmanagementFunction���Ե�ֵ��
     * 
     */
    public int getManagementFunction() {
        return managementFunction;
    }

    /**
     * ����managementFunction���Ե�ֵ��
     * 
     */
    public void setManagementFunction(int value) {
        this.managementFunction = value;
    }

    /**
     * ��ȡtransferAmount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    /**
     * ����transferAmount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransferAmount(BigDecimal value) {
        this.transferAmount = value;
    }

    /**
     * ��ȡcommand���Ե�ֵ��
     * 
     */
    public int getCommand() {
        return command;
    }

    /**
     * ����command���Ե�ֵ��
     * 
     */
    public void setCommand(int value) {
        this.command = value;
    }

    /**
     * ��ȡtimeBaseLine���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeBaseLine() {
        return timeBaseLine;
    }

    /**
     * ����timeBaseLine���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeBaseLine(String value) {
        this.timeBaseLine = value;
    }

    /**
     * ��ȡea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEA() {
        return ea;
    }

    /**
     * ����ea���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEA(String value) {
        this.ea = value;
    }

    /**
     * ��ȡtct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTct() {
        return tct;
    }

    /**
     * ����tct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTct(String value) {
        this.tct = value;
    }

}
