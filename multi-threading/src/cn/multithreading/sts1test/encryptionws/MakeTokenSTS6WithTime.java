
package cn.multithreading.sts1test.encryptionws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MakeTokenSTS6WithTime complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡkeyExpired���Ե�ֵ��
     * 
     */
    public int getKeyExpired() {
        return keyExpired;
    }

    /**
     * ����keyExpired���Ե�ֵ��
     * 
     */
    public void setKeyExpired(int value) {
        this.keyExpired = value;
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
     * ��ȡcreditFunction���Ե�ֵ��
     * 
     */
    public int getCreditFunction() {
        return creditFunction;
    }

    /**
     * ����creditFunction���Ե�ֵ��
     * 
     */
    public void setCreditFunction(int value) {
        this.creditFunction = value;
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
     * ��ȡkeyRegister���Ե�ֵ��
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
     * ����keyRegister���Ե�ֵ��
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
     * ��ȡtokenTime���Ե�ֵ��
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
     * ����tokenTime���Ե�ֵ��
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