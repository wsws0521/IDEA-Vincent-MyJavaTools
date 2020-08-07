
package cn.vincent.xmlvend.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PostYakaPaymentResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PostYakaPaymentResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lifeLine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="payAccount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="remainingCredit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="debtRecovery" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="arrearsBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="arrears" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="receiptNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="meterNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="units" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tokenValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tariffCodeNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxBase" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SSF" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="maxDemandValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="maxDemandCharge" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="penalty" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="reward" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="prepaidToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accountPayAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="accountSaveAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="vendorTranId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vendorMinVendAmt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="change" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostYakaPaymentResult", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "lifeLine",
    "payAccount",
    "remainingCredit",
    "debtRecovery",
    "arrearsBalance",
    "arrears",
    "receiptNumber",
    "statusCode",
    "statusDescription",
    "meterNumber",
    "units",
    "tokenValue",
    "tariffCodeNumber",
    "taxBase",
    "tax",
    "ssf",
    "maxDemandValue",
    "maxDemandCharge",
    "penalty",
    "reward",
    "prepaidToken",
    "accountPayAmount",
    "accountSaveAmount",
    "vendorTranId",
    "vendorMinVendAmt",
    "change"
})
public class PostYakaPaymentResult {

    @XmlElement(required = true)
    protected String lifeLine;
    @XmlElement(required = true)
    protected BigDecimal payAccount;
    @XmlElement(required = true)
    protected BigDecimal remainingCredit;
    @XmlElement(required = true)
    protected BigDecimal debtRecovery;
    @XmlElement(required = true)
    protected BigDecimal arrearsBalance;
    @XmlElement(required = true)
    protected BigDecimal arrears;
    @XmlElement(required = true)
    protected String receiptNumber;
    @XmlElement(required = true)
    protected String statusCode;
    @XmlElement(required = true)
    protected String statusDescription;
    @XmlElement(required = true)
    protected String meterNumber;
    @XmlElement(required = true)
    protected BigDecimal units;
    @XmlElement(required = true)
    protected BigDecimal tokenValue;
    @XmlElement(required = true)
    protected String tariffCodeNumber;
    @XmlElement(required = true)
    protected BigDecimal taxBase;
    @XmlElement(required = true)
    protected BigDecimal tax;
    @XmlElement(name = "SSF", required = true)
    protected BigDecimal ssf;
    @XmlElement(required = true)
    protected BigDecimal maxDemandValue;
    @XmlElement(required = true)
    protected BigDecimal maxDemandCharge;
    @XmlElement(required = true)
    protected BigDecimal penalty;
    @XmlElement(required = true)
    protected BigDecimal reward;
    @XmlElement(required = true)
    protected String prepaidToken;
    @XmlElement(required = true)
    protected BigDecimal accountPayAmount;
    @XmlElement(required = true)
    protected BigDecimal accountSaveAmount;
    @XmlElement(required = true)
    protected String vendorTranId;
    @XmlElement(required = true)
    protected BigDecimal vendorMinVendAmt;
    @XmlElement(required = true)
    protected BigDecimal change;

    /**
     * 获取lifeLine属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLifeLine() {
        return lifeLine;
    }

    /**
     * 设置lifeLine属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLifeLine(String value) {
        this.lifeLine = value;
    }

    /**
     * 获取payAccount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayAccount() {
        return payAccount;
    }

    /**
     * 设置payAccount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayAccount(BigDecimal value) {
        this.payAccount = value;
    }

    /**
     * 获取remainingCredit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRemainingCredit() {
        return remainingCredit;
    }

    /**
     * 设置remainingCredit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRemainingCredit(BigDecimal value) {
        this.remainingCredit = value;
    }

    /**
     * 获取debtRecovery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebtRecovery() {
        return debtRecovery;
    }

    /**
     * 设置debtRecovery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebtRecovery(BigDecimal value) {
        this.debtRecovery = value;
    }

    /**
     * 获取arrearsBalance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getArrearsBalance() {
        return arrearsBalance;
    }

    /**
     * 设置arrearsBalance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setArrearsBalance(BigDecimal value) {
        this.arrearsBalance = value;
    }

    /**
     * 获取arrears属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getArrears() {
        return arrears;
    }

    /**
     * 设置arrears属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setArrears(BigDecimal value) {
        this.arrears = value;
    }

    /**
     * 获取receiptNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * 设置receiptNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNumber(String value) {
        this.receiptNumber = value;
    }

    /**
     * 获取statusCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * 设置statusCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * 获取statusDescription属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * 设置statusDescription属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDescription(String value) {
        this.statusDescription = value;
    }

    /**
     * 获取meterNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterNumber() {
        return meterNumber;
    }

    /**
     * 设置meterNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterNumber(String value) {
        this.meterNumber = value;
    }

    /**
     * 获取units属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnits() {
        return units;
    }

    /**
     * 设置units属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnits(BigDecimal value) {
        this.units = value;
    }

    /**
     * 获取tokenValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTokenValue() {
        return tokenValue;
    }

    /**
     * 设置tokenValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTokenValue(BigDecimal value) {
        this.tokenValue = value;
    }

    /**
     * 获取tariffCodeNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffCodeNumber() {
        return tariffCodeNumber;
    }

    /**
     * 设置tariffCodeNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffCodeNumber(String value) {
        this.tariffCodeNumber = value;
    }

    /**
     * 获取taxBase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxBase() {
        return taxBase;
    }

    /**
     * 设置taxBase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxBase(BigDecimal value) {
        this.taxBase = value;
    }

    /**
     * 获取tax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * 设置tax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTax(BigDecimal value) {
        this.tax = value;
    }

    /**
     * 获取ssf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSSF() {
        return ssf;
    }

    /**
     * 设置ssf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSSF(BigDecimal value) {
        this.ssf = value;
    }

    /**
     * 获取maxDemandValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxDemandValue() {
        return maxDemandValue;
    }

    /**
     * 设置maxDemandValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxDemandValue(BigDecimal value) {
        this.maxDemandValue = value;
    }

    /**
     * 获取maxDemandCharge属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxDemandCharge() {
        return maxDemandCharge;
    }

    /**
     * 设置maxDemandCharge属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxDemandCharge(BigDecimal value) {
        this.maxDemandCharge = value;
    }

    /**
     * 获取penalty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPenalty() {
        return penalty;
    }

    /**
     * 设置penalty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPenalty(BigDecimal value) {
        this.penalty = value;
    }

    /**
     * 获取reward属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReward() {
        return reward;
    }

    /**
     * 设置reward属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReward(BigDecimal value) {
        this.reward = value;
    }

    /**
     * 获取prepaidToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrepaidToken() {
        return prepaidToken;
    }

    /**
     * 设置prepaidToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrepaidToken(String value) {
        this.prepaidToken = value;
    }

    /**
     * 获取accountPayAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccountPayAmount() {
        return accountPayAmount;
    }

    /**
     * 设置accountPayAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccountPayAmount(BigDecimal value) {
        this.accountPayAmount = value;
    }

    /**
     * 获取accountSaveAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccountSaveAmount() {
        return accountSaveAmount;
    }

    /**
     * 设置accountSaveAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccountSaveAmount(BigDecimal value) {
        this.accountSaveAmount = value;
    }

    /**
     * 获取vendorTranId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorTranId() {
        return vendorTranId;
    }

    /**
     * 设置vendorTranId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorTranId(String value) {
        this.vendorTranId = value;
    }

    /**
     * 获取vendorMinVendAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVendorMinVendAmt() {
        return vendorMinVendAmt;
    }

    /**
     * 设置vendorMinVendAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVendorMinVendAmt(BigDecimal value) {
        this.vendorMinVendAmt = value;
    }

    /**
     * 获取change属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChange() {
        return change;
    }

    /**
     * 设置change属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChange(BigDecimal value) {
        this.change = value;
    }

}
