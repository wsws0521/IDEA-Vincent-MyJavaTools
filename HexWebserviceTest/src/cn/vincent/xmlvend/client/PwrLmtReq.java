
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
 * <p>PwrLmtReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
