
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
 * <p>PwrLmt complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡvalue���Ե�ֵ��
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
     * ����value���Ե�ֵ��
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
     * ��ȡsiUnit���Ե�ֵ��
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
     * ����siUnit���Ե�ֵ��
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
