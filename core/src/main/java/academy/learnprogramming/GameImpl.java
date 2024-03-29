package academy.learnprogramming;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
@Getter
public class GameImpl implements Game {

    // ==constants==


    // ==Fields==

    private final NumberGenerator numberGenerator;

    private final int guessCount;


    private int number;
    @Setter
    private int guess;
    private int smallest;
    private int biggest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    //==constructor==
    @Autowired
    public GameImpl(@GuessCount int guessCount, NumberGenerator numberGenerator) {
        this.guessCount = guessCount;
        this.numberGenerator = numberGenerator;
    }

    //==Init==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;

        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);

    }

    @PreDestroy
    public void preDestroy() {
        log.info("In Game predestroy");
    }


    // ==public methods==
//    public void setNumberGenerator(NumberGenerator numberGenerator){
//        this.numberGenerator=numberGenerator;
//    }


    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }

        }
        remainingGuesses--;
    }


    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private method ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
