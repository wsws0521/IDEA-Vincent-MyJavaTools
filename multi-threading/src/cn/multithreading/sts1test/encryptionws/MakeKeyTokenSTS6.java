
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeKeyTokenSTS6 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取meterNo属性的值。
     * 
     */
    public long getMeterNo() {
        return meterNo;
    }

    /**
     * 设置meterNo属性的值。
     * 
     */
    public void setMeterNo(long value) {
        this.meterNo = value;
    }

    /**
     * 获取supplyGroupCodeCurrent属性的值。
     * 
     */
    public int getSupplyGroupCodeCurrent() {
        return supplyGroupCodeCurrent;
    }

    /**
     * 设置supplyGroupCodeCurrent属性的值。
     * 
     */
    public void setSupplyGroupCodeCurrent(int value) {
        this.supplyGroupCodeCurrent = value;
    }

    /**
     * 获取supplyGroupCodeNew属性的值。
     * 
     */
    public int getSupplyGroupCodeNew() {
        return supplyGroupCodeNew;
    }

    /**
     * 设置supplyGroupCodeNew属性的值。
     * 
     */
    public void setSupplyGroupCodeNew(int value) {
        this.supplyGroupCodeNew = value;
    }

    /**
     * 获取tarrifIndexCurrent属性的值。
     * 
     */
    public int getTarrifIndexCurrent() {
        return tarrifIndexCurrent;
    }

    /**
     * 设置tarrifIndexCurrent属性的值。
     * 
     */
    public void setTarrifIndexCurrent(int value) {
        this.tarrifIndexCurrent = value;
    }

    /**
     * 获取tarrifIndexNew属性的值。
     * 
     */
    public int getTarrifIndexNew() {
        return tarrifIndexNew;
    }

    /**
     * 设置tarrifIndexNew属性的值。
     * 
     */
    public void setTarrifIndexNew(int value) {
        this.tarrifIndexNew = value;
    }

    /**
     * 获取keyVersionCurrent属性的值。
     * 
     */
    public int getKeyVersionCurrent() {
        return keyVersionCurrent;
    }

    /**
     * 设置keyVersionCurrent属性的值。
     * 
     */
    public void setKeyVersionCurrent(int value) {
        this.keyVersionCurrent = value;
    }

    /**
     * 获取keyExpiredCurrent属性的值。
     * 
     */
    public int getKeyExpiredCurrent() {
        return keyExpiredCurrent;
    }

    /**
     * 设置keyExpiredCurrent属性的值。
     * 
     */
    public void setKeyExpiredCurrent(int value) {
        this.keyExpiredCurrent = value;
    }

    /**
     * 获取keyVersionNew属性的值。
     * 
     */
    public int getKeyVersionNew() {
        return keyVersionNew;
    }

    /**
     * 设置keyVersionNew属性的值。
     * 
     */
    public void setKeyVersionNew(int value) {
        this.keyVersionNew = value;
    }

    /**
     * 获取keyExpiredNew属性的值。
     * 
     */
    public int getKeyExpiredNew() {
        return keyExpiredNew;
    }

    /**
     * 设置keyExpiredNew属性的值。
     * 
     */
    public void setKeyExpiredNew(int value) {
        this.keyExpiredNew = value;
    }

    /**
     * 获取stsVersion属性的值。
     * 
     */
    public int getStsVersion() {
        return stsVersion;
    }

    /**
     * 设置stsVersion属性的值。
     * 
     */
    public void setStsVersion(int value) {
        this.stsVersion = value;
    }

    /**
     * 获取tct属性的值。
     * 
     */
    public int getTct() {
        return tct;
    }

    /**
     * 设置tct属性的值。
     * 
     */
    public void setTct(int value) {
        this.tct = value;
    }

    /**
     * 获取keyRegisterCurrent属性的值。
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
     * 设置keyRegisterCurrent属性的值。
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
     * 获取keyRegisterNew属性的值。
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
     * 设置keyRegisterNew属性的值。
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
     * 获取keyChangeNums属性的值。
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
     * 设置keyChangeNums属性的值。
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
