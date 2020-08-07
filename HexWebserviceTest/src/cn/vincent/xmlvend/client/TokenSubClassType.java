
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Potential token sub class types, as per STS. 
 * 
 * <p>TokenSubClassType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcredit���Ե�ֵ��
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
     * ����credit���Ե�ֵ��
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
     * ��ȡnonMeterManagement���Ե�ֵ��
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
     * ����nonMeterManagement���Ե�ֵ��
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
     * ��ȡmeterManagement���Ե�ֵ��
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
     * ����meterManagement���Ե�ֵ��
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
