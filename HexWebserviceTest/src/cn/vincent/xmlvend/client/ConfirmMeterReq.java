
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			A request to obtain meter details.
 * 			
 * 
 * <p>ConfirmMeterReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ConfirmMeterReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="idMethod" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}VendIDMethod"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmMeterReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "idMethod"
})
public class ConfirmMeterReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected VendIDMethod idMethod;

    /**
     * 获取idMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VendIDMethod }
     *     
     */
    public VendIDMethod getIdMethod() {
        return idMethod;
    }

    /**
     * 设置idMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VendIDMethod }
     *     
     */
    public void setIdMethod(VendIDMethod value) {
        this.idMethod = value;
    }

}
