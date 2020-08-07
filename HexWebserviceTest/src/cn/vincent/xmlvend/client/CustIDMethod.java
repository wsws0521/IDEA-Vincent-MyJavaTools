
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Identifier used to identify the customer. 
 * 
 * <p>CustIDMethod complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CustIDMethod">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}IDMethod">
 *       &lt;sequence>
 *         &lt;element name="custIdentifier" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustIdentifier"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustIDMethod", propOrder = {
    "custIdentifier"
})
public class CustIDMethod
    extends IDMethod
{

    @XmlElement(required = true)
    protected CustIdentifier custIdentifier;

    /**
     * ��ȡcustIdentifier���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CustIdentifier }
     *     
     */
    public CustIdentifier getCustIdentifier() {
        return custIdentifier;
    }

    /**
     * ����custIdentifier���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CustIdentifier }
     *     
     */
    public void setCustIdentifier(CustIdentifier value) {
        this.custIdentifier = value;
    }

}
