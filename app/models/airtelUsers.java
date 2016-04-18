package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by alexis on 4/5/2016.
 */
@Entity
@Table(name = "airtel")
public class airtelUsers extends Model {




    @Id
    public Long id;

    @Constraints.Required
    public int phoneNumber;
    public String firstName;
    public String lastName;
    public String client;
    public int amount;
    public Timestamp doneAt = new Timestamp(new Date().getTime());

    public static Model.Finder<Long, airtelUsers> find = new Finder(Long.class, airtelUsers.class);

    public static void save(airtelUsers customer) {

            customer.save();

    }
    public static List<airtelUsers> Airtel() {
        return find.all();
    }

}
