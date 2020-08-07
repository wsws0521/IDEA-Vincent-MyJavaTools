
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Information returned with all Key Change Token issues. 
 * 
 * <p>KCTokenIssue complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="KCTokenIssue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}MeterSpecificEngTokenIssue">
 *       &lt;sequence>
 *         &lt;element name="kctData" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}KCTData"/>
 *         &lt;element name="pwrLmtToken" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}PwrLmtTokenIssue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KCTokenIssue", propOrder = {
    "kctData",
    "pwrLmtToken"
})
public class KCTokenIssue
    extends MeterSpecificEngTokenIssue
{

    @XmlElement(required = true)
    protected KCTData kctData;
    protected PwrLmtTokenIssue pwrLmtToken;

    /**
     * ��ȡkctData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link KCTData }
     *     
     */
    public KCTData getKctData() {
        return kctData;
    }

    /**
     * ����kctData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link KCTData }
     *     
     */
    public void setKctData(KCTData value) {
        this.kctData = value;
    }

    /**
     * ��ȡpwrLmtToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PwrLmtTokenIssue }
     *     
     */
    public PwrLmtTokenIssue getPwrLmtToken() {
        return pwrLmtToken;
    }

    /**
     * ����pwrLmtToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PwrLmtTokenIssue }
     *     
     */
    public void setPwrLmtToken(PwrLmtTokenIssue value) {
        this.pwrLmtToken = value;
    }

}
