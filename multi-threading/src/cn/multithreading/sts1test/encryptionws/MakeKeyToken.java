
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeKeyToken complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MakeKeyToken">
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeKeyToken", propOrder = {
    "meterNo",
    "supplyGroupCodeCurrent",
    "supplyGroupCodeNew",
    "tarrifIndexCurrent",
    "tarrifIndexNew",
    "keyVersionCurrent",
    "keyExpiredCurrent",
    "keyVersionNew",
    "keyExpiredNew"
})
public class MakeKeyToken {

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

}
