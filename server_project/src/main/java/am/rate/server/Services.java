package am.rate.server;

import javax.persistence.*;

@Entity
@Table(name = "services", uniqueConstraints = {@UniqueConstraint(columnNames = {"currency","fk_userMail"}) })
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(name = "value_that_interests")
    private Float valueThatInterests;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_userMail")
    private UserMail userMail;

    public Services() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Float getValueThatInterests() {
        return valueThatInterests;
    }

    public void setValueThatInterests(Float valueThatInterests) {
        this.valueThatInterests = valueThatInterests;
    }

    public UserMail getUserMail() {
        return userMail;
    }

    public void setUserMail(UserMail userMail) {
        this.userMail = userMail;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", currency=" + currency +
                ", valueThatInterests=" + valueThatInterests +
                '}';
    }
}
