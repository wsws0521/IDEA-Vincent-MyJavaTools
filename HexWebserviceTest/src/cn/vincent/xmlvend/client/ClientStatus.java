
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  The server state in terms of the client's credit and batch statuses.
 * 			
 * 
 * <p>ClientStatus complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClientStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availCredit" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *         &lt;element name="batchStatus" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BatchStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientStatus", propOrder = {
    "availCredit",
    "batchStatus"
})
public class ClientStatus {

    @XmlElement(required = true)
    protected Currency availCredit;
    protected BatchStatus batchStatus;

    /**
     * ��ȡavailCredit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getAvailCredit() {
        return availCredit;
    }

    /**
     * ����availCredit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setAvailCredit(Currency value) {
        this.availCredit = value;
    }

    /**
     * ��ȡbatchStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BatchStatus }
     *     
     */
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    /**
     * ����batchStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BatchStatus }
     *     
     */
    public void setBatchStatus(BatchStatus value) {
        this.batchStatus = value;
    }

}
