
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ParentNode complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ParentNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parentNodeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nodeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParentNode", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "parentNodeId",
    "nodeType"
})
public class ParentNode {

    @XmlElement(required = true)
    protected String parentNodeId;
    @XmlElement(required = true)
    protected String nodeType;

    /**
     * ��ȡparentNodeId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentNodeId() {
        return parentNodeId;
    }

    /**
     * ����parentNodeId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentNodeId(String value) {
        this.parentNodeId = value;
    }

    /**
     * ��ȡnodeType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * ����nodeType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeType(String value) {
        this.nodeType = value;
    }

}
