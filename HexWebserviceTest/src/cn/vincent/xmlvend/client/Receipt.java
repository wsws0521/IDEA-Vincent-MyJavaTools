
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Generic information that is contained in receipts
 * 				that are returned by
 * 				the server.
 * 			
 * 
 * <p>Receipt complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Receipt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transactions" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}Transactions"/>
 *       &lt;/sequence>
 *       &lt;attribute name="receiptNo" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema}ReceiptNo" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Receipt", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "transactions"
})
@XmlSeeAlso({
    CreditVendReceipt.class,
    PayAccReceipt.class
})
public abstract class Receipt {

    @XmlElement(required = true)
    protected Transactions transactions;
    @XmlAttribute(name = "receiptNo", required = true)
    protected String receiptNo;

    /**
     * ��ȡtransactions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Transactions }
     *     
     */
    public Transactions getTransactions() {
        return transactions;
    }

    /**
     * ����transactions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Transactions }
     *     
     */
    public void setTransactions(Transactions value) {
        this.transactions = value;
    }

    /**
     * ��ȡreceiptNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * ����receiptNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNo(String value) {
        this.receiptNo = value;
    }

}
