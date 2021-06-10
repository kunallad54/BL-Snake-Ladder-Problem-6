import java.util.concurrent.ThreadLocalRandom;

/**
 * The SnakeLadderProblem implements an application that
 * displays initial position of player 1 in the game
 * Rolls a dice and gives random number between 1 to 6
 * Then player checks for options whether its no play,ladder or snake and perform actions
 * Then dice is rolled till winning position 100 is reached
 * Also Ensures that winning position not exceeds greater than 100
 * @author Krunal Lad
 * @version 1.4
 * @since 10-06-2021
 */
public class SnakeLadderProblem {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!!!");
        //Player position at start
        int START_POSITION= 0;
        int WINNING_POSITION = 100;
        int currentPosition = 0;
        int NO_PLAY = 0;
        int LADDER = 1;
        int SNAKE = 2;
        System.out.println("The initial position of a player is : "+START_POSITION);
        //Just a random loop to get the work flow
        while(currentPosition <= WINNING_POSITION){
            int diceNumber = randomDiceNumber();
            int nextMove = NextMove();
            System.out.println("Random dice number generated is : "+diceNumber);
            //The Player Checks for option whether its no play,ladder or snake and perform actions
            if(nextMove == NO_PLAY){
                System.out.println("Sorry you can not Play,You are at the Same Position");
            }else if(nextMove == LADDER){
                System.out.println("CONGRATS!!! You have got the ladder");
                currentPosition = currentPosition + diceNumber;
            }else if (nextMove ==  SNAKE){
                System.out.println("OOPS!!! ITS a SNAKE");
                currentPosition = currentPosition - diceNumber;
                if(currentPosition <0) {
                    currentPosition = 0;
                }
            }
            //printed in the loop to get count each time
            if (currentPosition > WINNING_POSITION) {
                currentPosition = currentPosition - diceNumber;
            }else if (currentPosition == WINNING_POSITION){
                System.out.println("The current position of a player is: "+currentPosition);
                break;
            }
            System.out.println("The current position of a player is: "+currentPosition);

        }

    }
    static int randomDiceNumber(){
        // dice value is between 1 and 6
        int MIN_DICE_VALUE = 1;
        int MAX_DICE_VALUE = 6;
        //nextInt is exclusive of top value so added plus 1
        return ThreadLocalRandom.current().nextInt(MIN_DICE_VALUE, MAX_DICE_VALUE + 1);
    }
    static int NextMove(){
        //generating random numbers 0,1,2 for no play,ladder,snake
        return (int) (Math.floor(Math.random() * 10)) % 3;
    }
}
