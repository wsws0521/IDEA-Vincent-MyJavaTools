
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to confirmation advice. 
 * 
 * <p>ConfirmationAdviceResp complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ConfirmationAdviceResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}AdviceResp">
 *       &lt;attribute name="txConfirmed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmationAdviceResp")
public class ConfirmationAdviceResp
    extends AdviceResp
{

    @XmlAttribute(name = "txConfirmed", required = true)
    protected boolean txConfirmed;

    /**
     * 获取txConfirmed属性的值。
     * 
     */
    public boolean isTxConfirmed() {
        return txConfirmed;
    }

    /**
     * 设置txConfirmed属性的值。
     * 
     */
    public void setTxConfirmed(boolean value) {
        this.txConfirmed = value;
    }

}
