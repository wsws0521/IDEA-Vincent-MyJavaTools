
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  The 20 digit STS 1 token as defined in the STS 1 specifications. For the
 * 				TrialCredit Vend request the STS1Token value will default to "0000000000000000".
 * 			
 * 
 * <p>STS1Token complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="STS1Token">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Token">
 *       &lt;sequence>
 *         &lt;element name="stsCipher" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}STSCipherText"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STS1Token", propOrder = {
    "stsCipher"
})
public class STS1Token
    extends Token
{

    @XmlElement(required = true)
    protected String stsCipher;

    /**
     * ��ȡstsCipher���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStsCipher() {
        return stsCipher;
    }

    /**
     * ����stsCipher���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStsCipher(String value) {
        this.stsCipher = value;
    }

}
