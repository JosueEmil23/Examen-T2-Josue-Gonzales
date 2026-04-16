package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import org.junit.Assert;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class LoginStepDefinitions {

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    // Profesor, Comente este @When para q no genere un error de duplicado
    /*@When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
    }*/

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo("Products"))
        );
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

    }

    @When("she logs in with username {string} and password {string}")
    public void sheLogsInWithUsernameAndPassword(String username, String password){
        OnStage.theActorInTheSpotlight().remember("INICIO", System.currentTimeMillis());

        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
    }

    @And("the page load time should be greater than {int} milliseconds")
    public void thePageLoadTimeShouldBeGreaterThan3000Milliseconds(int milisegundos){
        long inicio = OnStage.theActorInTheSpotlight().recall("INICIO");
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;
        Assert.assertTrue("El tiempo fue menor al esperado", duracion>= milisegundos);
    }

    @And("she navigates to the cart page")
    public void sheNavigatesToTheCartPage(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(".shopping_cart_link")
        );
    }

    @And("she navigates back to the inventory page")
    public void sheNavigatesBackToTheInventoryPage(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Task.where("{0} regresa a la ventana anterior",
                actor -> BrowseTheWebWithPlaywright.as(actor).getCurrentPage().goBack()
           )
        );
    }

    @Then("she should still be logged in")
    public void sheShouldStillBeLoggedIn(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.withTitle("Products")
        );
    }

}
