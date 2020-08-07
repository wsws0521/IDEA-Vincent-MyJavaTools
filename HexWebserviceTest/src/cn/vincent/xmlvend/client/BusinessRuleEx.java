
package cn.vincent.xmlvend.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  A business rule exception has occurred while processing the request
 * 				message, the server is therefore unable to continue with the happy path.
 * 			
 * 
 * <p>BusinessRuleEx complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BusinessRuleEx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema}Fault">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessRuleEx")
@XmlSeeAlso({
    DebtEx.class,
    ReprintEndBatchEx.class,
    BlockedMeterEx.class,
    ServiceChrgEx.class,
    ReprintDepositSlipEx.class,
    MSNOCheckDigitEx.class,
    FBEEx.class,
    CancelEx.class,
    UnknownMeterUpdateMtrKeyEx.class,
    VerifyTokenEx.class,
    CheckBatchTotalEx.class,
    ReprintEx.class,
    RequireMeterCardEx.class,
    ClientIDAuthorisationEx.class,
    UnknownMeterEx.class,
    UpdateMtrKeySameEx.class,
    VendorCreditEx.class,
    InsufficientMeterDataEx.class,
    LatestKRNEx.class,
    EndBatchEx.class,
    RequestAuthorisationEx.class,
    ConfirmCustomerEx.class,
    STSDataEx.class,
    StartBatchEx.class,
    SGCAuthorisationEx.class
})
public class BusinessRuleEx
    extends Fault
{


}
