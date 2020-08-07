
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PostYakaPaymentResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡpostYakaPaymentResult���Ե�ֵ��
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
     * ����postYakaPaymentResult���Ե�ֵ��
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
