
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeKeyTokenSTS6ForM complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MakeKeyTokenSTS6ForM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meterNo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="supplyGroupCode_current" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="supplyGroupCode_new" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarrifIndex_current" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarrifIndex_new" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyVersion_current" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyVersion_new" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeBaseLine_current" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeBaseLine_new" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keyChangeNums" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeKeyTokenSTS6ForM", propOrder = {
    "meterNo",
    "supplyGroupCodeCurrent",
    "supplyGroupCodeNew",
    "tarrifIndexCurrent",
    "tarrifIndexNew",
    "keyVersionCurrent",
    "keyVersionNew",
    "timeBaseLineCurrent",
    "timeBaseLineNew",
    "tct",
    "ea",
    "keyChangeNums"
})
public class MakeKeyTokenSTS6ForM {

    protected long meterNo;
    @XmlElement(name = "supplyGroupCode_current")
    protected int supplyGroupCodeCurrent;
    @XmlElement(name = "supplyGroupCode_new")
    protected int supplyGroupCodeNew;
    @XmlElement(name = "tarrifIndex_current")
    protected int tarrifIndexCurrent;
    @XmlElement(name = "tarrifIndex_new")
    protected int tarrifIndexNew;
    @XmlElement(name = "keyVersion_current")
    protected int keyVersionCurrent;
    @XmlElement(name = "keyVersion_new")
    protected int keyVersionNew;
    @XmlElement(name = "timeBaseLine_current")
    protected String timeBaseLineCurrent;
    @XmlElement(name = "timeBaseLine_new")
    protected String timeBaseLineNew;
    protected String tct;
    @XmlElement(name = "EA")
    protected String ea;
    protected String keyChangeNums;

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
     * ��ȡsupplyGroupCodeCurrent���Ե�ֵ��
     * 
     */
    public int getSupplyGroupCodeCurrent() {
        return supplyGroupCodeCurrent;
    }

    /**
     * ����supplyGroupCodeCurrent���Ե�ֵ��
     * 
     */
    public void setSupplyGroupCodeCurrent(int value) {
        this.supplyGroupCodeCurrent = value;
    }

    /**
     * ��ȡsupplyGroupCodeNew���Ե�ֵ��
     * 
     */
    public int getSupplyGroupCodeNew() {
        return supplyGroupCodeNew;
    }

    /**
     * ����supplyGroupCodeNew���Ե�ֵ��
     * 
     */
    public void setSupplyGroupCodeNew(int value) {
        this.supplyGroupCodeNew = value;
    }

    /**
     * ��ȡtarrifIndexCurrent���Ե�ֵ��
     * 
     */
    public int getTarrifIndexCurrent() {
        return tarrifIndexCurrent;
    }

    /**
     * ����tarrifIndexCurrent���Ե�ֵ��
     * 
     */
    public void setTarrifIndexCurrent(int value) {
        this.tarrifIndexCurrent = value;
    }

    /**
     * ��ȡtarrifIndexNew���Ե�ֵ��
     * 
     */
    public int getTarrifIndexNew() {
        return tarrifIndexNew;
    }

    /**
     * ����tarrifIndexNew���Ե�ֵ��
     * 
     */
    public void setTarrifIndexNew(int value) {
        this.tarrifIndexNew = value;
    }

    /**
     * ��ȡkeyVersionCurrent���Ե�ֵ��
     * 
     */
    public int getKeyVersionCurrent() {
        return keyVersionCurrent;
    }

    /**
     * ����keyVersionCurrent���Ե�ֵ��
     * 
     */
    public void setKeyVersionCurrent(int value) {
        this.keyVersionCurrent = value;
    }

    /**
     * ��ȡkeyVersionNew���Ե�ֵ��
     * 
     */
    public int getKeyVersionNew() {
        return keyVersionNew;
    }

    /**
     * ����keyVersionNew���Ե�ֵ��
     * 
     */
    public void setKeyVersionNew(int value) {
        this.keyVersionNew = value;
    }

    /**
     * ��ȡtimeBaseLineCurrent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeBaseLineCurrent() {
        return timeBaseLineCurrent;
    }

    /**
     * ����timeBaseLineCurrent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeBaseLineCurrent(String value) {
        this.timeBaseLineCurrent = value;
    }

    /**
     * ��ȡtimeBaseLineNew���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeBaseLineNew() {
        return timeBaseLineNew;
    }

    /**
     * ����timeBaseLineNew���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeBaseLineNew(String value) {
        this.timeBaseLineNew = value;
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
     * ��ȡkeyChangeNums���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyChangeNums() {
        return keyChangeNums;
    }

    /**
     * ����keyChangeNums���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyChangeNums(String value) {
        this.keyChangeNums = value;
    }

}
