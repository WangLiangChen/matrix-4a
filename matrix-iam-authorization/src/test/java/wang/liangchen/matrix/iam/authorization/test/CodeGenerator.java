package wang.liangchen.matrix.iam.authorization.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.DomainGenerator;

import javax.inject.Inject;

@SpringBootTest
public class CodeGenerator {
    @Inject
    private DomainGenerator domainGenerator;

    @Test
    public void generate() {
        domainGenerator.build();
    }
}
