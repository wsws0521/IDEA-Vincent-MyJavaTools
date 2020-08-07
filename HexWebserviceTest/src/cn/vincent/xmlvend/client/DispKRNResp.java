
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispKRNResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DispKRNResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispKRN" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispKRNTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispKRNResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispKRN"
})
public class DispKRNResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispKRNTokenIssue dispKRN;

    /**
     * ��ȡdispKRN���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DispKRNTokenIssue }
     *     
     */
    public DispKRNTokenIssue getDispKRN() {
        return dispKRN;
    }

    /**
     * ����dispKRN���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DispKRNTokenIssue }
     *     
     */
    public void setDispKRN(DispKRNTokenIssue value) {
        this.dispKRN = value;
    }

}
