
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Contains the details of customer. 
 * 
 * <p>CustDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PersonName" />
 *       &lt;attribute name="address" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Address" />
 *       &lt;attribute name="contactNo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ContactNo" />
 *       &lt;attribute name="accNo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AccountNo" />
 *       &lt;attribute name="locRef" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}LocRef" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustDetail")
@XmlSeeAlso({
    CustVendDetail.class
})
public class CustDetail {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "address", required = true)
    protected String address;
    @XmlAttribute(name = "contactNo")
    protected String contactNo;
    @XmlAttribute(name = "accNo")
    protected String accNo;
    @XmlAttribute(name = "locRef")
    protected String locRef;

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
     * 获取contactNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * 设置contactNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactNo(String value) {
        this.contactNo = value;
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
     * 获取locRef属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocRef() {
        return locRef;
    }

    /**
     * 设置locRef属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocRef(String value) {
        this.locRef = value;
    }

}
