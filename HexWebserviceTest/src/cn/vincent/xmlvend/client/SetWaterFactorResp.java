
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a request for a water factor engineering token, contains the STS cipher to set the water factor of the meter.
 * 		
 * 
 * <p>SetWaterFactorResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SetWaterFactorResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="waterFactor" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}WaterFactorTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetWaterFactorResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "waterFactor"
})
public class SetWaterFactorResp
    extends MeterSpecificEngResp
{

    @XmlElement(required = true)
    protected WaterFactorTokenIssue waterFactor;

    /**
     * 获取waterFactor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WaterFactorTokenIssue }
     *     
     */
    public WaterFactorTokenIssue getWaterFactor() {
        return waterFactor;
    }

    /**
     * 设置waterFactor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WaterFactorTokenIssue }
     *     
     */
    public void setWaterFactor(WaterFactorTokenIssue value) {
        this.waterFactor = value;
    }

}
