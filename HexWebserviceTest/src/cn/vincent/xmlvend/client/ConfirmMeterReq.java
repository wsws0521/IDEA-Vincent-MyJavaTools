
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
 * <p>ConfirmMeterReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡidMethod���Ե�ֵ��
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
     * ����idMethod���Ե�ֵ��
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
