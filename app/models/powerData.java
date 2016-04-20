package models;


import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by alexis on 4/5/2016.
 */
@Entity
public class powerData extends Model {


    @Id
    public Long id;

    @Constraints.Required
    public int meterNumber;

    @Constraints.Required
    public String customerNames;

    @Constraints.Required
    public int amount;
    public Timestamp doneAt = new Timestamp(new Date().getTime());



    public static Finder<Long, powerData> find = new Finder(Long.class, powerData.class);

    public static void sendPower(powerData electricity) {

            electricity.save();
    }

    /*
    public static List<Power> powerhistory(final User amount) {
        return find
                .where()
                .eq("amount", amount)
                .findList();
    }
    */
    public static List<powerData> umuriro() {
        return find.all();
    }



}
