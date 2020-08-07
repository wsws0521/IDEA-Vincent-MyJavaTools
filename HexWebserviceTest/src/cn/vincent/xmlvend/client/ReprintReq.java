
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  A request to obtain the reprint of transaction/s.
 * 			
 * 
 * <p>ReprintReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReprintReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="idMethod" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}IDMethod"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "idMethod"
})
public class ReprintReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected IDMethod idMethod;

    /**
     * ��ȡidMethod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link IDMethod }
     *     
     */
    public IDMethod getIdMethod() {
        return idMethod;
    }

    /**
     * ����idMethod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link IDMethod }
     *     
     */
    public void setIdMethod(IDMethod value) {
        this.idMethod = value;
    }

}
