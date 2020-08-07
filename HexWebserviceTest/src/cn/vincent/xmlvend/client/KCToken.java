
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  A key change token, that consists of two STS tokens. 
 * 
 * <p>KCToken complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="KCToken">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Token">
 *       &lt;sequence>
 *         &lt;element name="set1stMeterKey" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STS1Token"/>
 *         &lt;element name="set2ndMeterKey" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STS1Token"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KCToken", propOrder = {
    "set1StMeterKey",
    "set2NdMeterKey"
})
public class KCToken
    extends Token
{

    @XmlElement(name = "set1stMeterKey", required = true)
    protected STS1Token set1StMeterKey;
    @XmlElement(name = "set2ndMeterKey", required = true)
    protected STS1Token set2NdMeterKey;

    /**
     * 获取set1StMeterKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link STS1Token }
     *     
     */
    public STS1Token getSet1StMeterKey() {
        return set1StMeterKey;
    }

    /**
     * 设置set1StMeterKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link STS1Token }
     *     
     */
    public void setSet1StMeterKey(STS1Token value) {
        this.set1StMeterKey = value;
    }

    /**
     * 获取set2NdMeterKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link STS1Token }
     *     
     */
    public STS1Token getSet2NdMeterKey() {
        return set2NdMeterKey;
    }

    /**
     * 设置set2NdMeterKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link STS1Token }
     *     
     */
    public void setSet2NdMeterKey(STS1Token value) {
        this.set2NdMeterKey = value;
    }

}
