package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    @DisplayName("Check price of product with delivery cost in checkout page")
    void verifyProductPriceWithDelivery() {
        String productUrl = "https://haushalt.check24.de/standmixer/1a5t11ey8ve0h-wmf-kult-pro-multifunktionsmixer-30000-u-min-1200-watt-6-geschwindigkeiten-3-autoprogramme-2-mixbehaelter-2-to-go-mixflaschen-kreuzklingen-fuer-smoothies-flachklingen-zum-zerkleinern.html";
        driver.get(productUrl);
        ProductPage productPage = new ProductPage(driver);
        productPage
                .acceptCookies()
                .clickToggle();
        String shopPriceWithDelivery = productPage.getProductPrice();

        productPage.addProductToCart();
        String priceInShoppingCart = productPage.getProductPriceOnCheckoutPage();

        Assertions.assertEquals(shopPriceWithDelivery, priceInShoppingCart);

    }


}
