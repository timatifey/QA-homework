package test_cases;

import org.junit.jupiter.api.Test;
import pages.GroupPage;
import pages.GroupsPage;
import utils.Bots;
import utils.Navigate;

public class MainTest extends BaseTest {

    @Test
    public void groupsCounterIncrease() {
        GroupsPage groupsPage = Navigate.toGroupsPageBy(Bots.techoBot1);
        int initCount = groupsPage.getGroupsCounterValue();
        groupsPage
                .joinGroup()
                .reload()
                .checkGroupsCounterValue(initCount + 1);
    }

    @Test
    public void groupJoinLeave() {
        GroupsPage groupsPage = Navigate.toGroupsPageBy(Bots.techoBot1);
        int initCount = groupsPage.getGroupsCounterValue();
        groupsPage
                .joinGroup()
                .reload();

        GroupPage someGroupPage = groupsPage.openSomeGroup();
        someGroupPage.leaveGroup();

        groupsPage = Navigate.toBotProfilePageAndGroups(Bots.techoBot1);
        groupsPage.checkGroupsCounterValue(initCount);
    }

}
