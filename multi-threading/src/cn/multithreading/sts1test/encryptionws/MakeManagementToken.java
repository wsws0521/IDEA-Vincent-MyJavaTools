
package cn.multithreading.sts1test.encryptionws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeManagementToken complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MakeManagementToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meterNo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="supplyGroupCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarrifIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keyExpired" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="managementFunction" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transferAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeManagementToken", propOrder = {
    "meterNo",
    "supplyGroupCode",
    "tarrifIndex",
    "keyVersion",
    "keyExpired",
    "managementFunction",
    "transferAmount"
})
public class MakeManagementToken {

    protected long meterNo;
    protected int supplyGroupCode;
    protected int tarrifIndex;
    protected int keyVersion;
    protected int keyExpired;
    protected int managementFunction;
    protected BigDecimal transferAmount;

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
     * 获取managementFunction属性的值。
     * 
     */
    public int getManagementFunction() {
        return managementFunction;
    }

    /**
     * 设置managementFunction属性的值。
     * 
     */
    public void setManagementFunction(int value) {
        this.managementFunction = value;
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

}
