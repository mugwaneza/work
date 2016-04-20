package controllers;

import models.powerData;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.electricity;
import views.html.historyPower;

import static play.data.Form.form;

/**
 * Created by alexis on 3/28/2016.
 */
public class Power extends Controller {


    public  static     Result show_powerForm(){
    Form<powerData> formData = Form.form(powerData.class);
        return ok(electricity.render(formData));
    }

public static Result sell_Power() {
    Form<powerData> formData = form(powerData.class).bindFromRequest();
    powerData.sendPower(formData.get());


    return ok("Power sent");

}
    public static Result showHistoryPower() {

        Form<powerData> taskData = form(powerData.class);
        return ok(historyPower.render(powerData.umuriro(), taskData));
    }

}