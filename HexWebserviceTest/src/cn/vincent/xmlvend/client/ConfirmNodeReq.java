
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ConfirmNodeReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ConfirmNodeReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
 *       &lt;sequence>
 *         &lt;element name="parentNode" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ParentNode"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmNodeReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "parentNode"
})
public class ConfirmNodeReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected ParentNode parentNode;

    /**
     * ��ȡparentNode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ParentNode }
     *     
     */
    public ParentNode getParentNode() {
        return parentNode;
    }

    /**
     * ����parentNode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ParentNode }
     *     
     */
    public void setParentNode(ParentNode value) {
        this.parentNode = value;
    }

}
