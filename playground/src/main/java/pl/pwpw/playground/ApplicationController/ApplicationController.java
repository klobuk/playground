package pl.pwpw.playground.ApplicationController;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwpw.playground.application.Application;
import pl.pwpw.playground.application.ApplicationType;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pwpw.playground.ApplicationService.ApplicationService;
import pl.pwpw.playground.application.ContactDetails;


import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;


    @RequestMapping("/application")
    public List<Application> findApplication()
    {
        return applicationService.findAll();
    }

    @RequestMapping("/contactDetails/{APP_ID}")
    public ContactDetails findContact(@PathVariable Long APP_ID) {

        return applicationService.findById(APP_ID);
    }

    @RequestMapping("/contactDetailsNr")
    public ContactDetails findContactParam(@RequestParam String APP_NR) {

        return applicationService.findByNr(APP_NR);
    }

    @RequestMapping("/findByEmail/{EMAIL_ADDRESS}")
    public String findByEmail(@PathVariable String EMAIL_ADDRESS) {
        Application as = applicationService.findByEmail(EMAIL_ADDRESS);
        ApplicationType at = as.getApplicationType();
        String nr =as.getApplicationNumber().getApplicationNumber();
        String lname = as.getLastName();
        String tmp = "ApplicationType: "+at+" ApplicationNumber: "+nr+" LastName: "+lname;
        return tmp;
    }

    @ExceptionHandler (EmptyResultDataAccessException.class)
    public ResponseEntity<String> noApplicationFound(EmptyResultDataAccessException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Application Found");
    }
}
