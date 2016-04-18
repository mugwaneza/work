package controllers;

import models.power;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.electricityFormData;
import views.html.electricity;
import views.html.historyPower;

import static play.data.Form.form;

/**
 * Created by alexis on 3/28/2016.
 */
public class Power extends Controller {


    public  static     Result show_powerForm(){
    Form<electricityFormData> formData = Form.form(electricityFormData.class);
        return ok(electricity.render("Selling eletricity..", formData));
    }

public static Result sell_Power() {

    Form<power> formData = Form.form(power.class).bindFromRequest();
    power.sendPower(formData.get());
    return ok("Power sent");

}
    public static Result showHistoryPower() {

        Form<power> taskData = form(power.class);
        return ok(historyPower.render(power.power(), taskData));
    }

}