
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
 * <p>VendorStatementResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取statement属性的值。
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
     * 设置statement属性的值。
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
