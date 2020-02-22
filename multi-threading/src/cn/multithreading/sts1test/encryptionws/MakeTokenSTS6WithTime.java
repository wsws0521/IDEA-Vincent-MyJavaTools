
package cn.multithreading.sts1test.encryptionws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeTokenSTS6WithTime complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MakeTokenSTS6WithTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meterNo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="supplyGroupCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarrifIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyExpired" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transferAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="creditFunction" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeBaseLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stsVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tct" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyRegister" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tokenTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeTokenSTS6WithTime", propOrder = {
    "meterNo",
    "supplyGroupCode",
    "tarrifIndex",
    "keyVersion",
    "keyExpired",
    "transferAmount",
    "creditFunction",
    "timeBaseLine",
    "stsVersion",
    "tct",
    "keyRegister",
    "tokenTime"
})
public class MakeTokenSTS6WithTime {

    protected long meterNo;
    protected int supplyGroupCode;
    protected int tarrifIndex;
    protected int keyVersion;
    protected int keyExpired;
    protected BigDecimal transferAmount;
    protected int creditFunction;
    protected String timeBaseLine;
    protected int stsVersion;
    protected int tct;
    protected String keyRegister;
    protected String tokenTime;

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
     * 获取supplyGroupCode属性的值。
     * 
     */
    public int getSupplyGroupCode() {
        return supplyGroupCode;
    }

    /**
     * 设置supplyGroupCode属性的值。
     * 
     */
    public void setSupplyGroupCode(int value) {
        this.supplyGroupCode = value;
    }

    /**
     * 获取tarrifIndex属性的值。
     * 
     */
    public int getTarrifIndex() {
        return tarrifIndex;
    }

    /**
     * 设置tarrifIndex属性的值。
     * 
     */
    public void setTarrifIndex(int value) {
        this.tarrifIndex = value;
    }

    /**
     * 获取keyVersion属性的值。
     * 
     */
    public int getKeyVersion() {
        return keyVersion;
    }

    /**
     * 设置keyVersion属性的值。
     * 
     */
    public void setKeyVersion(int value) {
        this.keyVersion = value;
    }

    /**
     * 获取keyExpired属性的值。
     * 
     */
    public int getKeyExpired() {
        return keyExpired;
    }

    /**
     * 设置keyExpired属性的值。
     * 
     */
    public void setKeyExpired(int value) {
        this.keyExpired = value;
    }

    /**
     * 获取transferAmount属性的值。
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
     * 设置transferAmount属性的值。
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
     * 获取creditFunction属性的值。
     * 
     */
    public int getCreditFunction() {
        return creditFunction;
    }

    /**
     * 设置creditFunction属性的值。
     * 
     */
    public void setCreditFunction(int value) {
        this.creditFunction = value;
    }

    /**
     * 获取timeBaseLine属性的值。
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
     * 设置timeBaseLine属性的值。
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
     * 获取keyRegister属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyRegister() {
        return keyRegister;
    }

    /**
     * 设置keyRegister属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyRegister(String value) {
        this.keyRegister = value;
    }

    /**
     * 获取tokenTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenTime() {
        return tokenTime;
    }

    /**
     * 设置tokenTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenTime(String value) {
        this.tokenTime = value;
    }

}
