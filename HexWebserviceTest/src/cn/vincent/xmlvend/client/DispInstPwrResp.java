
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispInstPwrResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡdispInstPwr���Ե�ֵ��
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
     * ����dispInstPwr���Ե�ֵ��
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
