package models;



import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by alexis on 4/19/2016.
 */
@Entity
@Table(name ="users")
public class signupInfo extends Model {

    public String username;

    public String email;

    public String password;



    public String type;
    public Timestamp doneAt = new Timestamp(new Date().getTime());
    public signupInfo() {}

    public signupInfo(String username, String email, String password, String type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
    }
    public static void create(signupInfo account) {

        account.save();
    }



}
