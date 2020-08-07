
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ReversalAdviceResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡtxReversed���Ե�ֵ��
     * 
     */
    public boolean isTxReversed() {
        return txReversed;
    }

    /**
     * ����txReversed���Ե�ֵ��
     * 
     */
    public void setTxReversed(boolean value) {
        this.txReversed = value;
    }

}
