
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Details of the power limit token being issued. 
 * 
 * <p>PwrLmtTokenIssue complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PwrLmtTokenIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterSpecificEngTokenIssue">
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
@XmlType(name = "PwrLmtTokenIssue", propOrder = {
    "pwrLmt"
})
public class PwrLmtTokenIssue
    extends MeterSpecificEngTokenIssue
{

    @XmlElement(required = true)
    protected PwrLmt pwrLmt;

    /**
     * 获取pwrLmt属性的值。
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
     * 设置pwrLmt属性的值。
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
