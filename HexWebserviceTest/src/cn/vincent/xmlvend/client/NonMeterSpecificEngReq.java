
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Request for a non-Meter specific STS engineering token.
 * 		
 * 
 * <p>NonMeterSpecificEngReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NonMeterSpecificEngReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="meterType" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonMeterSpecificEngReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "meterType"
})
@XmlSeeAlso({
    DispInstPwrReq.class,
    DispKRNReq.class,
    DispTamperReq.class,
    DispPwrLmtReq.class,
    DispVerReq.class,
    DispPhUnbalanceReq.class,
    TestAllReq.class,
    DispTIReq.class,
    DispConsTotReq.class,
    TestBreakerReq.class,
    TestDisplayReq.class
})
public abstract class NonMeterSpecificEngReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected MeterType meterType;

    /**
     * 获取meterType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MeterType }
     *     
     */
    public MeterType getMeterType() {
        return meterType;
    }

    /**
     * 设置meterType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MeterType }
     *     
     */
    public void setMeterType(MeterType value) {
        this.meterType = value;
    }

}
