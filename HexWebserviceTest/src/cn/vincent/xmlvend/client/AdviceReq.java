
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request must be extended to advise the server to take an appropriate
 * 				action based on the outcome of previous use case on the client. 
 * 
 * <p>AdviceReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AdviceReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseReq">
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
@XmlType(name = "AdviceReq", propOrder = {
    "adviceReqMsgID"
})
@XmlSeeAlso({
    GetOrderStatusReq.class,
    ReversalAdviceReq.class,
    ConfirmationAdviceReq.class,
    LastRespAdviceReq.class
})
public abstract class AdviceReq
    extends BaseReq
{

    @XmlElement(required = true)
    protected MsgID adviceReqMsgID;

    /**
     * 获取adviceReqMsgID属性的值。
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
     * 设置adviceReqMsgID属性的值。
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
