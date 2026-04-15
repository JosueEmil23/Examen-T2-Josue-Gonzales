package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheCartCount;
import edu.pe.cibertec.saucedemo.questions.TheProductsOnCart;
import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.interactions.Click;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;


public class CarritoStepDefinitions {

    @And("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName){
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.product(productName)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String quantity){
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCartCount.value(), equalTo(quantity))
        );
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContain(String p1, String p2){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CarritoPage.CART_LINK)
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductsOnCart.names(), hasItem(p1)),
                seeThat(TheProductsOnCart.names(), hasItem(p2))
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName){
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.product(productName)
        );
    }

    @And("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String p1){
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductsOnCart.names(), hasItem(p1))
        );
    }
}
