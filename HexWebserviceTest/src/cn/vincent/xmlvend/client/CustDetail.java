
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Contains the details of customer. 
 * 
 * <p>CustDetail complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcontactNo���Ե�ֵ��
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
     * ����contactNo���Ե�ֵ��
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
     * ��ȡlocRef���Ե�ֵ��
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
     * ����locRef���Ե�ֵ��
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
