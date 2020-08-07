
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
 * <p>PwrLmtResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取pwrLmtToken属性的值。
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
     * 设置pwrLmtToken属性的值。
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
