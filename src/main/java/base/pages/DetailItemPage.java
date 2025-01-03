package base.pages;

import base.config.PageTools;

import static com.codeborne.selenide.Condition.clickable;

public class DetailItemPage extends PageTools {
    private final String backToProductsButton = "back-to-products";
    private final String header = "//div[contains(@class, 'inventory_details_name')]";
    private final String description = "(//div[contains(@class, 'inventory_details_desc')])[2]";
    private final String price = "//div[@class='inventory_details_price']";

    public void clickBackToProductsButton() {
        shouldBe("id", clickable, backToProductsButton);
        click("id", backToProductsButton);
    }

    public Item getDetailedItem() {
        Item item = new Item();

        item.setName(getText("xpath", header));
        item.setDescription(getText("xpath", description));
        item.setPrice(getText("xpath", price));

        return item;
    }
}
