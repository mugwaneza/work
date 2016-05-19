package models;


import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="user_account")
public class Accounts extends Model {

    @Id
    @Constraints.Required
    public Long acc_id;

    @Constraints.Required
    @Formats.NonEmpty
    public String username;

    @Constraints.Required
    @Formats.NonEmpty
    public String password;

    @Constraints.Required
    public int group_id;

    // Queries

    public static Finder<Long,Accounts> find = new Finder<Long,Accounts>(Long.class, Accounts.class);
    public static List<Accounts> findAll() {
        return find.all();
    }

    public static Accounts findByUsername(String username) {
        return find.where().eq("username", username).findUnique();
    }


    public static Accounts autholise(String username, String password) {


        return find.where()
                .eq("username", username)
                .eq("password", password)
                .findUnique();

    }

    public String toString() {
        return "Accounts(" + username + ")";
    }
}

