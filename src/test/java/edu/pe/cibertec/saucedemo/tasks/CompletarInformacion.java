package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class CompletarInformacion {
    public static Performable whitData(String nombre, String apellido, String zip){
        return Task.where("{0} complete your shipping information",
                Enter.theValue(nombre).into(Target.the("name").locatedBy(CheckoutPage.FIRST_NAME)),
                Enter.theValue(apellido).into(Target.the("apellido").locatedBy(CheckoutPage.LAST_NAME)),
                Enter.theValue(zip).into(Target.the("postal").locatedBy(CheckoutPage.POSTAL_CODE))
                );
    }


    //Nota: Profesor, el task de verificar detalle lo cambie por un question(TheOrderSummary)
    // ya q considere q era otra manera valida de hacerlo y en este caso podia resultar.

}
