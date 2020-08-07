
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Details of the utility that is supply authority for the prepaid
 * 				resource. 
 * 
 * <p>UtilityDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取name属性的值。
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
     * 设置name属性的值。
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
     * 获取address属性的值。
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
     * 设置address属性的值。
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
     * 获取taxRef属性的值。
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
     * 设置taxRef属性的值。
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
