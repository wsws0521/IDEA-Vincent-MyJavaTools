
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		A response containing meter details.
 * 		
 * 
 * <p>ConfirmMeterResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ConfirmMeterResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="confirmMeterResult" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}ConfirmMeterResult"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmMeterResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "confirmMeterResult"
})
public class ConfirmMeterResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected ConfirmMeterResult confirmMeterResult;

    /**
     * 获取confirmMeterResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ConfirmMeterResult }
     *     
     */
    public ConfirmMeterResult getConfirmMeterResult() {
        return confirmMeterResult;
    }

    /**
     * 设置confirmMeterResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ConfirmMeterResult }
     *     
     */
    public void setConfirmMeterResult(ConfirmMeterResult value) {
        this.confirmMeterResult = value;
    }

}
