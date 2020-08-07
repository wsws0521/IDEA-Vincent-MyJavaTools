
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Request to obtain a water factor engineering token.
 * 		
 * 
 * <p>SetWaterFactorReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SetWaterFactorReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngReq">
 *       &lt;sequence>
 *         &lt;element name="waterFactor" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}WaterFactor"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetWaterFactorReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "waterFactor"
})
public class SetWaterFactorReq
    extends MeterSpecificEngReq
{

    @XmlElement(required = true)
    protected String waterFactor;

    /**
     * 获取waterFactor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaterFactor() {
        return waterFactor;
    }

    /**
     * 设置waterFactor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaterFactor(String value) {
        this.waterFactor = value;
    }

}
