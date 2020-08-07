
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Contains the account number of the customer with a specific
 * 				organisation, usually the Utility - used as a search string. 
 * 
 * <p>CustAccountNo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustAccountNo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustIdentifier">
 *       &lt;sequence>
 *         &lt;element name="organisation" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}OrganisationName" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="accNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AccountNo" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustAccountNo", propOrder = {
    "organisation"
})
public class CustAccountNo
    extends CustIdentifier
{

    protected String organisation;
    @XmlAttribute(name = "accNo", required = true)
    protected String accNo;

    /**
     * 获取organisation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisation() {
        return organisation;
    }

    /**
     * 设置organisation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisation(String value) {
        this.organisation = value;
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

}
