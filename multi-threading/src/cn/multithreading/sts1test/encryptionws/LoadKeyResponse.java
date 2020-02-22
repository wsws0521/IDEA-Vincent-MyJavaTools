
package cn.multithreading.sts1test.encryptionws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LoadKeyResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LoadKeyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoadKeyResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadKeyResponse", propOrder = {
    "loadKeyResult"
})
public class LoadKeyResponse {

    @XmlElement(name = "LoadKeyResult")
    protected int loadKeyResult;

    /**
     * ��ȡloadKeyResult���Ե�ֵ��
     * 
     */
    public int getLoadKeyResult() {
        return loadKeyResult;
    }

    /**
     * ����loadKeyResult���Ե�ֵ��
     * 
     */
    public void setLoadKeyResult(int value) {
        this.loadKeyResult = value;
    }

}
