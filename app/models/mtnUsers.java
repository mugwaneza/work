package models;

import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Company entity managed by ebean.
 */
@Entity
@Table(name = "mtn")
public class mtnUsers extends Model {

    @Id
    public Long id;

    @Required /*@MinLength(12)*/

    @Constraints.Pattern(value = "[0-9.+]+", message = "A valid phone number is required")
    public String phoneNumber;
    @Required
    public String firstName;
    @Required
    public String lastName;

    @Required
    public String client ;

    @Required
    public int amount ;

    public Timestamp doneAt = new Timestamp(new Date().getTime());;

    public static Finder<Long, mtnUsers> find = new Finder <Long , mtnUsers> (Long.class, mtnUsers.class);


    public static void save(mtnUsers customer) {

                 customer.save();
    }

    public static List<mtnUsers> MTN() {
        return find.all();
    }

}