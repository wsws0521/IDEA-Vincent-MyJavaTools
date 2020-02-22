
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BoxCommunicationTestSTS6 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BoxCommunicationTestSTS6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="delay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="echoData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoxCommunicationTestSTS6", propOrder = {
    "delay",
    "echoData"
})
public class BoxCommunicationTestSTS6 {

    protected int delay;
    protected String echoData;

    /**
     * 获取delay属性的值。
     * 
     */
    public int getDelay() {
        return delay;
    }

    /**
     * 设置delay属性的值。
     * 
     */
    public void setDelay(int value) {
        this.delay = value;
    }

    /**
     * 获取echoData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEchoData() {
        return echoData;
    }

    /**
     * 设置echoData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEchoData(String value) {
        this.echoData = value;
    }

}
