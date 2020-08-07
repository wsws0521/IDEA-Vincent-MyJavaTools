
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  The meter configuration information as obtained from the meter card, as
 * 				per NRS009-4-1. 
 * 
 * <p>MeterCard complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MeterCard">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterConfig">
 *       &lt;sequence>
 *         &lt;element name="track2Data" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}NRSTrack2Data"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterCard", propOrder = {
    "track2Data"
})
public class MeterCard
    extends MeterConfig
{

    @XmlElement(required = true)
    protected String track2Data;

    /**
     * ��ȡtrack2Data���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack2Data() {
        return track2Data;
    }

    /**
     * ����track2Data���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack2Data(String value) {
        this.track2Data = value;
    }

}
