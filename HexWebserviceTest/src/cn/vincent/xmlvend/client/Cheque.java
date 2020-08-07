
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Cheque complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcheqAmt���Ե�ֵ��
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
     * ����cheqAmt���Ե�ֵ��
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
     * ��ȡaccHolderName���Ե�ֵ��
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
     * ����accHolderName���Ե�ֵ��
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
     * ��ȡaccHolderIDNo���Ե�ֵ��
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
     * ����accHolderIDNo���Ե�ֵ��
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
     * ��ȡcheqNo���Ե�ֵ��
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
     * ����cheqNo���Ե�ֵ��
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
     * ��ȡcheqType���Ե�ֵ��
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
     * ����cheqType���Ե�ֵ��
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
     * ��ȡmicr���Ե�ֵ��
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
     * ����micr���Ե�ֵ��
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
