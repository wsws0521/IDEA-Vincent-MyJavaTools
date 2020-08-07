
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Response to advice request. Confirming that the advice has been
 * 				processed by the server. 
 * 
 * <p>AdviceResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AdviceResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="adviceReqMsgID" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MsgID"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdviceResp", propOrder = {
    "adviceReqMsgID"
})
@XmlSeeAlso({
    LastRespAdviceResp.class,
    ConfirmationAdviceResp.class,
    ReversalAdviceResp.class
})
public abstract class AdviceResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected MsgID adviceReqMsgID;

    /**
     * ��ȡadviceReqMsgID���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MsgID }
     *     
     */
    public MsgID getAdviceReqMsgID() {
        return adviceReqMsgID;
    }

    /**
     * ����adviceReqMsgID���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MsgID }
     *     
     */
    public void setAdviceReqMsgID(MsgID value) {
        this.adviceReqMsgID = value;
    }

}
