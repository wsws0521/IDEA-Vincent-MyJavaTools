
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Request to obtain a key change engineering token. Allows the FROM and TO meter key data to be specified.
 * 		
 * 
 * <p>EngKCTReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EngKCTReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}MeterSpecificEngReq">
 *       &lt;sequence>
 *         &lt;element name="kctData" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}KCTData"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EngKCTReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "kctData"
})
public class EngKCTReq
    extends MeterSpecificEngReq
{

    @XmlElement(required = true)
    protected KCTData kctData;

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

}
