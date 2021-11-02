package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupsPage extends BasePage {

    private static final By GROUPS_COUNTER = By.xpath(".//span[contains(@class, 'portlet_h_count')]");
    private static final By GROUP_JOIN_BTN = By.xpath(".//a[contains(@data-l, 't,join')]");
    private static final By GROUP_OPEN = By.xpath(".//a[contains(@data-l, 't,visit')]");

    public GroupsPage() {
        super();
    }

    @Override
    protected void check() {
        $(GROUPS_COUNTER).shouldBe(Condition.visible);
        $(GROUP_JOIN_BTN).shouldBe(Condition.visible);
    }

    public GroupsPage joinGroup() {
        $(GROUP_JOIN_BTN).click();
        return this;
    }

    public GroupsPage reload() {
        refresh();
        return this;
    }

    public int getGroupsCounterValue() {
        return Integer.parseInt($(GROUPS_COUNTER).getText().replace(" ", ""));
    }

    public GroupsPage checkGroupsCounterValue(int expectedValue) {
        $(GROUPS_COUNTER).shouldBe(Condition.visible);
        assertThat($(GROUPS_COUNTER).text(), notNullValue());
        int currentValue = getGroupsCounterValue();
        assertThat(expectedValue, equalTo(currentValue));
        return this;
    }

    public GroupPage openSomeGroup() {
        $(GROUP_OPEN).shouldBe(Condition.visible);
        $(GROUP_OPEN).click();
        return new GroupPage();
    }
}
