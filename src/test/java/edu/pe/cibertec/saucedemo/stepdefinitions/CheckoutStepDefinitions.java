package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheOrderSummary;
import edu.pe.cibertec.saucedemo.tasks.CompletarInformacion;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import org.hamcrest.Matchers;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckoutWithFirstNameLastNameAndPostalCode(String fName, String lName, String zip){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on("#shopping_cart_container"),
                Click.on(CheckoutPage.CHEACKOUT_BUTTON),
                CompletarInformacion.whitData(fName, lName, zip),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesTheOrderSummaryShowsItemTotal(String expectedTotal){
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheOrderSummary.totalItem(), containsString(expectedTotal))
        );
    }

    @And("she completes the order")
    public void sheCompletesTheOrder(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeTheConfirmationMessage(String message){
        //Profesor se agrego esta linea para q el test espere hasta q el texto se renderice, fue la unica solucion q me funciono.
        OnStage.theActorInTheSpotlight().should(
                seeThat("El mensaje de confirmación",
                        actor -> {

                            var page = net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright.as(actor).getCurrentPage();

                            page.waitForSelector(".complete-header", new com.microsoft.playwright.Page.WaitForSelectorOptions().setTimeout(5000));
                            return page.innerText(".complete-header");
                        },
                        Matchers.containsString(message)
                )
        );
    }

    @And("the checkout form should remain visible")
    public void theCheckoutFormShouldRemainVisible(){
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheOrderSummary.formVisibility(), equalTo(true))
        );
    }


}
