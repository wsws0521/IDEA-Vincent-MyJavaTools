
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to a request for default credit engineering token, contains the STS cipher to load the meter with default credit. 
 * 		
 * 
 * <p>DefCreditResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DefCreditResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngResp">
 *       &lt;sequence>
 *         &lt;element name="defCredit" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CreditTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefCreditResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "defCredit"
})
public class DefCreditResp
    extends MeterSpecificEngResp
{

    @XmlElement(required = true)
    protected CreditTokenIssue defCredit;

    /**
     * 获取defCredit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTokenIssue }
     *     
     */
    public CreditTokenIssue getDefCredit() {
        return defCredit;
    }

    /**
     * 设置defCredit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTokenIssue }
     *     
     */
    public void setDefCredit(CreditTokenIssue value) {
        this.defCredit = value;
    }

}
