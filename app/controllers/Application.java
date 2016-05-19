package controllers;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.LoginFormData;
import views.html.customer;
import views.html.historyMtn;
import views.html.index;

import static play.data.Form.form;


public class Application extends Controller {

    public static Result index() {
        Form<LoginFormData> formData = Form.form(LoginFormData.class);
        return ok(index.render("welcome", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }


    /**
     * First we bind the HTTP POST data to an instance of LoginFormData.
     * Processes a loginSupervisor form submission from an unauthenticated user.
     * The binding process will invoke the LoginFormData.validate() method.
     * If errors are found, re-render the page, displaying the error data.
     * If errors not found, render the page with the good data.
     *
     * @return The index page with the results of validation.
     */
    public static Result postLogin() {

        // Get the submitted form data from the request object, and run validation.
        Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();
        if (formData.hasErrors()) {
            flash("error", "Login credentials not valid.");
            return badRequest(index.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
        } else {
            // email/password OK, so now we set the session variable and only go to authenticated pages.
            session().clear();
            session("email", formData.get().email);
            return redirect(routes.Application.profile());
        }
    }

    /**
     * Logs out (only for authenticated users) and returns them to the Index page.
     *
     * @return A redirect to the Index page.
     */
    @Security.Authenticated(Secured.class)
    public static Result logout() {
        session().clear();
        return redirect(routes.Application.index());
    }

    /**
     * Provides the Profile page (only to authenticated users).
     *
     * @return The Profile page.
     */
    @Security.Authenticated(Secured.class)
      public static Result profile() {

        Form<mtnUsers> formData = Form.form(mtnUsers.class);
        return ok(customer.render( formData));
    }


    public static Result sell_airtime( ) {


        Form<mtnUsers> formData_one = Form.form(mtnUsers.class).bindFromRequest();
        Form<tigoUsers> formData_two = Form.form(tigoUsers.class).bindFromRequest();
        Form<airtelUsers> formData_three = Form.form(airtelUsers.class).bindFromRequest();

       if (formData_one.hasErrors() && formData_two.hasErrors() && formData_three.hasErrors())   {
            flash("error", " Please fill vaccant field ...");

            return badRequest(views.html.customer.render(formData_one));
        }

        if (formData_one.get().client.equals("select")) {
            flash("error", " Please select select user ..");
            return badRequest(views.html.customer.render(formData_one));
        }

        else {

            if (formData_one.get().client.equals("MTN")) {

                    mtnUsers.save(formData_one.get());


                    String amount = formData_one.bindFromRequest().field("amount").value();
                    int am = Integer.parseInt(amount);

                    long storeId = 0;
                    for (airtimeStore a : airtimeStore.all()) {
                        storeId = a.id;
                    }
                    airtimeStore airtimeStore1 = airtimeStore.findById(storeId);
                    airtimeStore1.amount = airtimeStore1.amount - am;
                    airtimeStore1.save();

                    return ok("Mituyu yagiye kuri MTN successfully");

            } else if (formData_one.get().client.equals("Tigo")) {
                tigoUsers.save(formData_two.get());
                return ok("Mituyu yagiye kuri TIGO successfully");
            } else if (formData_one.get().client.equals("Airtel")) {
                airtelUsers.save(formData_three.get());
                return ok("Mituyu yagiye kuri AIRTEL successfully");
            } else {
                return ok("Oops failed...");
            }
        }
        }


    public static Result MTNHistoryAirtime(){
    Form<mtnUsers> taskData = form(mtnUsers.class);
        return ok(historyMtn.render(mtnUsers.MTN(), taskData));

    }

    public static Result TigoHistoryAirtime(){
        Form<tigoUsers> taskData = form(tigoUsers.class);
        return ok(views.html.historyTigo.render(tigoUsers.Tigo(), taskData));
    }
    public static Result AirtelHistoryAirtime() {
        Form<airtelUsers> taskData = form(airtelUsers.class);
        return ok(views.html.historyAirtel.render(airtelUsers.Airtel(), taskData));
    }



    public static class LoginUser {

        public String username;
        public String password;
        public LoginUser() {
        }
        public String validate() {
            if(Accounts.autholise(username, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }

    /**
     * Login page.
     */
    public static Result loginUser() {
        Form<LoginUser> loginForm = Form.form(LoginUser.class);

        return ok(views.html.login.render(Form.form(LoginUser.class)) );
    }

    /**
     * Handle login form submission.
     */
    public static Result authenticateUser() {
        Form<LoginUser> loginForm = Form.form(LoginUser.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(views.html.login.render(loginForm));
        } else {
            session("username", loginForm.get().password);
            return ok("gude loged in");
        }
    }

    /**
     * Logout and clean the session.
     */

    public static Result logoutUser() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/  ");
    }
























    public static Result AddAirtel() {





        return ok(views.html.airtelAdd.render());
    }

    public static Result saveAirtel() {
        Form<mtnUsers> airtelForm = Form.form(mtnUsers.class).bindFromRequest();



            mtnUsers customer = airtelForm.get();

        /*System.out.format("%s,%s,%s,%s,%sn",customer.phoneNumber,customer.firstName,customer.lastName,customer.user,customer.amount);*/

            return redirect("/add/airtel/form");
        }
    }







