
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a request for clear credit engineering token, contains the STS cipher to clear the meters credit.
 * 		
 * 
 * <p>ClearCreditResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClearCreditResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="clearCredit" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ClearCreditTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClearCreditResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "clearCredit"
})
public class ClearCreditResp
    extends MeterSpecificEngResp
{

    @XmlElement(required = true)
    protected ClearCreditTokenIssue clearCredit;

    /**
     * ��ȡclearCredit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClearCreditTokenIssue }
     *     
     */
    public ClearCreditTokenIssue getClearCredit() {
        return clearCredit;
    }

    /**
     * ����clearCredit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClearCreditTokenIssue }
     *     
     */
    public void setClearCredit(ClearCreditTokenIssue value) {
        this.clearCredit = value;
    }

}
