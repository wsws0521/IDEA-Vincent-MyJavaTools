
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  This identifier is typically used to identify the meter where the
 * 				requested token will be entered. 
 * 
 * <p>VendIDMethod complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="VendIDMethod">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}IDMethod">
 *       &lt;sequence>
 *         &lt;element name="meterIdentifier" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterIdentifier"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendIDMethod", propOrder = {
    "meterIdentifier"
})
public class VendIDMethod
    extends IDMethod
{

    @XmlElement(required = true)
    protected MeterIdentifier meterIdentifier;

    /**
     * 获取meterIdentifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MeterIdentifier }
     *     
     */
    public MeterIdentifier getMeterIdentifier() {
        return meterIdentifier;
    }

    /**
     * 设置meterIdentifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MeterIdentifier }
     *     
     */
    public void setMeterIdentifier(MeterIdentifier value) {
        this.meterIdentifier = value;
    }

}
