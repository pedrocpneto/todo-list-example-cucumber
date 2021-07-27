package net.pcpinfo.todolistexemplo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        snippets = CAMELCASE,
        plugin = { "json:target/cucumber.json", "html:target/cucumber.html", "pretty" })
public class CucumberIntegrationTest {

}
