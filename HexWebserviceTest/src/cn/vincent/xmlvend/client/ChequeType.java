
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ChequeType�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="ChequeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Personal"/>
 *     &lt;enumeration value="Company"/>
 *     &lt;enumeration value="Government"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChequeType")
@XmlEnum
public enum ChequeType {

    @XmlEnumValue("Personal")
    PERSONAL("Personal"),
    @XmlEnumValue("Company")
    COMPANY("Company"),
    @XmlEnumValue("Government")
    GOVERNMENT("Government");
    private final String value;

    ChequeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChequeType fromValue(String v) {
        for (ChequeType c: ChequeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
