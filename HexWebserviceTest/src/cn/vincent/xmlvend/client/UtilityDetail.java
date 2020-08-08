
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Details of the utility that is supply authority for the prepaid
 * 				resource. 
 * 
 * <p>UtilityDetail complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="UtilityDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}OrganisationName" />
 *       &lt;attribute name="address" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Address" />
 *       &lt;attribute name="taxRef" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}TaxRef" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtilityDetail")
public class UtilityDetail {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "address", required = true)
    protected String address;
    @XmlAttribute(name = "taxRef", required = true)
    protected String taxRef;

    /**
     * ��ȡname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * ����name���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * ��ȡaddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * ����address���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * ��ȡtaxRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxRef() {
        return taxRef;
    }

    /**
     * ����taxRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxRef(String value) {
        this.taxRef = value;
    }

}