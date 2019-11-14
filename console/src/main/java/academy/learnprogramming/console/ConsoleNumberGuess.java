package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {
    // == constants ==

    // ==fields==

    MessageGenerator messageGenerator;
    private Game game;

    public ConsoleNumberGuess(@Autowired Game game, @Autowired MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //==events==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start()-->Container ready for use");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();
            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again , y/n ?");
                String playAgain = scanner.nextLine().trim();
                if (!playAgain.equalsIgnoreCase("y")) {
                    System.out.println("Thank you for playing .GoodBye.");
                    break;
                }
                game.reset();
            }

        }
    }
}
