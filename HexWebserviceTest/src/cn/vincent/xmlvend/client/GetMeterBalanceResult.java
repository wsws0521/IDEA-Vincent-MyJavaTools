
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetMeterBalanceResult complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GetMeterBalanceResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meterBalance" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterBalance"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMeterBalanceResult", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "meterBalance"
})
public class GetMeterBalanceResult {

    @XmlElement(required = true)
    protected MeterBalance meterBalance;

    /**
     * ��ȡmeterBalance���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MeterBalance }
     *     
     */
    public MeterBalance getMeterBalance() {
        return meterBalance;
    }

    /**
     * ����meterBalance���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MeterBalance }
     *     
     */
    public void setMeterBalance(MeterBalance value) {
        this.meterBalance = value;
    }

}
