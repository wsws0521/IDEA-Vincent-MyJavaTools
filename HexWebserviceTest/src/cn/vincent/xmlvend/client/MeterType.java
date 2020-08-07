
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MeterType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MeterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="at" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSAT" />
 *       &lt;attribute name="tt" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSTT" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterType")
public class MeterType {

    @XmlAttribute(name = "at", required = true)
    protected String at;
    @XmlAttribute(name = "tt", required = true)
    protected String tt;

    /**
     * ��ȡat���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAt() {
        return at;
    }

    /**
     * ����at���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAt(String value) {
        this.at = value;
    }

    /**
     * ��ȡtt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTt() {
        return tt;
    }

    /**
     * ����tt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTt(String value) {
        this.tt = value;
    }

}
