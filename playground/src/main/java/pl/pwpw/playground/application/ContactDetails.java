package pl.pwpw.playground.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 *
 */
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ContactDetails {

    @Embedded
    private EmailAddress emailAddress;

    @Embedded
    private PhoneNumber phoneNumber;

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "emailAddress=" + emailAddress.getEmailAddress() +
                ", phoneNumber=" + phoneNumber.getPhoneNumber() +
                '}';
    }

}
