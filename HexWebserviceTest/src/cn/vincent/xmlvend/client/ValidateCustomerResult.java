
package cn.vincent.xmlvend.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ValidateCustomerResult complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ValidateCustomerResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerRef" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CustomerType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="custAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="custLocRef" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vendorMaxVendAmt " type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="vendorMinVendAmt " type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateCustomerResult", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "statusDescription",
    "statusCode",
    "customerRef",
    "customerName",
    "customerType",
    "balance",
    "custAddress",
    "custLocRef",
    "mobile",
    "vendorMaxVendAmt0020",
    "vendorMinVendAmt0020"
})
public class ValidateCustomerResult {

    @XmlElement(required = true)
    protected String statusDescription;
    @XmlElement(required = true)
    protected String statusCode;
    @XmlElement(required = true)
    protected String customerRef;
    @XmlElement(required = true)
    protected String customerName;
    @XmlElement(name = "CustomerType", required = true)
    protected String customerType;
    @XmlElement(required = true)
    protected BigDecimal balance;
    @XmlElement(required = true)
    protected String custAddress;
    @XmlElement(required = true)
    protected String custLocRef;
    @XmlElement(required = true)
    protected String mobile;
    @XmlElement(name = "vendorMaxVendAmt ", required = true)
    protected BigDecimal vendorMaxVendAmt0020;
    @XmlElement(name = "vendorMinVendAmt ", required = true)
    protected BigDecimal vendorMinVendAmt0020;

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
     * ��ȡcustomerRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerRef() {
        return customerRef;
    }

    /**
     * ����customerRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerRef(String value) {
        this.customerRef = value;
    }

    /**
     * ��ȡcustomerName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * ����customerName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * ��ȡcustomerType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * ����customerType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerType(String value) {
        this.customerType = value;
    }

    /**
     * ��ȡbalance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * ����balance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBalance(BigDecimal value) {
        this.balance = value;
    }

    /**
     * ��ȡcustAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustAddress() {
        return custAddress;
    }

    /**
     * ����custAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustAddress(String value) {
        this.custAddress = value;
    }

    /**
     * ��ȡcustLocRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustLocRef() {
        return custLocRef;
    }

    /**
     * ����custLocRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustLocRef(String value) {
        this.custLocRef = value;
    }

    /**
     * ��ȡmobile���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * ����mobile���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * ��ȡvendorMaxVendAmt0020���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVendorMaxVendAmt_0020() {
        return vendorMaxVendAmt0020;
    }

    /**
     * ����vendorMaxVendAmt0020���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVendorMaxVendAmt_0020(BigDecimal value) {
        this.vendorMaxVendAmt0020 = value;
    }

    /**
     * ��ȡvendorMinVendAmt0020���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVendorMinVendAmt_0020() {
        return vendorMinVendAmt0020;
    }

    /**
     * ����vendorMinVendAmt0020���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVendorMinVendAmt_0020(BigDecimal value) {
        this.vendorMinVendAmt0020 = value;
    }

}
