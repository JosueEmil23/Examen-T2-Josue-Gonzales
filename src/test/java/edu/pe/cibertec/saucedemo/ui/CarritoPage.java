package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {


    public static final String SHOPPING_CART_BADGE = "[data-test='shopping-cart-badge']";
    public static final String ITEM_NAME = "[data-test='inventory-item-name']";
    public static final String CART_LINK = "[data-test='shopping-cart-link']";


    public static String actionButton(String action, String productName){
        String formattedName = productName.toLowerCase().replace(" ","-");
        return "[data-test='" + action + "-" + formattedName + "']";
    }
}
