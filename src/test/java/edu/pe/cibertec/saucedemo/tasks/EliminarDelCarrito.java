package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class EliminarDelCarrito {

    public static Performable product(String nombreProducto){
        return Task.where("{0} delete the product" + nombreProducto,
                Click.on(Target.the("delete Button")
                        .locatedBy(CarritoPage.actionButton("remove", nombreProducto)))
        );
    }
}
