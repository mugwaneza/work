package controllers;

import models.login;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.loginSupervisor;

/**
 * Created by alexis on 4/17/2016.
 */
public class Session extends Controller {
    // -- Authentication

    public static class Login {

        public String email;
        public String password;
        public Login() {
        }
        public String validate() {
            if(login.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }

    /**
     * Login page.
     */
    public static Result login() {
        Form<Login>loginData =Form.form(Login.class);

        return ok(loginSupervisor.render(Form.form(Login.class)));
    }

    /**
     * Handle loginSupervisor form submission.
     */
    public static Result authenticate() {
        Form<Login>loginData =Form.form(Login.class).bindFromRequest();
        if(loginData.hasErrors()) {
            return badRequest(loginSupervisor.render(loginData));
        } else {
            session("email", loginData.get().email);
            return ok("gude loged in");

        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.Session.login()
        );
    }


}
