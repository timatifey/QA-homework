package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {

    private static final By TO_GROUP_BUTTON = By.xpath(".//a[contains(@hrefattrs, 'st.cmd=userAltGroup&st._aid=NavMenu_UserProfile_AltGroups')]");

    public ProfilePage() {
        super();
    }

    @Override
    protected void check() {
        $(TO_GROUP_BUTTON).shouldBe(Condition.visible);
    }


    public GroupsPage openGroupsPage() {
        $(TO_GROUP_BUTTON).click();
        return new GroupsPage();
    }

}
