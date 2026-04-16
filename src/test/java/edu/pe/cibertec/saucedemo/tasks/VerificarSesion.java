package edu.pe.cibertec.saucedemo.tasks;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class VerificarSesion {

    public static Performable withTitle(String titulo){
        return Task.where("{0} verifica que el titulo sea " +titulo,
                actor -> {
            var page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();

                    PlaywrightAssertions.assertThat(page.locator(".title")).isVisible();
                    PlaywrightAssertions.assertThat(page.locator(".title")).containsText(titulo);


                });
    }
}
