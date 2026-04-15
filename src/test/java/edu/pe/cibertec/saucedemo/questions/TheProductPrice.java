package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class TheProductPrice {

    public static Question<String> ofFirstItem(){
        return Text.of(Target.the("First product price")
                .locatedBy(InventoryPage.FIRST_ITEM_PRICE));

    }

    public static Question<String> ofLastItem(){
        return Text.of(Target.the("Last product price")
                .locatedBy(InventoryPage.LAST_ITEM_PRICE));

    }
}
