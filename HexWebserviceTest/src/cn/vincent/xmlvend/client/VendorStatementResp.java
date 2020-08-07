
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to vendor statement request. Details last X
 * 				vendor statement
 * 				transactions on the vendors credit.
 * 			
 * 
 * <p>VendorStatementResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="VendorStatementResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="statement" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}VendorStatement"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendorStatementResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "statement"
})
public class VendorStatementResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected VendorStatement statement;

    /**
     * ��ȡstatement���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link VendorStatement }
     *     
     */
    public VendorStatement getStatement() {
        return statement;
    }

    /**
     * ����statement���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link VendorStatement }
     *     
     */
    public void setStatement(VendorStatement value) {
        this.statement = value;
    }

}
