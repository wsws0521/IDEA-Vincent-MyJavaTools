
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeKeyTokenSTS6 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MakeKeyTokenSTS6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meterNo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="supplyGroupCode_current" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="supplyGroupCode_new" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarrifIndex_current" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarrifIndex_new" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyVersion_current" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyExpired_current" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyVersion_new" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyExpired_new" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stsVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tct" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyRegister_current" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keyRegister_new" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "MakeKeyTokenSTS6", propOrder = {
    "meterNo",
    "supplyGroupCodeCurrent",
    "supplyGroupCodeNew",
    "tarrifIndexCurrent",
    "tarrifIndexNew",
    "keyVersionCurrent",
    "keyExpiredCurrent",
    "keyVersionNew",
    "keyExpiredNew",
    "stsVersion",
    "tct",
    "keyRegisterCurrent",
    "keyRegisterNew",
    "keyChangeNums"
})
public class MakeKeyTokenSTS6 {

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
    @XmlElement(name = "keyExpired_current")
    protected int keyExpiredCurrent;
    @XmlElement(name = "keyVersion_new")
    protected int keyVersionNew;
    @XmlElement(name = "keyExpired_new")
    protected int keyExpiredNew;
    protected int stsVersion;
    protected int tct;
    @XmlElement(name = "keyRegister_current")
    protected String keyRegisterCurrent;
    @XmlElement(name = "keyRegister_new")
    protected String keyRegisterNew;
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
     * ��ȡkeyExpiredCurrent���Ե�ֵ��
     * 
     */
    public int getKeyExpiredCurrent() {
        return keyExpiredCurrent;
    }

    /**
     * ����keyExpiredCurrent���Ե�ֵ��
     * 
     */
    public void setKeyExpiredCurrent(int value) {
        this.keyExpiredCurrent = value;
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
     * ��ȡkeyExpiredNew���Ե�ֵ��
     * 
     */
    public int getKeyExpiredNew() {
        return keyExpiredNew;
    }

    /**
     * ����keyExpiredNew���Ե�ֵ��
     * 
     */
    public void setKeyExpiredNew(int value) {
        this.keyExpiredNew = value;
    }

    /**
     * ��ȡstsVersion���Ե�ֵ��
     * 
     */
    public int getStsVersion() {
        return stsVersion;
    }

    /**
     * ����stsVersion���Ե�ֵ��
     * 
     */
    public void setStsVersion(int value) {
        this.stsVersion = value;
    }

    /**
     * ��ȡtct���Ե�ֵ��
     * 
     */
    public int getTct() {
        return tct;
    }

    /**
     * ����tct���Ե�ֵ��
     * 
     */
    public void setTct(int value) {
        this.tct = value;
    }

    /**
     * ��ȡkeyRegisterCurrent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyRegisterCurrent() {
        return keyRegisterCurrent;
    }

    /**
     * ����keyRegisterCurrent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyRegisterCurrent(String value) {
        this.keyRegisterCurrent = value;
    }

    /**
     * ��ȡkeyRegisterNew���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyRegisterNew() {
        return keyRegisterNew;
    }

    /**
     * ����keyRegisterNew���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyRegisterNew(String value) {
        this.keyRegisterNew = value;
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
