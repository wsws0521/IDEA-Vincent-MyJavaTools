
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Information returned with all Key Change Token issues. 
 * 
 * <p>KCTokenIssue complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KCTokenIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterSpecificEngTokenIssue">
 *       &lt;sequence>
 *         &lt;element name="kctData" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}KCTData"/>
 *         &lt;element name="pwrLmtToken" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PwrLmtTokenIssue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KCTokenIssue", propOrder = {
    "kctData",
    "pwrLmtToken"
})
public class KCTokenIssue
    extends MeterSpecificEngTokenIssue
{

    @XmlElement(required = true)
    protected KCTData kctData;
    protected PwrLmtTokenIssue pwrLmtToken;

    /**
     * 获取kctData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link KCTData }
     *     
     */
    public KCTData getKctData() {
        return kctData;
    }

    /**
     * 设置kctData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link KCTData }
     *     
     */
    public void setKctData(KCTData value) {
        this.kctData = value;
    }

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
