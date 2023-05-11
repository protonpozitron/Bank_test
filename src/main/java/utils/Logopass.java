package utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "General")
public class Logopass {
    private String login;
    private String password;
    public Logopass(String login, String password) {
        this.password = password;
        this.login = login;
    }
    public String getpass() {
        return password;
    }
    public String getlogin() {
        return login;
    }
    public void setpass(String password) {
        this.password = password;
    }
    public void setlogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {

            return String.format("name: '%s'\n" +
                    "login: '%s' password: '%s'\n" +
                    "roles: %s",  login, password);
    }
}
