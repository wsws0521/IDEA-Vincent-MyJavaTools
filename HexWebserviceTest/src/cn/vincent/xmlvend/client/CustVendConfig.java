
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 *  Vending information for a customer. 
 * 
 * <p>CustVendConfig complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CustVendConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="canVend" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fbeDue" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="maxVendAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *         &lt;element name="minVendAmt" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Currency" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustVendConfig", namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", propOrder = {
    "canVend",
    "fbeDue",
    "maxVendAmt",
    "minVendAmt"
})
public class CustVendConfig {

    protected boolean canVend;
    protected Boolean fbeDue;
    protected Currency maxVendAmt;
    protected Currency minVendAmt;

    /**
     * ��ȡcanVend���Ե�ֵ��
     * 
     */
    public boolean isCanVend() {
        return canVend;
    }

    /**
     * ����canVend���Ե�ֵ��
     * 
     */
    public void setCanVend(boolean value) {
        this.canVend = value;
    }

    /**
     * ��ȡfbeDue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFbeDue() {
        return fbeDue;
    }

    /**
     * ����fbeDue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFbeDue(Boolean value) {
        this.fbeDue = value;
    }

    /**
     * ��ȡmaxVendAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getMaxVendAmt() {
        return maxVendAmt;
    }

    /**
     * ����maxVendAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setMaxVendAmt(Currency value) {
        this.maxVendAmt = value;
    }

    /**
     * ��ȡminVendAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getMinVendAmt() {
        return minVendAmt;
    }

    /**
     * ����minVendAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setMinVendAmt(Currency value) {
        this.minVendAmt = value;
    }

}
