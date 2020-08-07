
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Response to update meter key request. Contains the key change token set and meter update details and an optional power limit token. 	
 * 		
 * 
 * <p>UpdateMeterKeyResp complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="UpdateMeterKeyResp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}BaseVendResp">
 *       &lt;sequence>
 *         &lt;element name="updateMeterKey" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}KCTokenIssue"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateMeterKeyResp", namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", propOrder = {
    "updateMeterKey"
})
public class UpdateMeterKeyResp
    extends BaseVendResp
{

    @XmlElement(required = true)
    protected KCTokenIssue updateMeterKey;

    /**
     * ��ȡupdateMeterKey���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link KCTokenIssue }
     *     
     */
    public KCTokenIssue getUpdateMeterKey() {
        return updateMeterKey;
    }

    /**
     * ����updateMeterKey���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link KCTokenIssue }
     *     
     */
    public void setUpdateMeterKey(KCTokenIssue value) {
        this.updateMeterKey = value;
    }

}
