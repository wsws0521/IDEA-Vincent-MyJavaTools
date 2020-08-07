
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispInstPwrResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DispInstPwrResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispInstPwr" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispInstPwrTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispInstPwrResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispInstPwr"
})
public class DispInstPwrResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispInstPwrTokenIssue dispInstPwr;

    /**
     * 获取dispInstPwr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DispInstPwrTokenIssue }
     *     
     */
    public DispInstPwrTokenIssue getDispInstPwr() {
        return dispInstPwr;
    }

    /**
     * 设置dispInstPwr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DispInstPwrTokenIssue }
     *     
     */
    public void setDispInstPwr(DispInstPwrTokenIssue value) {
        this.dispInstPwr = value;
    }

}
