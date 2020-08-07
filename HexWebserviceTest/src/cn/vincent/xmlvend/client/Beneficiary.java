
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Contains the details of the beneficiary details for a
 * 				bank deposit.
 * 			
 * 
 * <p>Beneficiary complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Beneficiary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="accName" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PersonName" />
 *       &lt;attribute name="accNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AccountNo" />
 *       &lt;attribute name="branchCode" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BranchCode" />
 *       &lt;attribute name="bankName" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}OrganisationName" />
 *       &lt;attribute name="bankRegNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}BankRegNo" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Beneficiary", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema")
public class Beneficiary {

    @XmlAttribute(name = "accName", required = true)
    protected String accName;
    @XmlAttribute(name = "accNo", required = true)
    protected String accNo;
    @XmlAttribute(name = "branchCode", required = true)
    protected String branchCode;
    @XmlAttribute(name = "bankName", required = true)
    protected String bankName;
    @XmlAttribute(name = "bankRegNo", required = true)
    protected String bankRegNo;

    /**
     * ��ȡaccName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccName() {
        return accName;
    }

    /**
     * ����accName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccName(String value) {
        this.accName = value;
    }

    /**
     * ��ȡaccNo���Ե�ֵ��
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
     * ����accNo���Ե�ֵ��
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
     * ��ȡbranchCode���Ե�ֵ��
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
     * ����branchCode���Ե�ֵ��
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
     * ��ȡbankName���Ե�ֵ��
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
     * ����bankName���Ե�ֵ��
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
     * ��ȡbankRegNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankRegNo() {
        return bankRegNo;
    }

    /**
     * ����bankRegNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankRegNo(String value) {
        this.bankRegNo = value;
    }

}
