
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispPhUnbalanceResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DispPhUnbalanceResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispPhUnbalance" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispPhUnbalanceTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispPhUnbalanceResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispPhUnbalance"
})
public class DispPhUnbalanceResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispPhUnbalanceTokenIssue dispPhUnbalance;

    /**
     * 获取dispPhUnbalance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DispPhUnbalanceTokenIssue }
     *     
     */
    public DispPhUnbalanceTokenIssue getDispPhUnbalance() {
        return dispPhUnbalance;
    }

    /**
     * 设置dispPhUnbalance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DispPhUnbalanceTokenIssue }
     *     
     */
    public void setDispPhUnbalance(DispPhUnbalanceTokenIssue value) {
        this.dispPhUnbalance = value;
    }

}
