package wang.liangchen.matrix.iam.authorization.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.framework.generator.DDDGenerator;

import javax.inject.Inject;

@SpringBootTest
public class CodeGenerator {
    @Inject
    private DDDGenerator DDDGenerator;

    @Test
    public void generate() {
        DDDGenerator.build();
    }
}
