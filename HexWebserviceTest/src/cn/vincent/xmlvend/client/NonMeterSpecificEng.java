
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NonMeterSpecificEng的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="NonMeterSpecificEng">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TestAll"/>
 *     &lt;enumeration value="TestBreaker"/>
 *     &lt;enumeration value="TestDisp"/>
 *     &lt;enumeration value="DispPwrLmt"/>
 *     &lt;enumeration value="DispTI"/>
 *     &lt;enumeration value="DispKRN"/>
 *     &lt;enumeration value="DispTamper"/>
 *     &lt;enumeration value="DispInstPwr"/>
 *     &lt;enumeration value="DispConsTot"/>
 *     &lt;enumeration value="DispUnbalance"/>
 *     &lt;enumeration value="DispVer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NonMeterSpecificEng")
@XmlEnum
public enum NonMeterSpecificEng {

    @XmlEnumValue("TestAll")
    TEST_ALL("TestAll"),
    @XmlEnumValue("TestBreaker")
    TEST_BREAKER("TestBreaker"),
    @XmlEnumValue("TestDisp")
    TEST_DISP("TestDisp"),
    @XmlEnumValue("DispPwrLmt")
    DISP_PWR_LMT("DispPwrLmt"),
    @XmlEnumValue("DispTI")
    DISP_TI("DispTI"),
    @XmlEnumValue("DispKRN")
    DISP_KRN("DispKRN"),
    @XmlEnumValue("DispTamper")
    DISP_TAMPER("DispTamper"),
    @XmlEnumValue("DispInstPwr")
    DISP_INST_PWR("DispInstPwr"),
    @XmlEnumValue("DispConsTot")
    DISP_CONS_TOT("DispConsTot"),
    @XmlEnumValue("DispUnbalance")
    DISP_UNBALANCE("DispUnbalance"),
    @XmlEnumValue("DispVer")
    DISP_VER("DispVer");
    private final String value;

    NonMeterSpecificEng(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NonMeterSpecificEng fromValue(String v) {
        for (NonMeterSpecificEng c: NonMeterSpecificEng.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
