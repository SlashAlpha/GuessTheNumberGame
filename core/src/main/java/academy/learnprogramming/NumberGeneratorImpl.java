package academy.learnprogramming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("numberGenerator")

@Component

public class NumberGeneratorImpl implements NumberGenerator {


    //fields section
    private final Random random = new Random();
    //    @Autowired
//    @MaxNumber
    @Getter
    private final int maxNumber;

    //    @Autowired
//    @MinNumber
    @Getter
    private final int minNumber;

    // ==constructor==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //public methods
    @Override
    public int next() {
        return minNumber + random.nextInt(maxNumber - minNumber);
    }


}
