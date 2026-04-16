package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class TheOrderSummary {
    public static Question<String> totalItem(){
        return Text.of(Target.the("total item label").locatedBy(CheckoutPage.SUBTOTAL_LABEL));
    }
    public static  Question<String> confirmationMessage(){
        return Text.of(Target.the("confirmation header")
                .locatedBy(CheckoutPage.COMPLETE_HEADER));
    }

    public static Question<String> errorMessage(){
        return Text.of(Target.the("success message").locatedBy(CheckoutPage.ERROR_MESSAGE));
    }

    public static Question<Boolean> formVisibility(){
        return Visibility.of(Target.the("checkout container").locatedBy(CheckoutPage.CHECKOUT_CONTAINER));
    }



}
