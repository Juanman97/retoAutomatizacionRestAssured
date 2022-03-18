package in.reqrest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"in.reqrest.stepdefinition"},
        features = {"src/test/resources/features/patchUserInfo.feature"},
        publish = true
)
public class PatchUserInfoTest {
}
