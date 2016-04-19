package controllers;

import models.signupInfo;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.signup;
import views.html.summary;

import static play.data.Form.form;

/**
 * Created by alexis on 4/19/2016.
 */
public class Signup  extends Controller {

    /**
     * Defines a form wrapping the User class.
     */
    final static Form<signupInfo> signupForm = form(signupInfo.class);

    /**
     * Display a blank form.
     */
    public static Result register() {
        return ok(signup.render(signupForm));
    }



    /**
     * Handle the form submission.
     */
    public static Result registerSubmition() {
        Form<signupInfo> filledForm = signupForm.bindFromRequest();
            signupInfo.create(filledForm.get());
            signupInfo created = filledForm.get();
            return ok(summary.render(created));
        }
    }


