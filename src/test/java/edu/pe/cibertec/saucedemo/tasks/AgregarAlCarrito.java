package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AgregarAlCarrito {
    public static Performable product(String nombreProduct){
        return Task.where("{0} agrega el producto " + nombreProduct,
                Click.on(Target.the("add button")
                        .locatedBy(CarritoPage.actionButton("add-to-cart", nombreProduct)))
        );
    }
}
