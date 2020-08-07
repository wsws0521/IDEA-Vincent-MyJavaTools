
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispConsTotResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DispConsTotResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispConsTot" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispConsTotTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispConsTotResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispConsTot"
})
public class DispConsTotResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispConsTotTokenIssue dispConsTot;

    /**
     * 获取dispConsTot属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DispConsTotTokenIssue }
     *     
     */
    public DispConsTotTokenIssue getDispConsTot() {
        return dispConsTot;
    }

    /**
     * 设置dispConsTot属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DispConsTotTokenIssue }
     *     
     */
    public void setDispConsTot(DispConsTotTokenIssue value) {
        this.dispConsTot = value;
    }

}
