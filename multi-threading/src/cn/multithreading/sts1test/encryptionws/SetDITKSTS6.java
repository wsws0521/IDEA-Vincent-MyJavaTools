
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setDITKSTS6 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="setDITKSTS6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumComps" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="KeyCheckValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setDITKSTS6", propOrder = {
    "ea",
    "numComps",
    "keyCheckValue"
})
public class SetDITKSTS6 {

    @XmlElement(name = "EA")
    protected String ea;
    @XmlElement(name = "NumComps")
    protected int numComps;
    @XmlElement(name = "KeyCheckValue")
    protected String keyCheckValue;

    /**
     * ��ȡea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEA() {
        return ea;
    }

    /**
     * ����ea���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEA(String value) {
        this.ea = value;
    }

    /**
     * ��ȡnumComps���Ե�ֵ��
     * 
     */
    public int getNumComps() {
        return numComps;
    }

    /**
     * ����numComps���Ե�ֵ��
     * 
     */
    public void setNumComps(int value) {
        this.numComps = value;
    }

    /**
     * ��ȡkeyCheckValue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyCheckValue() {
        return keyCheckValue;
    }

    /**
     * ����keyCheckValue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyCheckValue(String value) {
        this.keyCheckValue = value;
    }

}
