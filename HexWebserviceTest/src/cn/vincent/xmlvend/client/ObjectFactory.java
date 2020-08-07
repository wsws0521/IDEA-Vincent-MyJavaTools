
package cn.vincent.xmlvend.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.vincent.xmlvend.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MeterCreditTransferResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "meterCreditTransferResp");
    private final static QName _CustReportFaultReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "custReportFaultReq");
    private final static QName _ValidateCustomerResponse_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "validateCustomerResponse");
    private final static QName _PayAccReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "payAccReq");
    private final static QName _VerifyResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "verifyResp");
    private final static QName _VerifyReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "verifyReq");
    private final static QName _DepositResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "depositResp");
    private final static QName _GetMeterBalanceReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "getMeterBalanceReq");
    private final static QName _FreeIssueReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "freeIssueReq");
    private final static QName _FbeReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "fbeReq");
    private final static QName _XmlvendFaultResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", "xmlvendFaultResp");
    private final static QName _AdviceReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", "adviceReq");
    private final static QName _MeterSpecificEngReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "meterSpecificEngReq");
    private final static QName _PostYakaPayment_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "postYakaPayment");
    private final static QName _TrialCreditVendResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "trialCreditVendResp");
    private final static QName _ConfirmNodeReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "confirmNodeReq");
    private final static QName _StartBatchReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "startBatchReq");
    private final static QName _GetTransactionDetails_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "getTransactionDetails");
    private final static QName _EndBatchReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "endBatchReq");
    private final static QName _MeterCreditTransferReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "meterCreditTransferReq");
    private final static QName _VendorStatementResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "vendorStatementResp");
    private final static QName _GetOrderStatusResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", "getOrderStatusResp");
    private final static QName _UpdateMeterKeyResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "updateMeterKeyResp");
    private final static QName _ReprintDepResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "reprintDepResp");
    private final static QName _VendorStatementReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "vendorStatementReq");
    private final static QName _GetOrderStatusReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", "getOrderStatusReq");
    private final static QName _CreditVendResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "creditVendResp");
    private final static QName _ReprintDepReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "reprintDepReq");
    private final static QName _SendTokenReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", "sendTokenReq");
    private final static QName _TrialCreditVendReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "trialCreditVendReq");
    private final static QName _EndBatchResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "endBatchResp");
    private final static QName _MeterSpecificEngResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "meterSpecificEngResp");
    private final static QName _FbeResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "fbeResp");
    private final static QName _NonMeterSpecificEngReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "nonMeterSpecificEngReq");
    private final static QName _CreditVendReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "creditVendReq");
    private final static QName _ReprintEndBatchResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "reprintEndBatchResp");
    private final static QName _AdviceResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", "adviceResp");
    private final static QName _SendTokenResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", "sendTokenResp");
    private final static QName _UpdateMeterKeyReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "updateMeterKeyReq");
    private final static QName _FreeIssueResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "freeIssueResp");
    private final static QName _ConfirmMeterResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "confirmMeterResp");
    private final static QName _CancelVendResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "cancelVendResp");
    private final static QName _CancelVendReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "cancelVendReq");
    private final static QName _TotalBatchResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "totalBatchResp");
    private final static QName _ReprintReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "reprintReq");
    private final static QName _ReprintEndBatchReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "reprintEndBatchReq");
    private final static QName _PayAccResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "payAccResp");
    private final static QName _GetMeterBalanceResponse_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "getMeterBalanceResponse");
    private final static QName _ConfirmNodeResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "confirmNodeResp");
    private final static QName _ConfirmMeterReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "confirmMeterReq");
    private final static QName _LoginReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "loginReq");
    private final static QName _DepositReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "depositReq");
    private final static QName _PostYakaPaymentResponse_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "postYakaPaymentResponse");
    private final static QName _StartBatchResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "startBatchResp");
    private final static QName _ConfirmCustomerResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "confirmCustomerResp");
    private final static QName _NonMeterSpecificEngResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "nonMeterSpecificEngResp");
    private final static QName _ConfirmCustomerReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "confirmCustomerReq");
    private final static QName _ValidateCustomer_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "validateCustomer");
    private final static QName _CustReportFaultResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", "custReportFaultResp");
    private final static QName _TotalBatchReq_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "totalBatchReq");
    private final static QName _ReprintResp_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "reprintResp");
    private final static QName _User_QNAME = new QName("http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", "user");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.vincent.xmlvend.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateCustomerResponse }
     * 
     */
    public ValidateCustomerResponse createValidateCustomerResponse() {
        return new ValidateCustomerResponse();
    }

    /**
     * Create an instance of {@link PayAccReq }
     * 
     */
    public PayAccReq createPayAccReq() {
        return new PayAccReq();
    }

    /**
     * Create an instance of {@link VerifyResp }
     * 
     */
    public VerifyResp createVerifyResp() {
        return new VerifyResp();
    }

    /**
     * Create an instance of {@link FreeIssueResp }
     * 
     */
    public FreeIssueResp createFreeIssueResp() {
        return new FreeIssueResp();
    }

    /**
     * Create an instance of {@link MeterCreditTransferResp }
     * 
     */
    public MeterCreditTransferResp createMeterCreditTransferResp() {
        return new MeterCreditTransferResp();
    }

    /**
     * Create an instance of {@link ReprintEndBatchResp }
     * 
     */
    public ReprintEndBatchResp createReprintEndBatchResp() {
        return new ReprintEndBatchResp();
    }

    /**
     * Create an instance of {@link FreeIssueReq }
     * 
     */
    public FreeIssueReq createFreeIssueReq() {
        return new FreeIssueReq();
    }

    /**
     * Create an instance of {@link ReprintReq }
     * 
     */
    public ReprintReq createReprintReq() {
        return new ReprintReq();
    }

    /**
     * Create an instance of {@link DepositResp }
     * 
     */
    public DepositResp createDepositResp() {
        return new DepositResp();
    }

    /**
     * Create an instance of {@link CancelVendReq }
     * 
     */
    public CancelVendReq createCancelVendReq() {
        return new CancelVendReq();
    }

    /**
     * Create an instance of {@link TotalBatchResp }
     * 
     */
    public TotalBatchResp createTotalBatchResp() {
        return new TotalBatchResp();
    }

    /**
     * Create an instance of {@link CancelVendResp }
     * 
     */
    public CancelVendResp createCancelVendResp() {
        return new CancelVendResp();
    }

    /**
     * Create an instance of {@link VerifyReq }
     * 
     */
    public VerifyReq createVerifyReq() {
        return new VerifyReq();
    }

    /**
     * Create an instance of {@link PostYakaPayment }
     * 
     */
    public PostYakaPayment createPostYakaPayment() {
        return new PostYakaPayment();
    }

    /**
     * Create an instance of {@link TrialCreditVendResp }
     * 
     */
    public TrialCreditVendResp createTrialCreditVendResp() {
        return new TrialCreditVendResp();
    }

    /**
     * Create an instance of {@link PayAccResp }
     * 
     */
    public PayAccResp createPayAccResp() {
        return new PayAccResp();
    }

    /**
     * Create an instance of {@link FBEReq }
     * 
     */
    public FBEReq createFBEReq() {
        return new FBEReq();
    }

    /**
     * Create an instance of {@link ConfirmNodeResp }
     * 
     */
    public ConfirmNodeResp createConfirmNodeResp() {
        return new ConfirmNodeResp();
    }

    /**
     * Create an instance of {@link GetTransactionDetails }
     * 
     */
    public GetTransactionDetails createGetTransactionDetails() {
        return new GetTransactionDetails();
    }

    /**
     * Create an instance of {@link ConfirmNodeReq }
     * 
     */
    public ConfirmNodeReq createConfirmNodeReq() {
        return new ConfirmNodeReq();
    }

    /**
     * Create an instance of {@link StartBatchResp }
     * 
     */
    public StartBatchResp createStartBatchResp() {
        return new StartBatchResp();
    }

    /**
     * Create an instance of {@link DepositReq }
     * 
     */
    public DepositReq createDepositReq() {
        return new DepositReq();
    }

    /**
     * Create an instance of {@link ReprintDepositResp }
     * 
     */
    public ReprintDepositResp createReprintDepositResp() {
        return new ReprintDepositResp();
    }

    /**
     * Create an instance of {@link PostYakaPaymentResponse }
     * 
     */
    public PostYakaPaymentResponse createPostYakaPaymentResponse() {
        return new PostYakaPaymentResponse();
    }

    /**
     * Create an instance of {@link VendorStatementReq }
     * 
     */
    public VendorStatementReq createVendorStatementReq() {
        return new VendorStatementReq();
    }

    /**
     * Create an instance of {@link MeterCreditTransferReq }
     * 
     */
    public MeterCreditTransferReq createMeterCreditTransferReq() {
        return new MeterCreditTransferReq();
    }

    /**
     * Create an instance of {@link VendorStatementResp }
     * 
     */
    public VendorStatementResp createVendorStatementResp() {
        return new VendorStatementResp();
    }

    /**
     * Create an instance of {@link LoginReq }
     * 
     */
    public LoginReq createLoginReq() {
        return new LoginReq();
    }

    /**
     * Create an instance of {@link ConfirmCustomerReq }
     * 
     */
    public ConfirmCustomerReq createConfirmCustomerReq() {
        return new ConfirmCustomerReq();
    }

    /**
     * Create an instance of {@link ValidateCustomer }
     * 
     */
    public ValidateCustomer createValidateCustomer() {
        return new ValidateCustomer();
    }

    /**
     * Create an instance of {@link TrialCreditVendReq }
     * 
     */
    public TrialCreditVendReq createTrialCreditVendReq() {
        return new TrialCreditVendReq();
    }

    /**
     * Create an instance of {@link EndBatchResp }
     * 
     */
    public EndBatchResp createEndBatchResp() {
        return new EndBatchResp();
    }

    /**
     * Create an instance of {@link CreditVendResp }
     * 
     */
    public CreditVendResp createCreditVendResp() {
        return new CreditVendResp();
    }

    /**
     * Create an instance of {@link ReprintDepositReq }
     * 
     */
    public ReprintDepositReq createReprintDepositReq() {
        return new ReprintDepositReq();
    }

    /**
     * Create an instance of {@link ConfirmCustomerResp }
     * 
     */
    public ConfirmCustomerResp createConfirmCustomerResp() {
        return new ConfirmCustomerResp();
    }

    /**
     * Create an instance of {@link FBEResp }
     * 
     */
    public FBEResp createFBEResp() {
        return new FBEResp();
    }

    /**
     * Create an instance of {@link CreditVendReq }
     * 
     */
    public CreditVendReq createCreditVendReq() {
        return new CreditVendReq();
    }

    /**
     * Create an instance of {@link LoginUser }
     * 
     */
    public LoginUser createLoginUser() {
        return new LoginUser();
    }

    /**
     * Create an instance of {@link ReprintResp }
     * 
     */
    public ReprintResp createReprintResp() {
        return new ReprintResp();
    }

    /**
     * Create an instance of {@link ValidateCustomerResult }
     * 
     */
    public ValidateCustomerResult createValidateCustomerResult() {
        return new ValidateCustomerResult();
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link TotalShiftBatchReq }
     * 
     */
    public TotalShiftBatchReq createTotalShiftBatchReq() {
        return new TotalShiftBatchReq();
    }

    /**
     * Create an instance of {@link VendorStatement }
     * 
     */
    public VendorStatement createVendorStatement() {
        return new VendorStatement();
    }

    /**
     * Create an instance of {@link DebtRecoveryTotal }
     * 
     */
    public DebtRecoveryTotal createDebtRecoveryTotal() {
        return new DebtRecoveryTotal();
    }

    /**
     * Create an instance of {@link CreditTransferDetail }
     * 
     */
    public CreditTransferDetail createCreditTransferDetail() {
        return new CreditTransferDetail();
    }

    /**
     * Create an instance of {@link FreeIssueTotal }
     * 
     */
    public FreeIssueTotal createFreeIssueTotal() {
        return new FreeIssueTotal();
    }

    /**
     * Create an instance of {@link ReprintEndSalesBatchReq }
     * 
     */
    public ReprintEndSalesBatchReq createReprintEndSalesBatchReq() {
        return new ReprintEndSalesBatchReq();
    }

    /**
     * Create an instance of {@link ShiftStartBatch }
     * 
     */
    public ShiftStartBatch createShiftStartBatch() {
        return new ShiftStartBatch();
    }

    /**
     * Create an instance of {@link StartBankBatchReq }
     * 
     */
    public StartBankBatchReq createStartBankBatchReq() {
        return new StartBankBatchReq();
    }

    /**
     * Create an instance of {@link EndSalesBatchReq }
     * 
     */
    public EndSalesBatchReq createEndSalesBatchReq() {
        return new EndSalesBatchReq();
    }

    /**
     * Create an instance of {@link ConfirmCustResult }
     * 
     */
    public ConfirmCustResult createConfirmCustResult() {
        return new ConfirmCustResult();
    }

    /**
     * Create an instance of {@link PostYakaPaymentResult }
     * 
     */
    public PostYakaPaymentResult createPostYakaPaymentResult() {
        return new PostYakaPaymentResult();
    }

    /**
     * Create an instance of {@link SalesBatch }
     * 
     */
    public SalesBatch createSalesBatch() {
        return new SalesBatch();
    }

    /**
     * Create an instance of {@link Transactions }
     * 
     */
    public Transactions createTransactions() {
        return new Transactions();
    }

    /**
     * Create an instance of {@link ServiceChrgTotal }
     * 
     */
    public ServiceChrgTotal createServiceChrgTotal() {
        return new ServiceChrgTotal();
    }

    /**
     * Create an instance of {@link CreditVendReceipt }
     * 
     */
    public CreditVendReceipt createCreditVendReceipt() {
        return new CreditVendReceipt();
    }

    /**
     * Create an instance of {@link CashTotal }
     * 
     */
    public CashTotal createCashTotal() {
        return new CashTotal();
    }

    /**
     * Create an instance of {@link DebitCardTotal }
     * 
     */
    public DebitCardTotal createDebitCardTotal() {
        return new DebitCardTotal();
    }

    /**
     * Create an instance of {@link TotalSalesBatchReq }
     * 
     */
    public TotalSalesBatchReq createTotalSalesBatchReq() {
        return new TotalSalesBatchReq();
    }

    /**
     * Create an instance of {@link CustVendConfig }
     * 
     */
    public CustVendConfig createCustVendConfig() {
        return new CustVendConfig();
    }

    /**
     * Create an instance of {@link PayAccReceipt }
     * 
     */
    public PayAccReceipt createPayAccReceipt() {
        return new PayAccReceipt();
    }

    /**
     * Create an instance of {@link Trans }
     * 
     */
    public Trans createTrans() {
        return new Trans();
    }

    /**
     * Create an instance of {@link BankStartBatch }
     * 
     */
    public BankStartBatch createBankStartBatch() {
        return new BankStartBatch();
    }

    /**
     * Create an instance of {@link AccPaymentTotal }
     * 
     */
    public AccPaymentTotal createAccPaymentTotal() {
        return new AccPaymentTotal();
    }

    /**
     * Create an instance of {@link OtherTotal }
     * 
     */
    public OtherTotal createOtherTotal() {
        return new OtherTotal();
    }

    /**
     * Create an instance of {@link CreditCardTotal }
     * 
     */
    public CreditCardTotal createCreditCardTotal() {
        return new CreditCardTotal();
    }

    /**
     * Create an instance of {@link BankBatch }
     * 
     */
    public BankBatch createBankBatch() {
        return new BankBatch();
    }

    /**
     * Create an instance of {@link EndShiftBatchReq }
     * 
     */
    public EndShiftBatchReq createEndShiftBatchReq() {
        return new EndShiftBatchReq();
    }

    /**
     * Create an instance of {@link MeterCreditTransferTotal }
     * 
     */
    public MeterCreditTransferTotal createMeterCreditTransferTotal() {
        return new MeterCreditTransferTotal();
    }

    /**
     * Create an instance of {@link Beneficiary }
     * 
     */
    public Beneficiary createBeneficiary() {
        return new Beneficiary();
    }

    /**
     * Create an instance of {@link NormalSaleTotal }
     * 
     */
    public NormalSaleTotal createNormalSaleTotal() {
        return new NormalSaleTotal();
    }

    /**
     * Create an instance of {@link EndAllBatchesReq }
     * 
     */
    public EndAllBatchesReq createEndAllBatchesReq() {
        return new EndAllBatchesReq();
    }

    /**
     * Create an instance of {@link ElectricityTotal }
     * 
     */
    public ElectricityTotal createElectricityTotal() {
        return new ElectricityTotal();
    }

    /**
     * Create an instance of {@link CurrencyTotal }
     * 
     */
    public CurrencyTotal createCurrencyTotal() {
        return new CurrencyTotal();
    }

    /**
     * Create an instance of {@link ShiftBatch }
     * 
     */
    public ShiftBatch createShiftBatch() {
        return new ShiftBatch();
    }

    /**
     * Create an instance of {@link WaterTotal }
     * 
     */
    public WaterTotal createWaterTotal() {
        return new WaterTotal();
    }

    /**
     * Create an instance of {@link TotalBankBatchReq }
     * 
     */
    public TotalBankBatchReq createTotalBankBatchReq() {
        return new TotalBankBatchReq();
    }

    /**
     * Create an instance of {@link StartSalesBatchReq }
     * 
     */
    public StartSalesBatchReq createStartSalesBatchReq() {
        return new StartSalesBatchReq();
    }

    /**
     * Create an instance of {@link CancellationTotal }
     * 
     */
    public CancellationTotal createCancellationTotal() {
        return new CancellationTotal();
    }

    /**
     * Create an instance of {@link EndBankBatchReq }
     * 
     */
    public EndBankBatchReq createEndBankBatchReq() {
        return new EndBankBatchReq();
    }

    /**
     * Create an instance of {@link PurchaseValueUnits }
     * 
     */
    public PurchaseValueUnits createPurchaseValueUnits() {
        return new PurchaseValueUnits();
    }

    /**
     * Create an instance of {@link DebtRecovery }
     * 
     */
    public DebtRecovery createDebtRecovery() {
        return new DebtRecovery();
    }

    /**
     * Create an instance of {@link DepositSlip }
     * 
     */
    public DepositSlip createDepositSlip() {
        return new DepositSlip();
    }

    /**
     * Create an instance of {@link SalesStartBatch }
     * 
     */
    public SalesStartBatch createSalesStartBatch() {
        return new SalesStartBatch();
    }

    /**
     * Create an instance of {@link CreditVendTx }
     * 
     */
    public CreditVendTx createCreditVendTx() {
        return new CreditVendTx();
    }

    /**
     * Create an instance of {@link DebtRecoveryTx }
     * 
     */
    public DebtRecoveryTx createDebtRecoveryTx() {
        return new DebtRecoveryTx();
    }

    /**
     * Create an instance of {@link ConnectionTimeTotal }
     * 
     */
    public ConnectionTimeTotal createConnectionTimeTotal() {
        return new ConnectionTimeTotal();
    }

    /**
     * Create an instance of {@link GasTotal }
     * 
     */
    public GasTotal createGasTotal() {
        return new GasTotal();
    }

    /**
     * Create an instance of {@link ReprintEndBankingBatchReq }
     * 
     */
    public ReprintEndBankingBatchReq createReprintEndBankingBatchReq() {
        return new ReprintEndBankingBatchReq();
    }

    /**
     * Create an instance of {@link StartShiftBatchReq }
     * 
     */
    public StartShiftBatchReq createStartShiftBatchReq() {
        return new StartShiftBatchReq();
    }

    /**
     * Create an instance of {@link ResourceTotal }
     * 
     */
    public ResourceTotal createResourceTotal() {
        return new ResourceTotal();
    }

    /**
     * Create an instance of {@link ParentNode }
     * 
     */
    public ParentNode createParentNode() {
        return new ParentNode();
    }

    /**
     * Create an instance of {@link OperatorTotal }
     * 
     */
    public OperatorTotal createOperatorTotal() {
        return new OperatorTotal();
    }

    /**
     * Create an instance of {@link PayAccount }
     * 
     */
    public PayAccount createPayAccount() {
        return new PayAccount();
    }

    /**
     * Create an instance of {@link ReprintEndShiftBatchReq }
     * 
     */
    public ReprintEndShiftBatchReq createReprintEndShiftBatchReq() {
        return new ReprintEndShiftBatchReq();
    }

    /**
     * Create an instance of {@link PayAccTx }
     * 
     */
    public PayAccTx createPayAccTx() {
        return new PayAccTx();
    }

    /**
     * Create an instance of {@link PurchaseValueCurrency }
     * 
     */
    public PurchaseValueCurrency createPurchaseValueCurrency() {
        return new PurchaseValueCurrency();
    }

    /**
     * Create an instance of {@link StartAllBatchesReq }
     * 
     */
    public StartAllBatchesReq createStartAllBatchesReq() {
        return new StartAllBatchesReq();
    }

    /**
     * Create an instance of {@link ServiceChrgTx }
     * 
     */
    public ServiceChrgTx createServiceChrgTx() {
        return new ServiceChrgTx();
    }

    /**
     * Create an instance of {@link BatchReport }
     * 
     */
    public BatchReport createBatchReport() {
        return new BatchReport();
    }

    /**
     * Create an instance of {@link ChequeTotal }
     * 
     */
    public ChequeTotal createChequeTotal() {
        return new ChequeTotal();
    }

    /**
     * Create an instance of {@link TotalAllBatchesReq }
     * 
     */
    public TotalAllBatchesReq createTotalAllBatchesReq() {
        return new TotalAllBatchesReq();
    }

    /**
     * Create an instance of {@link ServiceChrg }
     * 
     */
    public ServiceChrg createServiceChrg() {
        return new ServiceChrg();
    }

    /**
     * Create an instance of {@link VendorStatementLineItem }
     * 
     */
    public VendorStatementLineItem createVendorStatementLineItem() {
        return new VendorStatementLineItem();
    }

    /**
     * Create an instance of {@link GetOrderStatusResp }
     * 
     */
    public GetOrderStatusResp createGetOrderStatusResp() {
        return new GetOrderStatusResp();
    }

    /**
     * Create an instance of {@link XMLVendFaultResp }
     * 
     */
    public XMLVendFaultResp createXMLVendFaultResp() {
        return new XMLVendFaultResp();
    }

    /**
     * Create an instance of {@link GetOrderStatusReq }
     * 
     */
    public GetOrderStatusReq createGetOrderStatusReq() {
        return new GetOrderStatusReq();
    }

    /**
     * Create an instance of {@link CustAddress }
     * 
     */
    public CustAddress createCustAddress() {
        return new CustAddress();
    }

    /**
     * Create an instance of {@link Water }
     * 
     */
    public Water createWater() {
        return new Water();
    }

    /**
     * Create an instance of {@link DebtEx }
     * 
     */
    public DebtEx createDebtEx() {
        return new DebtEx();
    }

    /**
     * Create an instance of {@link MeterBalance }
     * 
     */
    public MeterBalance createMeterBalance() {
        return new MeterBalance();
    }

    /**
     * Create an instance of {@link PhUnbalTokenIssue }
     * 
     */
    public PhUnbalTokenIssue createPhUnbalTokenIssue() {
        return new PhUnbalTokenIssue();
    }

    /**
     * Create an instance of {@link AuthCred }
     * 
     */
    public AuthCred createAuthCred() {
        return new AuthCred();
    }

    /**
     * Create an instance of {@link VAT }
     * 
     */
    public VAT createVAT() {
        return new VAT();
    }

    /**
     * Create an instance of {@link ReprintEndBatchEx }
     * 
     */
    public ReprintEndBatchEx createReprintEndBatchEx() {
        return new ReprintEndBatchEx();
    }

    /**
     * Create an instance of {@link BlockedMeterEx }
     * 
     */
    public BlockedMeterEx createBlockedMeterEx() {
        return new BlockedMeterEx();
    }

    /**
     * Create an instance of {@link Unknown }
     * 
     */
    public Unknown createUnknown() {
        return new Unknown();
    }

    /**
     * Create an instance of {@link Currency }
     * 
     */
    public Currency createCurrency() {
        return new Currency();
    }

    /**
     * Create an instance of {@link ConnectionTime }
     * 
     */
    public ConnectionTime createConnectionTime() {
        return new ConnectionTime();
    }

    /**
     * Create an instance of {@link KCToken }
     * 
     */
    public KCToken createKCToken() {
        return new KCToken();
    }

    /**
     * Create an instance of {@link VendIDMethod }
     * 
     */
    public VendIDMethod createVendIDMethod() {
        return new VendIDMethod();
    }

    /**
     * Create an instance of {@link ConfirmationEx }
     * 
     */
    public ConfirmationEx createConfirmationEx() {
        return new ConfirmationEx();
    }

    /**
     * Create an instance of {@link FBECredTokenIssue }
     * 
     */
    public FBECredTokenIssue createFBECredTokenIssue() {
        return new FBECredTokenIssue();
    }

    /**
     * Create an instance of {@link ReversalAdviceReq }
     * 
     */
    public ReversalAdviceReq createReversalAdviceReq() {
        return new ReversalAdviceReq();
    }

    /**
     * Create an instance of {@link ServiceChrgEx }
     * 
     */
    public ServiceChrgEx createServiceChrgEx() {
        return new ServiceChrgEx();
    }

    /**
     * Create an instance of {@link DebitCard }
     * 
     */
    public DebitCard createDebitCard() {
        return new DebitCard();
    }

    /**
     * Create an instance of {@link ReprintDepositSlipEx }
     * 
     */
    public ReprintDepositSlipEx createReprintDepositSlipEx() {
        return new ReprintDepositSlipEx();
    }

    /**
     * Create an instance of {@link LastResponseEx }
     * 
     */
    public LastResponseEx createLastResponseEx() {
        return new LastResponseEx();
    }

    /**
     * Create an instance of {@link MSNOCheckDigitEx }
     * 
     */
    public MSNOCheckDigitEx createMSNOCheckDigitEx() {
        return new MSNOCheckDigitEx();
    }

    /**
     * Create an instance of {@link BatchStatus }
     * 
     */
    public BatchStatus createBatchStatus() {
        return new BatchStatus();
    }

    /**
     * Create an instance of {@link UtilityDetail }
     * 
     */
    public UtilityDetail createUtilityDetail() {
        return new UtilityDetail();
    }

    /**
     * Create an instance of {@link PwrLmtTokenIssue }
     * 
     */
    public PwrLmtTokenIssue createPwrLmtTokenIssue() {
        return new PwrLmtTokenIssue();
    }

    /**
     * Create an instance of {@link WaterFactorTokenIssue }
     * 
     */
    public WaterFactorTokenIssue createWaterFactorTokenIssue() {
        return new WaterFactorTokenIssue();
    }

    /**
     * Create an instance of {@link Cash }
     * 
     */
    public Cash createCash() {
        return new Cash();
    }

    /**
     * Create an instance of {@link KCTData }
     * 
     */
    public KCTData createKCTData() {
        return new KCTData();
    }

    /**
     * Create an instance of {@link MsgID }
     * 
     */
    public MsgID createMsgID() {
        return new MsgID();
    }

    /**
     * Create an instance of {@link KCTokenIssue }
     * 
     */
    public KCTokenIssue createKCTokenIssue() {
        return new KCTokenIssue();
    }

    /**
     * Create an instance of {@link LastRespAdviceResp }
     * 
     */
    public LastRespAdviceResp createLastRespAdviceResp() {
        return new LastRespAdviceResp();
    }

    /**
     * Create an instance of {@link EANDeviceID }
     * 
     */
    public EANDeviceID createEANDeviceID() {
        return new EANDeviceID();
    }

    /**
     * Create an instance of {@link ConfirmationAdviceResp }
     * 
     */
    public ConfirmationAdviceResp createConfirmationAdviceResp() {
        return new ConfirmationAdviceResp();
    }

    /**
     * Create an instance of {@link BaseResp }
     * 
     */
    public BaseResp createBaseResp() {
        return new BaseResp();
    }

    /**
     * Create an instance of {@link FBEEx }
     * 
     */
    public FBEEx createFBEEx() {
        return new FBEEx();
    }

    /**
     * Create an instance of {@link MeterCard }
     * 
     */
    public MeterCard createMeterCard() {
        return new MeterCard();
    }

    /**
     * Create an instance of {@link ConfirmationAdviceReq }
     * 
     */
    public ConfirmationAdviceReq createConfirmationAdviceReq() {
        return new ConfirmationAdviceReq();
    }

    /**
     * Create an instance of {@link CustDetail }
     * 
     */
    public CustDetail createCustDetail() {
        return new CustDetail();
    }

    /**
     * Create an instance of {@link CurrencyResource }
     * 
     */
    public CurrencyResource createCurrencyResource() {
        return new CurrencyResource();
    }

    /**
     * Create an instance of {@link BaseVendResp }
     * 
     */
    public BaseVendResp createBaseVendResp() {
        return new BaseVendResp();
    }

    /**
     * Create an instance of {@link CancelEx }
     * 
     */
    public CancelEx createCancelEx() {
        return new CancelEx();
    }

    /**
     * Create an instance of {@link CustName }
     * 
     */
    public CustName createCustName() {
        return new CustName();
    }

    /**
     * Create an instance of {@link LastRespAdviceReq }
     * 
     */
    public LastRespAdviceReq createLastRespAdviceReq() {
        return new LastRespAdviceReq();
    }

    /**
     * Create an instance of {@link TokenSubClassType }
     * 
     */
    public TokenSubClassType createTokenSubClassType() {
        return new TokenSubClassType();
    }

    /**
     * Create an instance of {@link UnknownMeterUpdateMtrKeyEx }
     * 
     */
    public UnknownMeterUpdateMtrKeyEx createUnknownMeterUpdateMtrKeyEx() {
        return new UnknownMeterUpdateMtrKeyEx();
    }

    /**
     * Create an instance of {@link Cheque }
     * 
     */
    public Cheque createCheque() {
        return new Cheque();
    }

    /**
     * Create an instance of {@link STS1TokenInfo }
     * 
     */
    public STS1TokenInfo createSTS1TokenInfo() {
        return new STS1TokenInfo();
    }

    /**
     * Create an instance of {@link VerifyTokenEx }
     * 
     */
    public VerifyTokenEx createVerifyTokenEx() {
        return new VerifyTokenEx();
    }

    /**
     * Create an instance of {@link UseCaseSupportEx }
     * 
     */
    public UseCaseSupportEx createUseCaseSupportEx() {
        return new UseCaseSupportEx();
    }

    /**
     * Create an instance of {@link CheckBatchTotalEx }
     * 
     */
    public CheckBatchTotalEx createCheckBatchTotalEx() {
        return new CheckBatchTotalEx();
    }

    /**
     * Create an instance of {@link BaseReq }
     * 
     */
    public BaseReq createBaseReq() {
        return new BaseReq();
    }

    /**
     * Create an instance of {@link ReprintEx }
     * 
     */
    public ReprintEx createReprintEx() {
        return new ReprintEx();
    }

    /**
     * Create an instance of {@link CustAccountNo }
     * 
     */
    public CustAccountNo createCustAccountNo() {
        return new CustAccountNo();
    }

    /**
     * Create an instance of {@link BusinessRuleEx }
     * 
     */
    public BusinessRuleEx createBusinessRuleEx() {
        return new BusinessRuleEx();
    }

    /**
     * Create an instance of {@link RequireMeterCardEx }
     * 
     */
    public RequireMeterCardEx createRequireMeterCardEx() {
        return new RequireMeterCardEx();
    }

    /**
     * Create an instance of {@link ClientIDAuthorisationEx }
     * 
     */
    public ClientIDAuthorisationEx createClientIDAuthorisationEx() {
        return new ClientIDAuthorisationEx();
    }

    /**
     * Create an instance of {@link UnknownMeterEx }
     * 
     */
    public UnknownMeterEx createUnknownMeterEx() {
        return new UnknownMeterEx();
    }

    /**
     * Create an instance of {@link UpdateMtrKeySameEx }
     * 
     */
    public UpdateMtrKeySameEx createUpdateMtrKeySameEx() {
        return new UpdateMtrKeySameEx();
    }

    /**
     * Create an instance of {@link VendorCreditEx }
     * 
     */
    public VendorCreditEx createVendorCreditEx() {
        return new VendorCreditEx();
    }

    /**
     * Create an instance of {@link Tariff }
     * 
     */
    public Tariff createTariff() {
        return new Tariff();
    }

    /**
     * Create an instance of {@link InsufficientMeterDataEx }
     * 
     */
    public InsufficientMeterDataEx createInsufficientMeterDataEx() {
        return new InsufficientMeterDataEx();
    }

    /**
     * Create an instance of {@link CustIDNumber }
     * 
     */
    public CustIDNumber createCustIDNumber() {
        return new CustIDNumber();
    }

    /**
     * Create an instance of {@link SaleCredTokenIssue }
     * 
     */
    public SaleCredTokenIssue createSaleCredTokenIssue() {
        return new SaleCredTokenIssue();
    }

    /**
     * Create an instance of {@link LatestKRNEx }
     * 
     */
    public LatestKRNEx createLatestKRNEx() {
        return new LatestKRNEx();
    }

    /**
     * Create an instance of {@link ClearCreditTokenIssue }
     * 
     */
    public ClearCreditTokenIssue createClearCreditTokenIssue() {
        return new ClearCreditTokenIssue();
    }

    /**
     * Create an instance of {@link PwrLmt }
     * 
     */
    public PwrLmt createPwrLmt() {
        return new PwrLmt();
    }

    /**
     * Create an instance of {@link CustVendDetail }
     * 
     */
    public CustVendDetail createCustVendDetail() {
        return new CustVendDetail();
    }

    /**
     * Create an instance of {@link Units }
     * 
     */
    public Units createUnits() {
        return new Units();
    }

    /**
     * Create an instance of {@link Gas }
     * 
     */
    public Gas createGas() {
        return new Gas();
    }

    /**
     * Create an instance of {@link ReversalAdviceResp }
     * 
     */
    public ReversalAdviceResp createReversalAdviceResp() {
        return new ReversalAdviceResp();
    }

    /**
     * Create an instance of {@link ClearTamperTokenIssue }
     * 
     */
    public ClearTamperTokenIssue createClearTamperTokenIssue() {
        return new ClearTamperTokenIssue();
    }

    /**
     * Create an instance of {@link SystemEx }
     * 
     */
    public SystemEx createSystemEx() {
        return new SystemEx();
    }

    /**
     * Create an instance of {@link CustIDMethod }
     * 
     */
    public CustIDMethod createCustIDMethod() {
        return new CustIDMethod();
    }

    /**
     * Create an instance of {@link BaseVendReq }
     * 
     */
    public BaseVendReq createBaseVendReq() {
        return new BaseVendReq();
    }

    /**
     * Create an instance of {@link MeterType }
     * 
     */
    public MeterType createMeterType() {
        return new MeterType();
    }

    /**
     * Create an instance of {@link EndBatchEx }
     * 
     */
    public EndBatchEx createEndBatchEx() {
        return new EndBatchEx();
    }

    /**
     * Create an instance of {@link MCTCredTokenIssue }
     * 
     */
    public MCTCredTokenIssue createMCTCredTokenIssue() {
        return new MCTCredTokenIssue();
    }

    /**
     * Create an instance of {@link Electricity }
     * 
     */
    public Electricity createElectricity() {
        return new Electricity();
    }

    /**
     * Create an instance of {@link RequestAuthorisationEx }
     * 
     */
    public RequestAuthorisationEx createRequestAuthorisationEx() {
        return new RequestAuthorisationEx();
    }

    /**
     * Create an instance of {@link ConfirmCustomerEx }
     * 
     */
    public ConfirmCustomerEx createConfirmCustomerEx() {
        return new ConfirmCustomerEx();
    }

    /**
     * Create an instance of {@link ExtMeterDetail }
     * 
     */
    public ExtMeterDetail createExtMeterDetail() {
        return new ExtMeterDetail();
    }

    /**
     * Create an instance of {@link STSDataEx }
     * 
     */
    public STSDataEx createSTSDataEx() {
        return new STSDataEx();
    }

    /**
     * Create an instance of {@link ClientStatus }
     * 
     */
    public ClientStatus createClientStatus() {
        return new ClientStatus();
    }

    /**
     * Create an instance of {@link FreeCredTokenIssue }
     * 
     */
    public FreeCredTokenIssue createFreeCredTokenIssue() {
        return new FreeCredTokenIssue();
    }

    /**
     * Create an instance of {@link ClientIDSSLEx }
     * 
     */
    public ClientIDSSLEx createClientIDSSLEx() {
        return new ClientIDSSLEx();
    }

    /**
     * Create an instance of {@link StartBatchEx }
     * 
     */
    public StartBatchEx createStartBatchEx() {
        return new StartBatchEx();
    }

    /**
     * Create an instance of {@link GenericDeviceID }
     * 
     */
    public GenericDeviceID createGenericDeviceID() {
        return new GenericDeviceID();
    }

    /**
     * Create an instance of {@link MeterDetail }
     * 
     */
    public MeterDetail createMeterDetail() {
        return new MeterDetail();
    }

    /**
     * Create an instance of {@link CreditTokenIssue }
     * 
     */
    public CreditTokenIssue createCreditTokenIssue() {
        return new CreditTokenIssue();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link XMLVendSchemaEx }
     * 
     */
    public XMLVendSchemaEx createXMLVendSchemaEx() {
        return new XMLVendSchemaEx();
    }

    /**
     * Create an instance of {@link VendorDetail }
     * 
     */
    public VendorDetail createVendorDetail() {
        return new VendorDetail();
    }

    /**
     * Create an instance of {@link SGCAuthorisationEx }
     * 
     */
    public SGCAuthorisationEx createSGCAuthorisationEx() {
        return new SGCAuthorisationEx();
    }

    /**
     * Create an instance of {@link ReversalEx }
     * 
     */
    public ReversalEx createReversalEx() {
        return new ReversalEx();
    }

    /**
     * Create an instance of {@link MeterNumber }
     * 
     */
    public MeterNumber createMeterNumber() {
        return new MeterNumber();
    }

    /**
     * Create an instance of {@link STS1Token }
     * 
     */
    public STS1Token createSTS1Token() {
        return new STS1Token();
    }

    /**
     * Create an instance of {@link UpdateMeterKeyResp }
     * 
     */
    public UpdateMeterKeyResp createUpdateMeterKeyResp() {
        return new UpdateMeterKeyResp();
    }

    /**
     * Create an instance of {@link ConfirmMeterReq }
     * 
     */
    public ConfirmMeterReq createConfirmMeterReq() {
        return new ConfirmMeterReq();
    }

    /**
     * Create an instance of {@link CustReportFaultReq }
     * 
     */
    public CustReportFaultReq createCustReportFaultReq() {
        return new CustReportFaultReq();
    }

    /**
     * Create an instance of {@link UpdateMeterKeyReq }
     * 
     */
    public UpdateMeterKeyReq createUpdateMeterKeyReq() {
        return new UpdateMeterKeyReq();
    }

    /**
     * Create an instance of {@link GetMeterBalanceResponse }
     * 
     */
    public GetMeterBalanceResponse createGetMeterBalanceResponse() {
        return new GetMeterBalanceResponse();
    }

    /**
     * Create an instance of {@link ConfirmMeterResp }
     * 
     */
    public ConfirmMeterResp createConfirmMeterResp() {
        return new ConfirmMeterResp();
    }

    /**
     * Create an instance of {@link CustReportFaultResp }
     * 
     */
    public CustReportFaultResp createCustReportFaultResp() {
        return new CustReportFaultResp();
    }

    /**
     * Create an instance of {@link DispInstPwrReq }
     * 
     */
    public DispInstPwrReq createDispInstPwrReq() {
        return new DispInstPwrReq();
    }

    /**
     * Create an instance of {@link DispKRNReq }
     * 
     */
    public DispKRNReq createDispKRNReq() {
        return new DispKRNReq();
    }

    /**
     * Create an instance of {@link DispPhUnbalanceResp }
     * 
     */
    public DispPhUnbalanceResp createDispPhUnbalanceResp() {
        return new DispPhUnbalanceResp();
    }

    /**
     * Create an instance of {@link PhUnbalResp }
     * 
     */
    public PhUnbalResp createPhUnbalResp() {
        return new PhUnbalResp();
    }

    /**
     * Create an instance of {@link SetWaterFactorResp }
     * 
     */
    public SetWaterFactorResp createSetWaterFactorResp() {
        return new SetWaterFactorResp();
    }

    /**
     * Create an instance of {@link DispTamperReq }
     * 
     */
    public DispTamperReq createDispTamperReq() {
        return new DispTamperReq();
    }

    /**
     * Create an instance of {@link SetWaterFactorReq }
     * 
     */
    public SetWaterFactorReq createSetWaterFactorReq() {
        return new SetWaterFactorReq();
    }

    /**
     * Create an instance of {@link DispConsTotTokenIssue }
     * 
     */
    public DispConsTotTokenIssue createDispConsTotTokenIssue() {
        return new DispConsTotTokenIssue();
    }

    /**
     * Create an instance of {@link DispTamperTokenIssue }
     * 
     */
    public DispTamperTokenIssue createDispTamperTokenIssue() {
        return new DispTamperTokenIssue();
    }

    /**
     * Create an instance of {@link TestBreakerResp }
     * 
     */
    public TestBreakerResp createTestBreakerResp() {
        return new TestBreakerResp();
    }

    /**
     * Create an instance of {@link DispPwrLmtReq }
     * 
     */
    public DispPwrLmtReq createDispPwrLmtReq() {
        return new DispPwrLmtReq();
    }

    /**
     * Create an instance of {@link DefCreditResp }
     * 
     */
    public DefCreditResp createDefCreditResp() {
        return new DefCreditResp();
    }

    /**
     * Create an instance of {@link TestDisplayTokenIssue }
     * 
     */
    public TestDisplayTokenIssue createTestDisplayTokenIssue() {
        return new TestDisplayTokenIssue();
    }

    /**
     * Create an instance of {@link DispConsTotResp }
     * 
     */
    public DispConsTotResp createDispConsTotResp() {
        return new DispConsTotResp();
    }

    /**
     * Create an instance of {@link DispInstPwrResp }
     * 
     */
    public DispInstPwrResp createDispInstPwrResp() {
        return new DispInstPwrResp();
    }

    /**
     * Create an instance of {@link DispVerReq }
     * 
     */
    public DispVerReq createDispVerReq() {
        return new DispVerReq();
    }

    /**
     * Create an instance of {@link DispTamperResp }
     * 
     */
    public DispTamperResp createDispTamperResp() {
        return new DispTamperResp();
    }

    /**
     * Create an instance of {@link DispKRNTokenIssue }
     * 
     */
    public DispKRNTokenIssue createDispKRNTokenIssue() {
        return new DispKRNTokenIssue();
    }

    /**
     * Create an instance of {@link DispPhUnbalanceReq }
     * 
     */
    public DispPhUnbalanceReq createDispPhUnbalanceReq() {
        return new DispPhUnbalanceReq();
    }

    /**
     * Create an instance of {@link DispTITokenIssue }
     * 
     */
    public DispTITokenIssue createDispTITokenIssue() {
        return new DispTITokenIssue();
    }

    /**
     * Create an instance of {@link TestAllReq }
     * 
     */
    public TestAllReq createTestAllReq() {
        return new TestAllReq();
    }

    /**
     * Create an instance of {@link MeterFaultReport }
     * 
     */
    public MeterFaultReport createMeterFaultReport() {
        return new MeterFaultReport();
    }

    /**
     * Create an instance of {@link DispTIReq }
     * 
     */
    public DispTIReq createDispTIReq() {
        return new DispTIReq();
    }

    /**
     * Create an instance of {@link PwrLmtResp }
     * 
     */
    public PwrLmtResp createPwrLmtResp() {
        return new PwrLmtResp();
    }

    /**
     * Create an instance of {@link EngKCTResp }
     * 
     */
    public EngKCTResp createEngKCTResp() {
        return new EngKCTResp();
    }

    /**
     * Create an instance of {@link TestBreakerTokenIssue }
     * 
     */
    public TestBreakerTokenIssue createTestBreakerTokenIssue() {
        return new TestBreakerTokenIssue();
    }

    /**
     * Create an instance of {@link ClearTamperReq }
     * 
     */
    public ClearTamperReq createClearTamperReq() {
        return new ClearTamperReq();
    }

    /**
     * Create an instance of {@link ClearTamperResp }
     * 
     */
    public ClearTamperResp createClearTamperResp() {
        return new ClearTamperResp();
    }

    /**
     * Create an instance of {@link DispConsTotReq }
     * 
     */
    public DispConsTotReq createDispConsTotReq() {
        return new DispConsTotReq();
    }

    /**
     * Create an instance of {@link DispKRNResp }
     * 
     */
    public DispKRNResp createDispKRNResp() {
        return new DispKRNResp();
    }

    /**
     * Create an instance of {@link CustFaultReport }
     * 
     */
    public CustFaultReport createCustFaultReport() {
        return new CustFaultReport();
    }

    /**
     * Create an instance of {@link DispPwrLmtTokenIssue }
     * 
     */
    public DispPwrLmtTokenIssue createDispPwrLmtTokenIssue() {
        return new DispPwrLmtTokenIssue();
    }

    /**
     * Create an instance of {@link DispVerResp }
     * 
     */
    public DispVerResp createDispVerResp() {
        return new DispVerResp();
    }

    /**
     * Create an instance of {@link DispTIResp }
     * 
     */
    public DispTIResp createDispTIResp() {
        return new DispTIResp();
    }

    /**
     * Create an instance of {@link GetMeterBalanceResult }
     * 
     */
    public GetMeterBalanceResult createGetMeterBalanceResult() {
        return new GetMeterBalanceResult();
    }

    /**
     * Create an instance of {@link DispInstPwrTokenIssue }
     * 
     */
    public DispInstPwrTokenIssue createDispInstPwrTokenIssue() {
        return new DispInstPwrTokenIssue();
    }

    /**
     * Create an instance of {@link TestDisplayResp }
     * 
     */
    public TestDisplayResp createTestDisplayResp() {
        return new TestDisplayResp();
    }

    /**
     * Create an instance of {@link ClearCreditReq }
     * 
     */
    public ClearCreditReq createClearCreditReq() {
        return new ClearCreditReq();
    }

    /**
     * Create an instance of {@link DefCreditReq }
     * 
     */
    public DefCreditReq createDefCreditReq() {
        return new DefCreditReq();
    }

    /**
     * Create an instance of {@link PhUnbalReq }
     * 
     */
    public PhUnbalReq createPhUnbalReq() {
        return new PhUnbalReq();
    }

    /**
     * Create an instance of {@link TestBreakerReq }
     * 
     */
    public TestBreakerReq createTestBreakerReq() {
        return new TestBreakerReq();
    }

    /**
     * Create an instance of {@link TestAllResp }
     * 
     */
    public TestAllResp createTestAllResp() {
        return new TestAllResp();
    }

    /**
     * Create an instance of {@link DispVerTokenIssue }
     * 
     */
    public DispVerTokenIssue createDispVerTokenIssue() {
        return new DispVerTokenIssue();
    }

    /**
     * Create an instance of {@link EngKCTReq }
     * 
     */
    public EngKCTReq createEngKCTReq() {
        return new EngKCTReq();
    }

    /**
     * Create an instance of {@link PwrLmtReq }
     * 
     */
    public PwrLmtReq createPwrLmtReq() {
        return new PwrLmtReq();
    }

    /**
     * Create an instance of {@link NetworkFaultReport }
     * 
     */
    public NetworkFaultReport createNetworkFaultReport() {
        return new NetworkFaultReport();
    }

    /**
     * Create an instance of {@link ClearCreditResp }
     * 
     */
    public ClearCreditResp createClearCreditResp() {
        return new ClearCreditResp();
    }

    /**
     * Create an instance of {@link CustFaultLog }
     * 
     */
    public CustFaultLog createCustFaultLog() {
        return new CustFaultLog();
    }

    /**
     * Create an instance of {@link DispPwrLmtResp }
     * 
     */
    public DispPwrLmtResp createDispPwrLmtResp() {
        return new DispPwrLmtResp();
    }

    /**
     * Create an instance of {@link TestDisplayReq }
     * 
     */
    public TestDisplayReq createTestDisplayReq() {
        return new TestDisplayReq();
    }

    /**
     * Create an instance of {@link TestAllTokenIssue }
     * 
     */
    public TestAllTokenIssue createTestAllTokenIssue() {
        return new TestAllTokenIssue();
    }

    /**
     * Create an instance of {@link ConfirmMeterResult }
     * 
     */
    public ConfirmMeterResult createConfirmMeterResult() {
        return new ConfirmMeterResult();
    }

    /**
     * Create an instance of {@link DispPhUnbalanceTokenIssue }
     * 
     */
    public DispPhUnbalanceTokenIssue createDispPhUnbalanceTokenIssue() {
        return new DispPhUnbalanceTokenIssue();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeterCreditTransferResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "meterCreditTransferResp")
    public JAXBElement<MeterCreditTransferResp> createMeterCreditTransferResp(MeterCreditTransferResp value) {
        return new JAXBElement<MeterCreditTransferResp>(_MeterCreditTransferResp_QNAME, MeterCreditTransferResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustReportFaultReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "custReportFaultReq")
    public JAXBElement<CustReportFaultReq> createCustReportFaultReq(CustReportFaultReq value) {
        return new JAXBElement<CustReportFaultReq>(_CustReportFaultReq_QNAME, CustReportFaultReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "validateCustomerResponse")
    public JAXBElement<ValidateCustomerResponse> createValidateCustomerResponse(ValidateCustomerResponse value) {
        return new JAXBElement<ValidateCustomerResponse>(_ValidateCustomerResponse_QNAME, ValidateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayAccReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "payAccReq")
    public JAXBElement<PayAccReq> createPayAccReq(PayAccReq value) {
        return new JAXBElement<PayAccReq>(_PayAccReq_QNAME, PayAccReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "verifyResp")
    public JAXBElement<VerifyResp> createVerifyResp(VerifyResp value) {
        return new JAXBElement<VerifyResp>(_VerifyResp_QNAME, VerifyResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "verifyReq")
    public JAXBElement<VerifyReq> createVerifyReq(VerifyReq value) {
        return new JAXBElement<VerifyReq>(_VerifyReq_QNAME, VerifyReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "depositResp")
    public JAXBElement<DepositResp> createDepositResp(DepositResp value) {
        return new JAXBElement<DepositResp>(_DepositResp_QNAME, DepositResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmMeterReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "getMeterBalanceReq")
    public JAXBElement<ConfirmMeterReq> createGetMeterBalanceReq(ConfirmMeterReq value) {
        return new JAXBElement<ConfirmMeterReq>(_GetMeterBalanceReq_QNAME, ConfirmMeterReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FreeIssueReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "freeIssueReq")
    public JAXBElement<FreeIssueReq> createFreeIssueReq(FreeIssueReq value) {
        return new JAXBElement<FreeIssueReq>(_FreeIssueReq_QNAME, FreeIssueReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FBEReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "fbeReq")
    public JAXBElement<FBEReq> createFbeReq(FBEReq value) {
        return new JAXBElement<FBEReq>(_FbeReq_QNAME, FBEReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLVendFaultResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", name = "xmlvendFaultResp")
    public JAXBElement<XMLVendFaultResp> createXmlvendFaultResp(XMLVendFaultResp value) {
        return new JAXBElement<XMLVendFaultResp>(_XmlvendFaultResp_QNAME, XMLVendFaultResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdviceReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", name = "adviceReq")
    public JAXBElement<AdviceReq> createAdviceReq(AdviceReq value) {
        return new JAXBElement<AdviceReq>(_AdviceReq_QNAME, AdviceReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeterSpecificEngReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "meterSpecificEngReq")
    public JAXBElement<MeterSpecificEngReq> createMeterSpecificEngReq(MeterSpecificEngReq value) {
        return new JAXBElement<MeterSpecificEngReq>(_MeterSpecificEngReq_QNAME, MeterSpecificEngReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostYakaPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "postYakaPayment")
    public JAXBElement<PostYakaPayment> createPostYakaPayment(PostYakaPayment value) {
        return new JAXBElement<PostYakaPayment>(_PostYakaPayment_QNAME, PostYakaPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrialCreditVendResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "trialCreditVendResp")
    public JAXBElement<TrialCreditVendResp> createTrialCreditVendResp(TrialCreditVendResp value) {
        return new JAXBElement<TrialCreditVendResp>(_TrialCreditVendResp_QNAME, TrialCreditVendResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmNodeReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "confirmNodeReq")
    public JAXBElement<ConfirmNodeReq> createConfirmNodeReq(ConfirmNodeReq value) {
        return new JAXBElement<ConfirmNodeReq>(_ConfirmNodeReq_QNAME, ConfirmNodeReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartBatchReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "startBatchReq")
    public JAXBElement<StartBatchReq> createStartBatchReq(StartBatchReq value) {
        return new JAXBElement<StartBatchReq>(_StartBatchReq_QNAME, StartBatchReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "getTransactionDetails")
    public JAXBElement<GetTransactionDetails> createGetTransactionDetails(GetTransactionDetails value) {
        return new JAXBElement<GetTransactionDetails>(_GetTransactionDetails_QNAME, GetTransactionDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EndBatchReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "endBatchReq")
    public JAXBElement<EndBatchReq> createEndBatchReq(EndBatchReq value) {
        return new JAXBElement<EndBatchReq>(_EndBatchReq_QNAME, EndBatchReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeterCreditTransferReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "meterCreditTransferReq")
    public JAXBElement<MeterCreditTransferReq> createMeterCreditTransferReq(MeterCreditTransferReq value) {
        return new JAXBElement<MeterCreditTransferReq>(_MeterCreditTransferReq_QNAME, MeterCreditTransferReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VendorStatementResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "vendorStatementResp")
    public JAXBElement<VendorStatementResp> createVendorStatementResp(VendorStatementResp value) {
        return new JAXBElement<VendorStatementResp>(_VendorStatementResp_QNAME, VendorStatementResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderStatusResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", name = "getOrderStatusResp")
    public JAXBElement<GetOrderStatusResp> createGetOrderStatusResp(GetOrderStatusResp value) {
        return new JAXBElement<GetOrderStatusResp>(_GetOrderStatusResp_QNAME, GetOrderStatusResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMeterKeyResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "updateMeterKeyResp")
    public JAXBElement<UpdateMeterKeyResp> createUpdateMeterKeyResp(UpdateMeterKeyResp value) {
        return new JAXBElement<UpdateMeterKeyResp>(_UpdateMeterKeyResp_QNAME, UpdateMeterKeyResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReprintDepositResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "reprintDepResp")
    public JAXBElement<ReprintDepositResp> createReprintDepResp(ReprintDepositResp value) {
        return new JAXBElement<ReprintDepositResp>(_ReprintDepResp_QNAME, ReprintDepositResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VendorStatementReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "vendorStatementReq")
    public JAXBElement<VendorStatementReq> createVendorStatementReq(VendorStatementReq value) {
        return new JAXBElement<VendorStatementReq>(_VendorStatementReq_QNAME, VendorStatementReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderStatusReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", name = "getOrderStatusReq")
    public JAXBElement<GetOrderStatusReq> createGetOrderStatusReq(GetOrderStatusReq value) {
        return new JAXBElement<GetOrderStatusReq>(_GetOrderStatusReq_QNAME, GetOrderStatusReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditVendResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "creditVendResp")
    public JAXBElement<CreditVendResp> createCreditVendResp(CreditVendResp value) {
        return new JAXBElement<CreditVendResp>(_CreditVendResp_QNAME, CreditVendResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReprintDepositReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "reprintDepReq")
    public JAXBElement<ReprintDepositReq> createReprintDepReq(ReprintDepositReq value) {
        return new JAXBElement<ReprintDepositReq>(_ReprintDepReq_QNAME, ReprintDepositReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdviceReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", name = "sendTokenReq")
    public JAXBElement<AdviceReq> createSendTokenReq(AdviceReq value) {
        return new JAXBElement<AdviceReq>(_SendTokenReq_QNAME, AdviceReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrialCreditVendReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "trialCreditVendReq")
    public JAXBElement<TrialCreditVendReq> createTrialCreditVendReq(TrialCreditVendReq value) {
        return new JAXBElement<TrialCreditVendReq>(_TrialCreditVendReq_QNAME, TrialCreditVendReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EndBatchResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "endBatchResp")
    public JAXBElement<EndBatchResp> createEndBatchResp(EndBatchResp value) {
        return new JAXBElement<EndBatchResp>(_EndBatchResp_QNAME, EndBatchResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeterSpecificEngResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "meterSpecificEngResp")
    public JAXBElement<MeterSpecificEngResp> createMeterSpecificEngResp(MeterSpecificEngResp value) {
        return new JAXBElement<MeterSpecificEngResp>(_MeterSpecificEngResp_QNAME, MeterSpecificEngResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FBEResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "fbeResp")
    public JAXBElement<FBEResp> createFbeResp(FBEResp value) {
        return new JAXBElement<FBEResp>(_FbeResp_QNAME, FBEResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonMeterSpecificEngReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "nonMeterSpecificEngReq")
    public JAXBElement<NonMeterSpecificEngReq> createNonMeterSpecificEngReq(NonMeterSpecificEngReq value) {
        return new JAXBElement<NonMeterSpecificEngReq>(_NonMeterSpecificEngReq_QNAME, NonMeterSpecificEngReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditVendReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "creditVendReq")
    public JAXBElement<CreditVendReq> createCreditVendReq(CreditVendReq value) {
        return new JAXBElement<CreditVendReq>(_CreditVendReq_QNAME, CreditVendReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReprintEndBatchResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "reprintEndBatchResp")
    public JAXBElement<ReprintEndBatchResp> createReprintEndBatchResp(ReprintEndBatchResp value) {
        return new JAXBElement<ReprintEndBatchResp>(_ReprintEndBatchResp_QNAME, ReprintEndBatchResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdviceResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", name = "adviceResp")
    public JAXBElement<AdviceResp> createAdviceResp(AdviceResp value) {
        return new JAXBElement<AdviceResp>(_AdviceResp_QNAME, AdviceResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendTokenResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/base/2.1/schema", name = "sendTokenResp")
    public JAXBElement<SendTokenResp> createSendTokenResp(SendTokenResp value) {
        return new JAXBElement<SendTokenResp>(_SendTokenResp_QNAME, SendTokenResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMeterKeyReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "updateMeterKeyReq")
    public JAXBElement<UpdateMeterKeyReq> createUpdateMeterKeyReq(UpdateMeterKeyReq value) {
        return new JAXBElement<UpdateMeterKeyReq>(_UpdateMeterKeyReq_QNAME, UpdateMeterKeyReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FreeIssueResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "freeIssueResp")
    public JAXBElement<FreeIssueResp> createFreeIssueResp(FreeIssueResp value) {
        return new JAXBElement<FreeIssueResp>(_FreeIssueResp_QNAME, FreeIssueResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmMeterResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "confirmMeterResp")
    public JAXBElement<ConfirmMeterResp> createConfirmMeterResp(ConfirmMeterResp value) {
        return new JAXBElement<ConfirmMeterResp>(_ConfirmMeterResp_QNAME, ConfirmMeterResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelVendResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "cancelVendResp")
    public JAXBElement<CancelVendResp> createCancelVendResp(CancelVendResp value) {
        return new JAXBElement<CancelVendResp>(_CancelVendResp_QNAME, CancelVendResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelVendReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "cancelVendReq")
    public JAXBElement<CancelVendReq> createCancelVendReq(CancelVendReq value) {
        return new JAXBElement<CancelVendReq>(_CancelVendReq_QNAME, CancelVendReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TotalBatchResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "totalBatchResp")
    public JAXBElement<TotalBatchResp> createTotalBatchResp(TotalBatchResp value) {
        return new JAXBElement<TotalBatchResp>(_TotalBatchResp_QNAME, TotalBatchResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReprintReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "reprintReq")
    public JAXBElement<ReprintReq> createReprintReq(ReprintReq value) {
        return new JAXBElement<ReprintReq>(_ReprintReq_QNAME, ReprintReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReprintEndBatchReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "reprintEndBatchReq")
    public JAXBElement<ReprintEndBatchReq> createReprintEndBatchReq(ReprintEndBatchReq value) {
        return new JAXBElement<ReprintEndBatchReq>(_ReprintEndBatchReq_QNAME, ReprintEndBatchReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayAccResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "payAccResp")
    public JAXBElement<PayAccResp> createPayAccResp(PayAccResp value) {
        return new JAXBElement<PayAccResp>(_PayAccResp_QNAME, PayAccResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeterBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "getMeterBalanceResponse")
    public JAXBElement<GetMeterBalanceResponse> createGetMeterBalanceResponse(GetMeterBalanceResponse value) {
        return new JAXBElement<GetMeterBalanceResponse>(_GetMeterBalanceResponse_QNAME, GetMeterBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmNodeResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "confirmNodeResp")
    public JAXBElement<ConfirmNodeResp> createConfirmNodeResp(ConfirmNodeResp value) {
        return new JAXBElement<ConfirmNodeResp>(_ConfirmNodeResp_QNAME, ConfirmNodeResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmMeterReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "confirmMeterReq")
    public JAXBElement<ConfirmMeterReq> createConfirmMeterReq(ConfirmMeterReq value) {
        return new JAXBElement<ConfirmMeterReq>(_ConfirmMeterReq_QNAME, ConfirmMeterReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "loginReq")
    public JAXBElement<LoginReq> createLoginReq(LoginReq value) {
        return new JAXBElement<LoginReq>(_LoginReq_QNAME, LoginReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "depositReq")
    public JAXBElement<DepositReq> createDepositReq(DepositReq value) {
        return new JAXBElement<DepositReq>(_DepositReq_QNAME, DepositReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostYakaPaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "postYakaPaymentResponse")
    public JAXBElement<PostYakaPaymentResponse> createPostYakaPaymentResponse(PostYakaPaymentResponse value) {
        return new JAXBElement<PostYakaPaymentResponse>(_PostYakaPaymentResponse_QNAME, PostYakaPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartBatchResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "startBatchResp")
    public JAXBElement<StartBatchResp> createStartBatchResp(StartBatchResp value) {
        return new JAXBElement<StartBatchResp>(_StartBatchResp_QNAME, StartBatchResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmCustomerResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "confirmCustomerResp")
    public JAXBElement<ConfirmCustomerResp> createConfirmCustomerResp(ConfirmCustomerResp value) {
        return new JAXBElement<ConfirmCustomerResp>(_ConfirmCustomerResp_QNAME, ConfirmCustomerResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonMeterSpecificEngResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "nonMeterSpecificEngResp")
    public JAXBElement<NonMeterSpecificEngResp> createNonMeterSpecificEngResp(NonMeterSpecificEngResp value) {
        return new JAXBElement<NonMeterSpecificEngResp>(_NonMeterSpecificEngResp_QNAME, NonMeterSpecificEngResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmCustomerReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "confirmCustomerReq")
    public JAXBElement<ConfirmCustomerReq> createConfirmCustomerReq(ConfirmCustomerReq value) {
        return new JAXBElement<ConfirmCustomerReq>(_ConfirmCustomerReq_QNAME, ConfirmCustomerReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "validateCustomer")
    public JAXBElement<ValidateCustomer> createValidateCustomer(ValidateCustomer value) {
        return new JAXBElement<ValidateCustomer>(_ValidateCustomer_QNAME, ValidateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustReportFaultResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/meter/2.1/schema", name = "custReportFaultResp")
    public JAXBElement<CustReportFaultResp> createCustReportFaultResp(CustReportFaultResp value) {
        return new JAXBElement<CustReportFaultResp>(_CustReportFaultResp_QNAME, CustReportFaultResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TotalBatchReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "totalBatchReq")
    public JAXBElement<TotalBatchReq> createTotalBatchReq(TotalBatchReq value) {
        return new JAXBElement<TotalBatchReq>(_TotalBatchReq_QNAME, TotalBatchReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReprintResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "reprintResp")
    public JAXBElement<ReprintResp> createReprintResp(ReprintResp value) {
        return new JAXBElement<ReprintResp>(_ReprintResp_QNAME, ReprintResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nrs.eskom.co.za/xmlvend/revenue/2.1/schema", name = "user")
    public JAXBElement<LoginUser> createUser(LoginUser value) {
        return new JAXBElement<LoginUser>(_User_QNAME, LoginUser.class, null, value);
    }

}
