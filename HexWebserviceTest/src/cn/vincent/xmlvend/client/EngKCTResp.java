
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a request for a clear tamper engineering token, contains the STS ciphers to set update the SGC, KRN, TI of the meter. A power limit token may also be included. 
 * 		
 * 
 * <p>EngKCTResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="EngKCTResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="engKCToken" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}KCTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EngKCTResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "engKCToken"
})
public class EngKCTResp
    extends MeterSpecificEngResp
{

    @XmlElement(required = true)
    protected KCTokenIssue engKCToken;

    /**
     * ��ȡengKCToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link KCTokenIssue }
     *     
     */
    public KCTokenIssue getEngKCToken() {
        return engKCToken;
    }

    /**
     * ����engKCToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link KCTokenIssue }
     *     
     */
    public void setEngKCToken(KCTokenIssue value) {
        this.engKCToken = value;
    }

}
