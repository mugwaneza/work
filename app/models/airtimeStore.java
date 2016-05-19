package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by alexis on 4/6/2016.
 */
@Entity
@Table(name = "store")
public class airtimeStore extends Model {

    @Id
    public Long id;

    public int amount =0;
     public Timestamp updated = new Timestamp(new Date().getTime());

    public static Finder<Long, airtimeStore> find = new Finder(Long.class, airtimeStore.class);

    public static List<airtimeStore> all() {
        return find.all();
    }

    public static airtimeStore findById(Long id) {return (find.ref(id));}


    /*
    public static General_store findByAmount(String amount) {
        return find.where().eq("amount", amount).findUnique();
    }


*/

    public static void recharge(airtimeStore storedb) {


    storedb.save();

        }

    public static long sumOfStores() {
        final String sql = "SELECT SUM(amount) as total FROM store";
        SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
        SqlRow row = sqlQuery.findUnique();
        return row.getInteger("total");
    }



}

