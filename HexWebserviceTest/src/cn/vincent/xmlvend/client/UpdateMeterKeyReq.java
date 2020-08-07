
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
 * <p>UpdateMeterKeyReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取idMethod属性的值。
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
     * 设置idMethod属性的值。
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
