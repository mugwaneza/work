package controllers;

import models.airtimeStore;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.store;

import static play.data.Form.form;

/**
 * Created by alexis on 4/6/2016.
 */
public class Store extends Controller {

    public static Result show_storeForm(){
      Form<airtimeStore> taskData = form(airtimeStore.class);
        return ok(store.render(taskData));
    }





    public static Result recharge_store(){
      Form<airtimeStore> taskData = form(airtimeStore.class);
        Form<airtimeStore> tasks = taskData.bindFromRequest();
        airtimeStore.recharge(tasks.get());
       return ok ("Stored successfully");
    }
    public static Result ShowBalance( ) {
  Form<airtimeStore> taskData = form(airtimeStore.class);
        return ok(views.html.balance.render(airtimeStore.sumOfStores(),taskData)

        );}

}




