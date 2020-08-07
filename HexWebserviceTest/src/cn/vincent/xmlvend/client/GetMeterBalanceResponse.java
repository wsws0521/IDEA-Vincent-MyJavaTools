
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetMeterBalanceResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡgetMeterBalanceResult���Ե�ֵ��
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
     * ����getMeterBalanceResult���Ե�ֵ��
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
