package edu.pe.cibertec.saucedemo.stepdefinitions;


import edu.pe.cibertec.saucedemo.questions.TheProductPrice;
import edu.pe.cibertec.saucedemo.tasks.SortProducts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductStepDefinitions {

    @And("she sorts the products by {string}")
    public void sheSortsTheProductsBy(String sortOption){
        OnStage.theActorInTheSpotlight().attemptsTo(
                SortProducts.by(sortOption)
        );
    }

    @Then("the first product should have price {string}")
    public void theFirstProductShouldHavePrice(String price){
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductPrice.ofFirstItem(), equalTo(price))
        );
    }

    @And("the last product should have price {string}")
    public void theLastProductShouldHavePrice(String price){
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheProductPrice.ofLastItem(), equalTo(price))
        );
    }


}
