
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Request to update a meters key data, from the current field data, to the data on the server. This request is a specialisation of BaseReq and not BaseVendReq, since only the "MeterConfig" identifiers are allowed.
 * 		
 * 
 * <p>UpdateMeterKeyReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="UpdateMeterKeyReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="idMethod" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterConfig"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateMeterKeyReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "idMethod"
})
public class UpdateMeterKeyReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected MeterConfig idMethod;

    /**
     * ��ȡidMethod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MeterConfig }
     *     
     */
    public MeterConfig getIdMethod() {
        return idMethod;
    }

    /**
     * ����idMethod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MeterConfig }
     *     
     */
    public void setIdMethod(MeterConfig value) {
        this.idMethod = value;
    }

}
