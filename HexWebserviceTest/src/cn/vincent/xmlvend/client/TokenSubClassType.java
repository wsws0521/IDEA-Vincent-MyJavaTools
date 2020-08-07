
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Potential token sub class types, as per STS. 
 * 
 * <p>TokenSubClassType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TokenSubClassType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="credit" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CreditTokenSubClassType"/>
 *           &lt;element name="nonMeterManagement" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}NonMeterSpecificEng"/>
 *           &lt;element name="meterManagement" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterSpecificEng"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenSubClassType", propOrder = {
    "credit",
    "nonMeterManagement",
    "meterManagement"
})
public class TokenSubClassType {

    @XmlSchemaType(name = "string")
    protected CreditTokenSubClassType credit;
    @XmlSchemaType(name = "string")
    protected NonMeterSpecificEng nonMeterManagement;
    @XmlSchemaType(name = "string")
    protected MeterSpecificEng meterManagement;

    /**
     * 获取credit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTokenSubClassType }
     *     
     */
    public CreditTokenSubClassType getCredit() {
        return credit;
    }

    /**
     * 设置credit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTokenSubClassType }
     *     
     */
    public void setCredit(CreditTokenSubClassType value) {
        this.credit = value;
    }

    /**
     * 获取nonMeterManagement属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NonMeterSpecificEng }
     *     
     */
    public NonMeterSpecificEng getNonMeterManagement() {
        return nonMeterManagement;
    }

    /**
     * 设置nonMeterManagement属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NonMeterSpecificEng }
     *     
     */
    public void setNonMeterManagement(NonMeterSpecificEng value) {
        this.nonMeterManagement = value;
    }

    /**
     * 获取meterManagement属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MeterSpecificEng }
     *     
     */
    public MeterSpecificEng getMeterManagement() {
        return meterManagement;
    }

    /**
     * 设置meterManagement属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MeterSpecificEng }
     *     
     */
    public void setMeterManagement(MeterSpecificEng value) {
        this.meterManagement = value;
    }

}
