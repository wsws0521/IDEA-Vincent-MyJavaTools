
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Request to obtain a engineering power limit token.
 * 		
 * 
 * <p>PwrLmtReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PwrLmtReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngReq">
 *       &lt;sequence>
 *         &lt;element name="pwrLmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PwrLmt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PwrLmtReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "pwrLmt"
})
public class PwrLmtReq
    extends MeterSpecificEngReq
{

    @XmlElement(required = true)
    protected PwrLmt pwrLmt;

    /**
     * ��ȡpwrLmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PwrLmt }
     *     
     */
    public PwrLmt getPwrLmt() {
        return pwrLmt;
    }

    /**
     * ����pwrLmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PwrLmt }
     *     
     */
    public void setPwrLmt(PwrLmt value) {
        this.pwrLmt = value;
    }

}
