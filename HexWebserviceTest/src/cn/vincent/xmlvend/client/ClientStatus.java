
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  The server state in terms of the client's credit and batch statuses.
 * 			
 * 
 * <p>ClientStatus complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取availCredit属性的值。
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
     * 设置availCredit属性的值。
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
     * 获取batchStatus属性的值。
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
     * 设置batchStatus属性的值。
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
