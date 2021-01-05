package pl.pwpw.playground.application;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Application {
    @Id
    @SequenceGenerator(name = "app_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_id_seq")
    private Long appId;

    @Embedded
    private ApplicationNumber applicationNumber;

    private String firstName;
    private String lastName;

    @Embedded
    private ContactDetails contactDetails;

    @Enumerated(EnumType.STRING)
    private ApplicationType applicationType;


    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public ApplicationNumber getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(ApplicationNumber applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

}
