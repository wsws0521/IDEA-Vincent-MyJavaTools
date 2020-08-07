
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Cash complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Cash">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PayType">
 *       &lt;sequence>
 *         &lt;element name="tenderAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cash", propOrder = {
    "tenderAmt"
})
public class Cash
    extends PayType
{

    @XmlElement(required = true)
    protected Currency tenderAmt;

    /**
     * 获取tenderAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getTenderAmt() {
        return tenderAmt;
    }

    /**
     * 设置tenderAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setTenderAmt(Currency value) {
        this.tenderAmt = value;
    }

}
