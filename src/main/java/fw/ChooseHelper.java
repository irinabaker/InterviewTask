package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseHelper extends BaseHelper{
    public ChooseHelper(WebDriver driver) {
        super(driver);
    }

    public void chooseCategoryType(String type) {
        click(By.cssSelector(".b-visualnav__tile:nth-child(" + type + ")"));
    }

    public void chooseDepartment(String department) {
        click(By.xpath("//a[text()='" + department + "']"));
    }
}
