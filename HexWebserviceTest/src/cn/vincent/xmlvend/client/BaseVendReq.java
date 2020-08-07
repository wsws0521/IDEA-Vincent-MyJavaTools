
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BaseVendReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BaseVendReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="resource" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Resource"/>
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
@XmlType(name = "BaseVendReq", propOrder = {
    "resource",
    "idMethod"
})
@XmlSeeAlso({
    FreeIssueReq.class,
    CancelVendReq.class,
    FBEReq.class,
    MeterCreditTransferReq.class,
    AbstractCreditVendReq.class,
    MeterSpecificEngReq.class
})
public class BaseVendReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected Resource resource;
    @XmlElement(required = true)
    protected VendIDMethod idMethod;

    /**
     * ��ȡresource���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * ����resource���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setResource(Resource value) {
        this.resource = value;
    }

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
