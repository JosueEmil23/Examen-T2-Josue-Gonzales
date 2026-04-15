package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.questions.Text;


import java.util.List;

public class TheProductsOnCart {
    public static Question<List<String>> names(){
        return Text.ofEach(CarritoPage.ITEM_NAME);
    }
}
