package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by alexis on 4/12/2016.
 */

@Entity
@Table(name = "ORDERS")
public class Calculation extends Model {

    @Column(name="PRICE")
    private float price ;



    private float finalPrice;

    public static Finder<Long, airtimeStore> find = new Finder<Long, airtimeStore>(Long.class, airtimeStore.class);


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public static List<airtimeStore> all() {
        return (find.all());
    }
    public static airtimeStore findById(Long id) {
        return (find.ref(id));
    }


}
