
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeKeyToken complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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

}
