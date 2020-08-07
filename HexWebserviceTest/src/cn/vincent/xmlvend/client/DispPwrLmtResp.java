
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DispPwrLmtResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取dispPwrLmt属性的值。
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
     * 设置dispPwrLmt属性的值。
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
