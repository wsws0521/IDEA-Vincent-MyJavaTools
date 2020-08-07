
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BaseVendResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BaseVendResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseResp">
 *       &lt;sequence>
 *         &lt;element name="clientStatus" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}ClientStatus"/>
 *         &lt;element name="utility" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}UtilityDetail"/>
 *         &lt;element name="vendor" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}VendorDetail" minOccurs="0"/>
 *         &lt;element name="custVendDetail" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}CustVendDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseVendResp", propOrder = {
    "clientStatus",
    "utility",
    "vendor",
    "custVendDetail"
})
@XmlSeeAlso({
    VerifyResp.class,
    MeterCreditTransferResp.class,
    CancelVendResp.class,
    PayAccResp.class,
    CreditVendResp.class,
    UpdateMeterKeyResp.class,
    MeterSpecificEngResp.class
})
public class BaseVendResp
    extends BaseResp
{

    @XmlElement(required = true)
    protected ClientStatus clientStatus;
    @XmlElement(required = true)
    protected UtilityDetail utility;
    protected VendorDetail vendor;
    protected CustVendDetail custVendDetail;

    /**
     * ��ȡclientStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClientStatus }
     *     
     */
    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    /**
     * ����clientStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClientStatus }
     *     
     */
    public void setClientStatus(ClientStatus value) {
        this.clientStatus = value;
    }

    /**
     * ��ȡutility���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UtilityDetail }
     *     
     */
    public UtilityDetail getUtility() {
        return utility;
    }

    /**
     * ����utility���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UtilityDetail }
     *     
     */
    public void setUtility(UtilityDetail value) {
        this.utility = value;
    }

    /**
     * ��ȡvendor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link VendorDetail }
     *     
     */
    public VendorDetail getVendor() {
        return vendor;
    }

    /**
     * ����vendor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link VendorDetail }
     *     
     */
    public void setVendor(VendorDetail value) {
        this.vendor = value;
    }

    /**
     * ��ȡcustVendDetail���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CustVendDetail }
     *     
     */
    public CustVendDetail getCustVendDetail() {
        return custVendDetail;
    }

    /**
     * ����custVendDetail���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CustVendDetail }
     *     
     */
    public void setCustVendDetail(CustVendDetail value) {
        this.custVendDetail = value;
    }

}
