package pl.pwpw.playground.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 *
 */
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationNumber {

    private String applicationNumber;

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }
}
