
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Power limit of the meter in kilowatts. The siUnit is kW.
 * 			
 * 
 * <p>PwrLmt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PwrLmt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="value" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PwrLmtValue" />
 *       &lt;attribute name="siUnit" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ResourceSIUnit" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PwrLmt")
public class PwrLmt {

    @XmlAttribute(name = "value", required = true)
    protected String value;
    @XmlAttribute(name = "siUnit", required = true)
    protected String siUnit;

    /**
     * 获取value属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取siUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiUnit() {
        return siUnit;
    }

    /**
     * 设置siUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiUnit(String value) {
        this.siUnit = value;
    }

}
