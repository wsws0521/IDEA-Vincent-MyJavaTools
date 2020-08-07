
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a request for phase unbalance engineering token, contains the STS cipher to set the phase unbalance of the meter.
 * 		
 * 
 * <p>PhUnbalResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PhUnbalResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="phUnbalance" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PhUnbalTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhUnbalResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "phUnbalance"
})
public class PhUnbalResp
    extends MeterSpecificEngResp
{

    @XmlElement(required = true)
    protected PhUnbalTokenIssue phUnbalance;

    /**
     * ��ȡphUnbalance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PhUnbalTokenIssue }
     *     
     */
    public PhUnbalTokenIssue getPhUnbalance() {
        return phUnbalance;
    }

    /**
     * ����phUnbalance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PhUnbalTokenIssue }
     *     
     */
    public void setPhUnbalance(PhUnbalTokenIssue value) {
        this.phUnbalance = value;
    }

}
