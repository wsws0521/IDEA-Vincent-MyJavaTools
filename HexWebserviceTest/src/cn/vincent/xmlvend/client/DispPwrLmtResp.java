
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispPwrLmtResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DispPwrLmtResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}NonMeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="dispPwrLmt" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}DispPwrLmtTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispPwrLmtResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "dispPwrLmt"
})
public class DispPwrLmtResp
    extends NonMeterSpecificEngResp
{

    @XmlElement(required = true)
    protected DispPwrLmtTokenIssue dispPwrLmt;

    /**
     * ��ȡdispPwrLmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DispPwrLmtTokenIssue }
     *     
     */
    public DispPwrLmtTokenIssue getDispPwrLmt() {
        return dispPwrLmt;
    }

    /**
     * ����dispPwrLmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DispPwrLmtTokenIssue }
     *     
     */
    public void setDispPwrLmt(DispPwrLmtTokenIssue value) {
        this.dispPwrLmt = value;
    }

}
