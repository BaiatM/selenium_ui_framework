package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseValidationSteps {
    @Then("verify user created new account in the database with the {string}")
    public void verifyUserCreatedNewAccountInTheDatabaseWithThe(String str) throws SQLException {
        ResultSet rs = DatabaseUtils.executeQuery("SELECT name FROM digitalbank.account where name = '"+str+"';");
        rs.next();
        Assert.assertEquals("The names are not matching",rs.getString("name"),str);
    }


    @Then("clean up the database {string}")
    public void cleanUpTheDatabase(String name) {
        DatabaseUtils.deleteQuery("DELETE FROM account WHERE name='"+name+"';");
    }
}
