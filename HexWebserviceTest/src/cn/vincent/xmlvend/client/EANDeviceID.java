
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  The EAN is simply a 13-digit number used to uniquely identify the
 * 				client, server or terminal. Its basic components are: An EAN.UCC Company Prefix, a
 * 				Location Reference and a Check Digit. 
 * 
 * <p>EANDeviceID complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="EANDeviceID">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}DeviceID">
 *       &lt;attribute name="ean" use="required" type="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}EAN" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EANDeviceID")
public class EANDeviceID
    extends DeviceID
{

    @XmlAttribute(name = "ean", required = true)
    protected String ean;

    /**
     * ��ȡean���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEan() {
        return ean;
    }

    /**
     * ����ean���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEan(String value) {
        this.ean = value;
    }

}
