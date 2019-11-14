package academy.learnprogramming;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication
public class Main {


//    private static final String CONFIG_LOCATION ="beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create context (container)

        SpringApplication.run(Main.class, args);
        // get numberGenerator bean from context(container)
//        NumberGenerator numberGenerator
//                =context.getBean(NumberGenerator.class);
//
//
//        // call method next() to get a random number
//        int number=numberGenerator.next();
//
//        // log generated number
//        log.info("number = {}",number);
//
//        // get game bean from context(container)
//        Game game =context.getBean(Game.class);
//            log.debug(game.toString());
//
//        // get Message Generator from context(App config)
//        MessageGenerator messageGenerator=context.getBean(MessageGenerator.class);
//            String methodCall1=messageGenerator.getMainMessage();
//            String methodCall2=messageGenerator.getResultMessage();
//
//            log.info(methodCall1);
//            log.info(methodCall2);
        // call reset method
        //   game.reset();

        //close context


    }
}
