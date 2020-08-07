
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a request for power limit engineering token, contains the STS cipher to the power limit of the meter.
 * 		
 * 
 * <p>PwrLmtResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PwrLmtResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="pwrLmtToken" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PwrLmtTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PwrLmtResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "pwrLmtToken"
})
public class PwrLmtResp
    extends MeterSpecificEngResp
{

    @XmlElement(required = true)
    protected PwrLmtTokenIssue pwrLmtToken;

    /**
     * ��ȡpwrLmtToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PwrLmtTokenIssue }
     *     
     */
    public PwrLmtTokenIssue getPwrLmtToken() {
        return pwrLmtToken;
    }

    /**
     * ����pwrLmtToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PwrLmtTokenIssue }
     *     
     */
    public void setPwrLmtToken(PwrLmtTokenIssue value) {
        this.pwrLmtToken = value;
    }

}
