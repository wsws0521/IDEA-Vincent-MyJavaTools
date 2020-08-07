
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispVerResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DispVerResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispVer" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispVerTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispVerResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispVer"
})
public class DispVerResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispVerTokenIssue dispVer;

    /**
     * 获取dispVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DispVerTokenIssue }
     *     
     */
    public DispVerTokenIssue getDispVer() {
        return dispVer;
    }

    /**
     * 设置dispVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DispVerTokenIssue }
     *     
     */
    public void setDispVer(DispVerTokenIssue value) {
        this.dispVer = value;
    }

}
