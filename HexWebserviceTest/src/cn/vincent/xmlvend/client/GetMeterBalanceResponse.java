
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetMeterBalanceResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetMeterBalanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getMeterBalanceResult" type="{http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema}GetMeterBalanceResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMeterBalanceResponse", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "getMeterBalanceResult"
})
public class GetMeterBalanceResponse {

    @XmlElement(required = true)
    protected GetMeterBalanceResult getMeterBalanceResult;

    /**
     * 获取getMeterBalanceResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GetMeterBalanceResult }
     *     
     */
    public GetMeterBalanceResult getGetMeterBalanceResult() {
        return getMeterBalanceResult;
    }

    /**
     * 设置getMeterBalanceResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GetMeterBalanceResult }
     *     
     */
    public void setGetMeterBalanceResult(GetMeterBalanceResult value) {
        this.getMeterBalanceResult = value;
    }

}
