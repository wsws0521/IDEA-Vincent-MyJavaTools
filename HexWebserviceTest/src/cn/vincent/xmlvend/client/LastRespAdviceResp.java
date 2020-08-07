
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to lastResponse advice request, contains the complete last
 * 				response message sent by the server to this client. 
 * 
 * <p>LastRespAdviceResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LastRespAdviceResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AdviceResp">
 *       &lt;sequence>
 *         &lt;element name="lastResponse" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LastRespAdviceResp", propOrder = {
    "lastResponse"
})
public class LastRespAdviceResp
    extends AdviceResp
{

    @XmlElement(required = true)
    protected BaseResp lastResponse;

    /**
     * ��ȡlastResponse���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BaseResp }
     *     
     */
    public BaseResp getLastResponse() {
        return lastResponse;
    }

    /**
     * ����lastResponse���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BaseResp }
     *     
     */
    public void setLastResponse(BaseResp value) {
        this.lastResponse = value;
    }

}
