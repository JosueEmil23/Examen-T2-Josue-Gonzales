package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.interactions.SelectFromOptions;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SortProducts {

    public static Performable by (String sortOperation){
        return Task.where("{0} sorts products by '"+sortOperation+"' ",
                SelectFromOptions.byVisibleText(sortOperation)
                        .from(Target.the("").locatedBy(InventoryPage.ORDER_PRODUCT_SELECT))

        );
    }
}
