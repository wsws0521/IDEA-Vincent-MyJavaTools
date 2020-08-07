
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to reprint an already closed banking batch
 * 				and optionally any
 * 				children sales and shift batch / batches. If the
 * 				bank batch seqno is not supplied
 * 				then the client's last closed sales
 * 				batch is returned.
 * 			
 * 
 * <p>ReprintEndBankingBatchReq complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReprintEndBankingBatchReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ReprintEndBatchReq">
 *       &lt;sequence>
 *         &lt;element name="seqNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}BankBatchSeqNo" minOccurs="0"/>
 *         &lt;element name="all" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReprintEndBankingBatchReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "seqNo",
    "all"
})
public class ReprintEndBankingBatchReq
    extends ReprintEndBatchReq
{

    protected String seqNo;
    @XmlElement(defaultValue = "true")
    protected Boolean all;

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

    /**
     * 获取all属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAll() {
        return all;
    }

    /**
     * 设置all属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAll(Boolean value) {
        this.all = value;
    }

}
