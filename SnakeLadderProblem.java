import java.util.concurrent.ThreadLocalRandom;

/**
 * The SnakeLadderProblem implements an application that
 * displays initial position of player 1 in the game
 * Rolls a dice and gives random number between 1 to 6
 * @author Krunal Lad
 * @version 1.1
 * @since 10-06-2021
 */
public class SnakeLadderProblem {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!!!");
        //Player position at start
        int startPosition= 0;
        // dice value is between 1 and 6 
        int MIN_DICE_VALUE = 1;
        int MAX_DICE_VALUE = 6;
        //nextInt is exclusive of top value so added plus 1
        int randomNum = ThreadLocalRandom.current().nextInt(MIN_DICE_VALUE, MAX_DICE_VALUE + 1);
        System.out.println("The initial position of a player is : "+startPosition);
        System.out.println("After rolling a die position of player is at : "+randomNum);

    }
}

