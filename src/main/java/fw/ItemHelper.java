package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public String getFirstItemName(String first) {
        return driver.findElement(By.cssSelector(".s-item:nth-child(" + first + ") .s-item__title"))
                .getText();
    }

    public void enterSearchField(String secondItem) {
        type(By.id("gh-ac"), secondItem);
        click(By.id("gh-btn"));
    }

    public String getSecondItemName(String second) {
        return driver.findElement(By.xpath("//*[@class='b-visualnav__grid']//a[" + second + "]"))
                .getText();
    }

    public void selectItem(String item) {
        click(By.cssSelector(".b-visualnav__tile:nth-child(" + item + ")"));
    }
}
