package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {


    private final Game game;
    //  private int guessCount=10;

    // == contructor==
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // ==init==
    @PostConstruct
    void logGame() {
        log.debug(game.toString());
    }

    @Override
    public String getMainMessage() {
        return "Number is between "
                + game.getSmallest()
                + " and "
                + game.getBiggest()
                + ". Can you guess it ?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it ! The number was "
                    + game.getNumber();
        } else if (game.isGameLost()) {
            return "You lost. The number was "
                    + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "invalid number range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess ?";
        } else {
            String direction = "Lower";

            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + " ! " + "You have " + game.getRemainingGuesses() + " guesses left";
        }


    }
}
