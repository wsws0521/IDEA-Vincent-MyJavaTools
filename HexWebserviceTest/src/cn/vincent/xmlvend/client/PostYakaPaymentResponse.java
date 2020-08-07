
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PostYakaPaymentResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PostYakaPaymentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="postYakaPaymentResult" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}PostYakaPaymentResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostYakaPaymentResponse", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "postYakaPaymentResult"
})
public class PostYakaPaymentResponse {

    @XmlElement(required = true)
    protected PostYakaPaymentResult postYakaPaymentResult;

    /**
     * 获取postYakaPaymentResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PostYakaPaymentResult }
     *     
     */
    public PostYakaPaymentResult getPostYakaPaymentResult() {
        return postYakaPaymentResult;
    }

    /**
     * 设置postYakaPaymentResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PostYakaPaymentResult }
     *     
     */
    public void setPostYakaPaymentResult(PostYakaPaymentResult value) {
        this.postYakaPaymentResult = value;
    }

}
