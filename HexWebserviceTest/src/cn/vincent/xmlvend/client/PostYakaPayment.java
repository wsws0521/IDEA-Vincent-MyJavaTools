
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PostYakaPayment complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡtrans���Ե�ֵ��
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
     * ����trans���Ե�ֵ��
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
