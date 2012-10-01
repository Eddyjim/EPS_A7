
package eci.cosw.eps.integration.ips;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eci.cosw.eps.integration.ips package. 
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

    private final static QName _UpdateMedicalHistory_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "updateMedicalHistory");
    private final static QName _RegisterAppointmentResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "registerAppointmentResponse");
    private final static QName _AvailableScheduleResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "availableScheduleResponse");
    private final static QName _UpdateMedicalHistoryResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "updateMedicalHistoryResponse");
    private final static QName _ShowUpAppointmentResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "showUpAppointmentResponse");
    private final static QName _EnumerateSpecialists_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "enumerateSpecialists");
    private final static QName _AvailableSchedule_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "availableSchedule");
    private final static QName _TodayScheduleDetails_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "todayScheduleDetails");
    private final static QName _PatientDetailsResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "patientDetailsResponse");
    private final static QName _ShowUpAppointment_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "showUpAppointment");
    private final static QName _AppointmentDetailsResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "appointmentDetailsResponse");
    private final static QName _CarryOutAppointment_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "carryOutAppointment");
    private final static QName _DueBills_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "dueBills");
    private final static QName _DueBillsResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "dueBillsResponse");
    private final static QName _CancelAppointment_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "cancelAppointment");
    private final static QName _CancelAppointmentResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "cancelAppointmentResponse");
    private final static QName _CarryOutAppointmentResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "carryOutAppointmentResponse");
    private final static QName _RegisterAppointment_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "registerAppointment");
    private final static QName _WebServicesException_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "WebServicesException");
    private final static QName _PatientDetails_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "patientDetails");
    private final static QName _AppointmentDetails_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "appointmentDetails");
    private final static QName _EnumerateSpecialistsResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "enumerateSpecialistsResponse");
    private final static QName _TodayScheduleDetailsResponse_QNAME = new QName("http://services.b8.cosw.eci.edu.co/", "todayScheduleDetailsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eci.cosw.eps.integration.ips
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateMedicalHistoryResponse }
     * 
     */
    public UpdateMedicalHistoryResponse createUpdateMedicalHistoryResponse() {
        return new UpdateMedicalHistoryResponse();
    }

    /**
     * Create an instance of {@link ShowUpAppointmentResponse }
     * 
     */
    public ShowUpAppointmentResponse createShowUpAppointmentResponse() {
        return new ShowUpAppointmentResponse();
    }

    /**
     * Create an instance of {@link AvailableScheduleResponse }
     * 
     */
    public AvailableScheduleResponse createAvailableScheduleResponse() {
        return new AvailableScheduleResponse();
    }

    /**
     * Create an instance of {@link RegisterAppointmentResponse }
     * 
     */
    public RegisterAppointmentResponse createRegisterAppointmentResponse() {
        return new RegisterAppointmentResponse();
    }

    /**
     * Create an instance of {@link UpdateMedicalHistory }
     * 
     */
    public UpdateMedicalHistory createUpdateMedicalHistory() {
        return new UpdateMedicalHistory();
    }

    /**
     * Create an instance of {@link PatientDetailsResponse }
     * 
     */
    public PatientDetailsResponse createPatientDetailsResponse() {
        return new PatientDetailsResponse();
    }

    /**
     * Create an instance of {@link TodayScheduleDetails }
     * 
     */
    public TodayScheduleDetails createTodayScheduleDetails() {
        return new TodayScheduleDetails();
    }

    /**
     * Create an instance of {@link AvailableSchedule }
     * 
     */
    public AvailableSchedule createAvailableSchedule() {
        return new AvailableSchedule();
    }

    /**
     * Create an instance of {@link EnumerateSpecialists }
     * 
     */
    public EnumerateSpecialists createEnumerateSpecialists() {
        return new EnumerateSpecialists();
    }

    /**
     * Create an instance of {@link DueBills }
     * 
     */
    public DueBills createDueBills() {
        return new DueBills();
    }

    /**
     * Create an instance of {@link CarryOutAppointment }
     * 
     */
    public CarryOutAppointment createCarryOutAppointment() {
        return new CarryOutAppointment();
    }

    /**
     * Create an instance of {@link ShowUpAppointment }
     * 
     */
    public ShowUpAppointment createShowUpAppointment() {
        return new ShowUpAppointment();
    }

    /**
     * Create an instance of {@link AppointmentDetailsResponse }
     * 
     */
    public AppointmentDetailsResponse createAppointmentDetailsResponse() {
        return new AppointmentDetailsResponse();
    }

    /**
     * Create an instance of {@link TodayScheduleDetailsResponse }
     * 
     */
    public TodayScheduleDetailsResponse createTodayScheduleDetailsResponse() {
        return new TodayScheduleDetailsResponse();
    }

    /**
     * Create an instance of {@link EnumerateSpecialistsResponse }
     * 
     */
    public EnumerateSpecialistsResponse createEnumerateSpecialistsResponse() {
        return new EnumerateSpecialistsResponse();
    }

    /**
     * Create an instance of {@link AppointmentDetails }
     * 
     */
    public AppointmentDetails createAppointmentDetails() {
        return new AppointmentDetails();
    }

    /**
     * Create an instance of {@link PatientDetails }
     * 
     */
    public PatientDetails createPatientDetails() {
        return new PatientDetails();
    }

    /**
     * Create an instance of {@link WebServicesException }
     * 
     */
    public WebServicesException createWebServicesException() {
        return new WebServicesException();
    }

    /**
     * Create an instance of {@link RegisterAppointment }
     * 
     */
    public RegisterAppointment createRegisterAppointment() {
        return new RegisterAppointment();
    }

    /**
     * Create an instance of {@link CarryOutAppointmentResponse }
     * 
     */
    public CarryOutAppointmentResponse createCarryOutAppointmentResponse() {
        return new CarryOutAppointmentResponse();
    }

    /**
     * Create an instance of {@link CancelAppointmentResponse }
     * 
     */
    public CancelAppointmentResponse createCancelAppointmentResponse() {
        return new CancelAppointmentResponse();
    }

    /**
     * Create an instance of {@link CancelAppointment }
     * 
     */
    public CancelAppointment createCancelAppointment() {
        return new CancelAppointment();
    }

    /**
     * Create an instance of {@link DueBillsResponse }
     * 
     */
    public DueBillsResponse createDueBillsResponse() {
        return new DueBillsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMedicalHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "updateMedicalHistory")
    public JAXBElement<UpdateMedicalHistory> createUpdateMedicalHistory(UpdateMedicalHistory value) {
        return new JAXBElement<UpdateMedicalHistory>(_UpdateMedicalHistory_QNAME, UpdateMedicalHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "registerAppointmentResponse")
    public JAXBElement<RegisterAppointmentResponse> createRegisterAppointmentResponse(RegisterAppointmentResponse value) {
        return new JAXBElement<RegisterAppointmentResponse>(_RegisterAppointmentResponse_QNAME, RegisterAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvailableScheduleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "availableScheduleResponse")
    public JAXBElement<AvailableScheduleResponse> createAvailableScheduleResponse(AvailableScheduleResponse value) {
        return new JAXBElement<AvailableScheduleResponse>(_AvailableScheduleResponse_QNAME, AvailableScheduleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMedicalHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "updateMedicalHistoryResponse")
    public JAXBElement<UpdateMedicalHistoryResponse> createUpdateMedicalHistoryResponse(UpdateMedicalHistoryResponse value) {
        return new JAXBElement<UpdateMedicalHistoryResponse>(_UpdateMedicalHistoryResponse_QNAME, UpdateMedicalHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowUpAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "showUpAppointmentResponse")
    public JAXBElement<ShowUpAppointmentResponse> createShowUpAppointmentResponse(ShowUpAppointmentResponse value) {
        return new JAXBElement<ShowUpAppointmentResponse>(_ShowUpAppointmentResponse_QNAME, ShowUpAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumerateSpecialists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "enumerateSpecialists")
    public JAXBElement<EnumerateSpecialists> createEnumerateSpecialists(EnumerateSpecialists value) {
        return new JAXBElement<EnumerateSpecialists>(_EnumerateSpecialists_QNAME, EnumerateSpecialists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvailableSchedule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "availableSchedule")
    public JAXBElement<AvailableSchedule> createAvailableSchedule(AvailableSchedule value) {
        return new JAXBElement<AvailableSchedule>(_AvailableSchedule_QNAME, AvailableSchedule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TodayScheduleDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "todayScheduleDetails")
    public JAXBElement<TodayScheduleDetails> createTodayScheduleDetails(TodayScheduleDetails value) {
        return new JAXBElement<TodayScheduleDetails>(_TodayScheduleDetails_QNAME, TodayScheduleDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "patientDetailsResponse")
    public JAXBElement<PatientDetailsResponse> createPatientDetailsResponse(PatientDetailsResponse value) {
        return new JAXBElement<PatientDetailsResponse>(_PatientDetailsResponse_QNAME, PatientDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowUpAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "showUpAppointment")
    public JAXBElement<ShowUpAppointment> createShowUpAppointment(ShowUpAppointment value) {
        return new JAXBElement<ShowUpAppointment>(_ShowUpAppointment_QNAME, ShowUpAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppointmentDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "appointmentDetailsResponse")
    public JAXBElement<AppointmentDetailsResponse> createAppointmentDetailsResponse(AppointmentDetailsResponse value) {
        return new JAXBElement<AppointmentDetailsResponse>(_AppointmentDetailsResponse_QNAME, AppointmentDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarryOutAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "carryOutAppointment")
    public JAXBElement<CarryOutAppointment> createCarryOutAppointment(CarryOutAppointment value) {
        return new JAXBElement<CarryOutAppointment>(_CarryOutAppointment_QNAME, CarryOutAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DueBills }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "dueBills")
    public JAXBElement<DueBills> createDueBills(DueBills value) {
        return new JAXBElement<DueBills>(_DueBills_QNAME, DueBills.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DueBillsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "dueBillsResponse")
    public JAXBElement<DueBillsResponse> createDueBillsResponse(DueBillsResponse value) {
        return new JAXBElement<DueBillsResponse>(_DueBillsResponse_QNAME, DueBillsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "cancelAppointment")
    public JAXBElement<CancelAppointment> createCancelAppointment(CancelAppointment value) {
        return new JAXBElement<CancelAppointment>(_CancelAppointment_QNAME, CancelAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "cancelAppointmentResponse")
    public JAXBElement<CancelAppointmentResponse> createCancelAppointmentResponse(CancelAppointmentResponse value) {
        return new JAXBElement<CancelAppointmentResponse>(_CancelAppointmentResponse_QNAME, CancelAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarryOutAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "carryOutAppointmentResponse")
    public JAXBElement<CarryOutAppointmentResponse> createCarryOutAppointmentResponse(CarryOutAppointmentResponse value) {
        return new JAXBElement<CarryOutAppointmentResponse>(_CarryOutAppointmentResponse_QNAME, CarryOutAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "registerAppointment")
    public JAXBElement<RegisterAppointment> createRegisterAppointment(RegisterAppointment value) {
        return new JAXBElement<RegisterAppointment>(_RegisterAppointment_QNAME, RegisterAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebServicesException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "WebServicesException")
    public JAXBElement<WebServicesException> createWebServicesException(WebServicesException value) {
        return new JAXBElement<WebServicesException>(_WebServicesException_QNAME, WebServicesException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "patientDetails")
    public JAXBElement<PatientDetails> createPatientDetails(PatientDetails value) {
        return new JAXBElement<PatientDetails>(_PatientDetails_QNAME, PatientDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppointmentDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "appointmentDetails")
    public JAXBElement<AppointmentDetails> createAppointmentDetails(AppointmentDetails value) {
        return new JAXBElement<AppointmentDetails>(_AppointmentDetails_QNAME, AppointmentDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumerateSpecialistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "enumerateSpecialistsResponse")
    public JAXBElement<EnumerateSpecialistsResponse> createEnumerateSpecialistsResponse(EnumerateSpecialistsResponse value) {
        return new JAXBElement<EnumerateSpecialistsResponse>(_EnumerateSpecialistsResponse_QNAME, EnumerateSpecialistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TodayScheduleDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.b8.cosw.eci.edu.co/", name = "todayScheduleDetailsResponse")
    public JAXBElement<TodayScheduleDetailsResponse> createTodayScheduleDetailsResponse(TodayScheduleDetailsResponse value) {
        return new JAXBElement<TodayScheduleDetailsResponse>(_TodayScheduleDetailsResponse_QNAME, TodayScheduleDetailsResponse.class, null, value);
    }

}
