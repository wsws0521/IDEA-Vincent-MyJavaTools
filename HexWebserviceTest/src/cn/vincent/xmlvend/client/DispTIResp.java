
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispTIResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DispTIResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispTI" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispTITokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispTIResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispTI"
})
public class DispTIResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispTITokenIssue dispTI;

    /**
     * ��ȡdispTI���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DispTITokenIssue }
     *     
     */
    public DispTITokenIssue getDispTI() {
        return dispTI;
    }

    /**
     * ����dispTI���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DispTITokenIssue }
     *     
     */
    public void setDispTI(DispTITokenIssue value) {
        this.dispTI = value;
    }

}
