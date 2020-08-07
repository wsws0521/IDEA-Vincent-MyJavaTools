
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
 * <p>ClearCreditResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取clearCredit属性的值。
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
     * 设置clearCredit属性的值。
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
