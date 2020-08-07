
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispConsTotResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DispConsTotResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispConsTot" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispConsTotTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispConsTotResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispConsTot"
})
public class DispConsTotResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispConsTotTokenIssue dispConsTot;

    /**
     * ��ȡdispConsTot���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DispConsTotTokenIssue }
     *     
     */
    public DispConsTotTokenIssue getDispConsTot() {
        return dispConsTot;
    }

    /**
     * ����dispConsTot���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DispConsTotTokenIssue }
     *     
     */
    public void setDispConsTot(DispConsTotTokenIssue value) {
        this.dispConsTot = value;
    }

}
