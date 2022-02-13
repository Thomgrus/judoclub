package cloud.gruson.judoclub.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ServerApplicationTest {

	@Value("${spring.flyway.enabled}")
	boolean flywayMode;

	@Test
	void contextLoads() {
		Assertions.assertFalse(flywayMode);
	}

}
