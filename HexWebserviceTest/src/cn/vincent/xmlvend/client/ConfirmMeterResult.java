
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ConfirmMeterResult complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ConfirmMeterResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meterDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterDetail"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmMeterResult", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "meterDetail"
})
public class ConfirmMeterResult {

    @XmlElement(required = true)
    protected MeterDetail meterDetail;

    /**
     * ��ȡmeterDetail���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MeterDetail }
     *     
     */
    public MeterDetail getMeterDetail() {
        return meterDetail;
    }

    /**
     * ����meterDetail���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MeterDetail }
     *     
     */
    public void setMeterDetail(MeterDetail value) {
        this.meterDetail = value;
    }

}
