package edu.pe.cibertec.saucedemo.questions;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import edu.pe.cibertec.saucedemo.ui.ProductDetailPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.questions.Visibility;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.Target;



public class TheProductDetail {

    public static Question<String> name(){
        return Text.of(Target.the("Product name")
                .locatedBy(ProductDetailPage.PRODUCT_NAME));

    }

    public static Question<String> price(){
        return Text.of(Target.the("Product price")
                .locatedBy(ProductDetailPage.PRODUCT_PRICE));

    }

    public static Question<Boolean> addToCartButtonIsVisible(){
        return Visibility.of(Target.the("Add to Cart Button")
                .locatedBy(ProductDetailPage.ADD_TO_CART_BUTTON));
    }


}
