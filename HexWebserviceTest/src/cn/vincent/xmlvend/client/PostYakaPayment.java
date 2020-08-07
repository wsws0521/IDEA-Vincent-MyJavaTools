
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PostYakaPayment complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PostYakaPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trans" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Trans"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostYakaPayment", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "trans"
})
public class PostYakaPayment {

    @XmlElement(required = true)
    protected Trans trans;

    /**
     * 获取trans属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Trans }
     *     
     */
    public Trans getTrans() {
        return trans;
    }

    /**
     * 设置trans属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Trans }
     *     
     */
    public void setTrans(Trans value) {
        this.trans = value;
    }

}
