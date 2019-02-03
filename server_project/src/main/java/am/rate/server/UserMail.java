package am.rate.server;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users_email")
public class UserMail {
    @Id
    @Column(name = "email")
    @Email(regexp = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")
    private String email;
    @Column(name = "user_name")
    private String name;
    @OneToMany(mappedBy = "userMail", cascade = CascadeType.ALL)
    private List<Services> services = new ArrayList<Services>();
    @Column(name = "waiting_for_a_response", columnDefinition = "boolean default true", nullable = false)
    private boolean waitingForAResponse = true;

    public UserMail() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public boolean isWaitingForAResponse() {
        return waitingForAResponse;
    }

    public void setWaitingForAResponse(boolean waitingForAResponse) {
        this.waitingForAResponse = waitingForAResponse;
    }
}
