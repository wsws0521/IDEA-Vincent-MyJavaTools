
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Cash complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Cash">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PayType">
 *       &lt;sequence>
 *         &lt;element name="tenderAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cash", propOrder = {
    "tenderAmt"
})
public class Cash
    extends PayType
{

    @XmlElement(required = true)
    protected Currency tenderAmt;

    /**
     * ��ȡtenderAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getTenderAmt() {
        return tenderAmt;
    }

    /**
     * ����tenderAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setTenderAmt(Currency value) {
        this.tenderAmt = value;
    }

}
