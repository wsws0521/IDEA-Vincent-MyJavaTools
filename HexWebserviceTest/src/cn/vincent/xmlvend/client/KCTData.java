
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  The FROM and TO meter key data. 
 * 
 * <p>KCTData complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="KCTData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="fromSGC" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSSupplyGroupCode" />
 *       &lt;attribute name="fromKRN" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSKeyRevNo" />
 *       &lt;attribute name="fromTI" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSTariffIndex" />
 *       &lt;attribute name="toSGC" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSSupplyGroupCode" />
 *       &lt;attribute name="toKRN" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSKeyRevNo" />
 *       &lt;attribute name="toTI" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSTariffIndex" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KCTData")
public class KCTData {

    @XmlAttribute(name = "fromSGC", required = true)
    protected String fromSGC;
    @XmlAttribute(name = "fromKRN", required = true)
    protected String fromKRN;
    @XmlAttribute(name = "fromTI", required = true)
    protected String fromTI;
    @XmlAttribute(name = "toSGC", required = true)
    protected String toSGC;
    @XmlAttribute(name = "toKRN", required = true)
    protected String toKRN;
    @XmlAttribute(name = "toTI", required = true)
    protected String toTI;

    /**
     * ��ȡfromSGC���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromSGC() {
        return fromSGC;
    }

    /**
     * ����fromSGC���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromSGC(String value) {
        this.fromSGC = value;
    }

    /**
     * ��ȡfromKRN���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromKRN() {
        return fromKRN;
    }

    /**
     * ����fromKRN���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromKRN(String value) {
        this.fromKRN = value;
    }

    /**
     * ��ȡfromTI���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromTI() {
        return fromTI;
    }

    /**
     * ����fromTI���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromTI(String value) {
        this.fromTI = value;
    }

    /**
     * ��ȡtoSGC���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSGC() {
        return toSGC;
    }

    /**
     * ����toSGC���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSGC(String value) {
        this.toSGC = value;
    }

    /**
     * ��ȡtoKRN���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToKRN() {
        return toKRN;
    }

    /**
     * ����toKRN���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToKRN(String value) {
        this.toKRN = value;
    }

    /**
     * ��ȡtoTI���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToTI() {
        return toTI;
    }

    /**
     * ����toTI���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToTI(String value) {
        this.toTI = value;
    }

}
