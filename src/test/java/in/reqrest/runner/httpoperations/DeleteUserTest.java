package in.reqrest.runner.httpoperations;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"in.reqrest.stepdefinition.httpoperations"},
        features = {"src/test/resources/features/deleteUser.feature"},
        publish = true
)
public class DeleteUserTest {
}
