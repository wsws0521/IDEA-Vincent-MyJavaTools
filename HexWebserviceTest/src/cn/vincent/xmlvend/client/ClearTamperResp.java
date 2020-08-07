
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a request for a clear tamper engineering token, contains the STS cipher to clear the tamper state of a meter.
 * 		
 * 
 * <p>ClearTamperResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClearTamperResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="clearTamper" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ClearTamperTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClearTamperResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "clearTamper"
})
public class ClearTamperResp
    extends MeterSpecificEngResp
{

    @XmlElement(required = true)
    protected ClearTamperTokenIssue clearTamper;

    /**
     * ��ȡclearTamper���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClearTamperTokenIssue }
     *     
     */
    public ClearTamperTokenIssue getClearTamper() {
        return clearTamper;
    }

    /**
     * ����clearTamper���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClearTamperTokenIssue }
     *     
     */
    public void setClearTamper(ClearTamperTokenIssue value) {
        this.clearTamper = value;
    }

}
