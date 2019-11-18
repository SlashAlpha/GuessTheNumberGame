package academy.learnprogramming.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DecoupleLogicSetup {
    // == fields ==
    private final SpringResourceTemplateResolver templateResolver;

    //== constructor==
    public DecoupleLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    // == init section==
    @PostConstruct
    public void init() {
        templateResolver.setUseDecoupledLogic(true);
        log.info("Decouple Template logic set");
    }
}
