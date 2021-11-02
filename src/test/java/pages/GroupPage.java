package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupPage extends BasePage {

    private static final By GROUP_LEAVE_BTN = By.xpath(".//a[contains(@class, 'dropdown_i')]");
    private static final By GROUP_MENU_BTN = By.xpath(".//span[contains(@class, 'dropdown_ac button-pro __with-arrow __arrow-svg __sec __wide')]");

    public GroupPage() {
        super();
    }

    @Override
    protected void check() {
        $(GROUP_MENU_BTN).shouldBe(Condition.visible);
    }

    public GroupPage leaveGroup() {
        $(GROUP_MENU_BTN).shouldBe(Condition.visible);
        $(GROUP_MENU_BTN).click();
        $(GROUP_LEAVE_BTN).shouldBe(Condition.visible);
        $(GROUP_LEAVE_BTN).click();
        return this;
    }

}
