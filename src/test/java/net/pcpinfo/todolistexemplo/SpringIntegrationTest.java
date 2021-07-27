package net.pcpinfo.todolistexemplo;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
@RequiredArgsConstructor
public abstract class SpringIntegrationTest {
}
