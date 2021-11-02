package utils;

import pages.FeedPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class Navigate {

    public static FeedPage toFeedPageBy(Bot bot) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLoginAndGetFeedPage(bot.username, bot.password);
    }

    public static ProfilePage toProfilePageBy(Bot bot) {
        toFeedPageBy(bot);
        open(bot.profileUrl);
        return new ProfilePage();
    }

    public static GroupsPage toGroupsPageBy(Bot bot) {
        ProfilePage profilePage = toProfilePageBy(bot);
        return profilePage.openGroupsPage();
    }

    public static GroupsPage toBotProfilePageAndGroups(Bot bot) {
        open(bot.profileUrl);
        return new ProfilePage().openGroupsPage();
    }
}
