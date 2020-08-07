
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispVerResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DispVerResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispVer" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispVerTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispVerResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispVer"
})
public class DispVerResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispVerTokenIssue dispVer;

    /**
     * ��ȡdispVer���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DispVerTokenIssue }
     *     
     */
    public DispVerTokenIssue getDispVer() {
        return dispVer;
    }

    /**
     * ����dispVer���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DispVerTokenIssue }
     *     
     */
    public void setDispVer(DispVerTokenIssue value) {
        this.dispVer = value;
    }

}
