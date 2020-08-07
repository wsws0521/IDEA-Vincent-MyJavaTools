
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		A generic meter fault report, must be extended.
 * 		
 * 
 * <p>MeterFaultReport complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="MeterFaultReport">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}CustFaultReport">
 *       &lt;sequence>
 *         &lt;element name="meterInfo" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}VendIDMethod"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterFaultReport", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "meterInfo"
})
public class MeterFaultReport
    extends CustFaultReport
{

    @XmlElement(required = true)
    protected VendIDMethod meterInfo;

    /**
     * 获取meterInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VendIDMethod }
     *     
     */
    public VendIDMethod getMeterInfo() {
        return meterInfo;
    }

    /**
     * 设置meterInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VendIDMethod }
     *     
     */
    public void setMeterInfo(VendIDMethod value) {
        this.meterInfo = value;
    }

}
