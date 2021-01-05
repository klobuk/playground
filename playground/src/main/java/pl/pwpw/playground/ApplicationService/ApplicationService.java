package pl.pwpw.playground.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.pwpw.playground.application.Application;
import pl.pwpw.playground.application.ContactDetails;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private JdbcTemplate jtm;

    public List<Application> findAll() {
        String sql =  "SELECT * FROM APPLICATION";
        return jtm.query(sql, new BeanPropertyRowMapper<>(Application.class));
    }

    public ContactDetails findById(Long id) {

        String sql = "SELECT EMAIL_ADDRESS, PHONE_NUMBER FROM APPLICATION WHERE APP_ID = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(ContactDetails.class));
    }


    public ContactDetails findByNr(String nr) {

        String sql = "SELECT EMAIL_ADDRESS, PHONE_NUMBER FROM APPLICATION WHERE APPLICATION_NUMBER LIKE ?";

        return jtm.queryForObject(sql, new Object[]{nr},
                new BeanPropertyRowMapper<>(ContactDetails.class));
    }

    public Application findByEmail(String email) {

        String sql = "SELECT * FROM APPLICATION WHERE EMAIL_ADDRESS like ?";

        return jtm.queryForObject(sql, new Object[]{email},
                new BeanPropertyRowMapper<>(Application.class));
    }
}
