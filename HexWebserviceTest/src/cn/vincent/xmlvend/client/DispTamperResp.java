
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispTamperResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DispTamperResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispTamper" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispTamperTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispTamperResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispTamper"
})
public class DispTamperResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispTamperTokenIssue dispTamper;

    /**
     * ��ȡdispTamper���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DispTamperTokenIssue }
     *     
     */
    public DispTamperTokenIssue getDispTamper() {
        return dispTamper;
    }

    /**
     * ����dispTamper���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DispTamperTokenIssue }
     *     
     */
    public void setDispTamper(DispTamperTokenIssue value) {
        this.dispTamper = value;
    }

}
