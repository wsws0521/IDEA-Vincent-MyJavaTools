
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ReversalAdviceResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReversalAdviceResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AdviceResp">
 *       &lt;attribute name="txReversed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalAdviceResp")
public class ReversalAdviceResp
    extends AdviceResp
{

    @XmlAttribute(name = "txReversed", required = true)
    protected boolean txReversed;

    /**
     * 获取txReversed属性的值。
     * 
     */
    public boolean isTxReversed() {
        return txReversed;
    }

    /**
     * 设置txReversed属性的值。
     * 
     */
    public void setTxReversed(boolean value) {
        this.txReversed = value;
    }

}
