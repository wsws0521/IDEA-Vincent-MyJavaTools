
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Request to reprint an already closed sales batch and
 * 				optionally any
 * 				children shift batch / batches. If the sales batch
 * 				seqno is not supplied then the
 * 				client's last closed sales batch is
 * 				returned.
 * 			
 * 
 * <p>ReprintEndSalesBatchReq complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReprintEndSalesBatchReq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ReprintEndBatchReq">
 *       &lt;sequence>
 *         &lt;element name="seqNo" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ShiftSalesBatchSeqNo" minOccurs="0"/>
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
@XmlType(name = "ReprintEndSalesBatchReq", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "seqNo",
    "all"
})
public class ReprintEndSalesBatchReq
    extends ReprintEndBatchReq
{

    protected String seqNo;
    @XmlElement(defaultValue = "true")
    protected Boolean all;

    /**
     * ��ȡseqNo���Ե�ֵ��
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
     * ����seqNo���Ե�ֵ��
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
     * ��ȡall���Ե�ֵ��
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
     * ����all���Ե�ֵ��
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
