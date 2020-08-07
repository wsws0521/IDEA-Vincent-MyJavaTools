
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to reprint an already closed shift batch, if
 * 				the shift batch
 * 				seqno is not supplied then the client's last closed
 * 				shift batch is returned.
 * 			
 * 
 * <p>ReprintEndShiftBatchReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReprintEndShiftBatchReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ReprintEndBatchReq">
 *       &lt;sequence>
 *         &lt;element name="seqNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ShiftSalesBatchSeqNo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintEndShiftBatchReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "seqNo"
})
public class ReprintEndShiftBatchReq
    extends ReprintEndBatchReq
{

    protected String seqNo;

    /**
     * 获取seqNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqNo() {
        return seqNo;
    }

    /**
     * 设置seqNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqNo(String value) {
        this.seqNo = value;
    }

}
