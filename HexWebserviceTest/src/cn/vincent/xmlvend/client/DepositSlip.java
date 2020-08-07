
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Information that is returned by the server that can
 * 				be used to create a
 * 				deposit on the client.
 * 			
 * 
 * <p>DepositSlip complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DepositSlip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Msg" minOccurs="0"/>
 *         &lt;element name="amt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *         &lt;element name="beneficiary" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Beneficiary" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="bankingRefNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}RefNo" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositSlip", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "header",
    "amt",
    "beneficiary"
})
public class DepositSlip {

    protected String header;
    @XmlElement(required = true)
    protected Currency amt;
    protected Beneficiary beneficiary;
    @XmlAttribute(name = "bankingRefNo", required = true)
    protected String bankingRefNo;

    /**
     * 获取header属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeader() {
        return header;
    }

    /**
     * 设置header属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeader(String value) {
        this.header = value;
    }

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setAmt(Currency value) {
        this.amt = value;
    }

    /**
     * 获取beneficiary属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Beneficiary }
     *     
     */
    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    /**
     * 设置beneficiary属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Beneficiary }
     *     
     */
    public void setBeneficiary(Beneficiary value) {
        this.beneficiary = value;
    }

    /**
     * 获取bankingRefNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankingRefNo() {
        return bankingRefNo;
    }

    /**
     * 设置bankingRefNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankingRefNo(String value) {
        this.bankingRefNo = value;
    }

}
