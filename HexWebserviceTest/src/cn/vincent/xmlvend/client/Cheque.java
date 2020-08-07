
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Cheque complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Cheque">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PayType">
 *       &lt;sequence>
 *         &lt;element name="cheqAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *         &lt;element name="accHolderName" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PersonName"/>
 *         &lt;element name="accHolderIDNo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}IDNo"/>
 *         &lt;element name="accNo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AccountNo"/>
 *         &lt;element name="bankName" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}OrganisationName"/>
 *         &lt;element name="branchCode" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BranchCode"/>
 *         &lt;element name="cheqNo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ChequeNo"/>
 *         &lt;element name="cheqType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ChequeType"/>
 *         &lt;element name="micr" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MICR" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cheque", propOrder = {
    "cheqAmt",
    "accHolderName",
    "accHolderIDNo",
    "accNo",
    "bankName",
    "branchCode",
    "cheqNo",
    "cheqType",
    "micr"
})
public class Cheque
    extends PayType
{

    @XmlElement(required = true)
    protected Currency cheqAmt;
    @XmlElement(required = true)
    protected String accHolderName;
    @XmlElement(required = true)
    protected String accHolderIDNo;
    @XmlElement(required = true)
    protected String accNo;
    @XmlElement(required = true)
    protected String bankName;
    @XmlElement(required = true)
    protected String branchCode;
    @XmlElement(required = true)
    protected String cheqNo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ChequeType cheqType;
    protected String micr;

    /**
     * 获取cheqAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCheqAmt() {
        return cheqAmt;
    }

    /**
     * 设置cheqAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCheqAmt(Currency value) {
        this.cheqAmt = value;
    }

    /**
     * 获取accHolderName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccHolderName() {
        return accHolderName;
    }

    /**
     * 设置accHolderName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccHolderName(String value) {
        this.accHolderName = value;
    }

    /**
     * 获取accHolderIDNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccHolderIDNo() {
        return accHolderIDNo;
    }

    /**
     * 设置accHolderIDNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccHolderIDNo(String value) {
        this.accHolderIDNo = value;
    }

    /**
     * 获取accNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccNo() {
        return accNo;
    }

    /**
     * 设置accNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccNo(String value) {
        this.accNo = value;
    }

    /**
     * 获取bankName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置bankName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * 获取branchCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * 设置branchCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
    }

    /**
     * 获取cheqNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheqNo() {
        return cheqNo;
    }

    /**
     * 设置cheqNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheqNo(String value) {
        this.cheqNo = value;
    }

    /**
     * 获取cheqType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChequeType }
     *     
     */
    public ChequeType getCheqType() {
        return cheqType;
    }

    /**
     * 设置cheqType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeType }
     *     
     */
    public void setCheqType(ChequeType value) {
        this.cheqType = value;
    }

    /**
     * 获取micr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMicr() {
        return micr;
    }

    /**
     * 设置micr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMicr(String value) {
        this.micr = value;
    }

}
