
package cn.vincent.xmlvend.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PostYakaPaymentResult complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡlifeLine���Ե�ֵ��
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
     * ����lifeLine���Ե�ֵ��
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
     * ��ȡpayAccount���Ե�ֵ��
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
     * ����payAccount���Ե�ֵ��
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
     * ��ȡremainingCredit���Ե�ֵ��
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
     * ����remainingCredit���Ե�ֵ��
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
     * ��ȡdebtRecovery���Ե�ֵ��
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
     * ����debtRecovery���Ե�ֵ��
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
     * ��ȡarrearsBalance���Ե�ֵ��
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
     * ����arrearsBalance���Ե�ֵ��
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
     * ��ȡarrears���Ե�ֵ��
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
     * ����arrears���Ե�ֵ��
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
     * ��ȡreceiptNumber���Ե�ֵ��
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
     * ����receiptNumber���Ե�ֵ��
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
     * ��ȡstatusCode���Ե�ֵ��
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
     * ����statusCode���Ե�ֵ��
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
     * ��ȡstatusDescription���Ե�ֵ��
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
     * ����statusDescription���Ե�ֵ��
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
     * ��ȡmeterNumber���Ե�ֵ��
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
     * ����meterNumber���Ե�ֵ��
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
     * ��ȡunits���Ե�ֵ��
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
     * ����units���Ե�ֵ��
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
     * ��ȡtokenValue���Ե�ֵ��
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
     * ����tokenValue���Ե�ֵ��
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
     * ��ȡtariffCodeNumber���Ե�ֵ��
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
     * ����tariffCodeNumber���Ե�ֵ��
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
     * ��ȡtaxBase���Ե�ֵ��
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
     * ����taxBase���Ե�ֵ��
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
     * ��ȡtax���Ե�ֵ��
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
     * ����tax���Ե�ֵ��
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
     * ��ȡssf���Ե�ֵ��
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
     * ����ssf���Ե�ֵ��
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
     * ��ȡmaxDemandValue���Ե�ֵ��
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
     * ����maxDemandValue���Ե�ֵ��
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
     * ��ȡmaxDemandCharge���Ե�ֵ��
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
     * ����maxDemandCharge���Ե�ֵ��
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
     * ��ȡpenalty���Ե�ֵ��
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
     * ����penalty���Ե�ֵ��
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
     * ��ȡreward���Ե�ֵ��
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
     * ����reward���Ե�ֵ��
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
     * ��ȡprepaidToken���Ե�ֵ��
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
     * ����prepaidToken���Ե�ֵ��
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
     * ��ȡaccountPayAmount���Ե�ֵ��
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
     * ����accountPayAmount���Ե�ֵ��
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
     * ��ȡaccountSaveAmount���Ե�ֵ��
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
     * ����accountSaveAmount���Ե�ֵ��
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
     * ��ȡvendorTranId���Ե�ֵ��
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
     * ����vendorTranId���Ե�ֵ��
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
     * ��ȡvendorMinVendAmt���Ե�ֵ��
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
     * ����vendorMinVendAmt���Ե�ֵ��
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
     * ��ȡchange���Ե�ֵ��
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
     * ����change���Ե�ֵ��
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
