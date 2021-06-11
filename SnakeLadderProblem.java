import java.util.concurrent.ThreadLocalRandom;

/**
 * The SnakeLadderProblem implements an application that
 * displays initial position of player 1 in the game
 * Rolls a dice and gives random number between 1 to 6
 * Then player checks for options whether its no play,ladder or snake and perform actions
 * Then dice is rolled till winning position 100 is reached
 * Also Ensures that winning position not exceeds greater than 100
 * Reports the total dice count and position of player each time it rolls a dice
 * Finally Displays the winner out of two players
 *
 *
 * @author Krunal Lad
 * @version 1.5
 * @since 10-06-2021
 */
public class SnakeLadderProblem {

    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;

    public static void main(String[] args) {

        System.out.println("Welcome to Snake and Ladder Game!!!");
        //Player position at start and winning position declared
        int start_Position = 0;
        int WINNING_POSITION = 100;

        //to stored to the number of times dice rolled by both players individually
        int totalDiceCountOfPlayer1 = 0;
        int totalDiceCountOfPlayer2 = 0;

        //to get the current position of the player in the game
        int currentPositionOfPlayer1 = 0;
        int currentPositionOfPlayer2 = 0;

        while (start_Position <= WINNING_POSITION){

            System.out.println("Player 1 is rolling the dice");

            //calling roll dice method to get the next move of the player 1
            int currentDiceCountOfPlayer1 = rollDice(start_Position, WINNING_POSITION);

            //Updating the position of player and incrementing count of dice number rolled by 1
            currentPositionOfPlayer1 += currentDiceCountOfPlayer1;
            totalDiceCountOfPlayer1++;

            if(currentPositionOfPlayer1 >= WINNING_POSITION){

                if(currentPositionOfPlayer1 > WINNING_POSITION)
                    currentPositionOfPlayer1 -= currentDiceCountOfPlayer1;

                else if (currentPositionOfPlayer1 == WINNING_POSITION){

                    System.out.println("Player 1 WON THE GAME !!!! as he reached "+currentPositionOfPlayer1+" position");
                    System.out.println("The total number of times Player 1 rolled the dice is : "+totalDiceCountOfPlayer1);
                    break;
                }
            }

            System.out.println("The current position of PLAYER 1 is : "+currentPositionOfPlayer1);
            System.out.println();

            //Player 2 will have a turn to roll the dice
            System.out.println("Player 2 is rolling the dice");

            //calling roll dice method to get the next move of the player 2
            int currentDiceNumberOfPlayer2 = rollDice(start_Position, WINNING_POSITION);

            //Updating position of the player and incrementing the count of dice roll by 1
            currentPositionOfPlayer2 += currentDiceNumberOfPlayer2;
            totalDiceCountOfPlayer2++;

            if(currentPositionOfPlayer2 >= WINNING_POSITION){

                if(currentPositionOfPlayer2 > WINNING_POSITION)
                    currentPositionOfPlayer2 -= currentDiceNumberOfPlayer2;

                else if (currentPositionOfPlayer2 == WINNING_POSITION){
                    System.out.println("Player 2 WON THE GAME !!!! as he reached "+currentPositionOfPlayer2+" position");
                    System.out.println("The total number of times Player 2 rolled the dice is : "+totalDiceCountOfPlayer2);
                    break;
                }
            }

            System.out.println("The current position of Player 2 is : "+currentPositionOfPlayer2);
            System.out.println();

        }

    }

    private static int rollDice (int start_Position,int WINNING_POSITION){

        //getting random dice number from randDiceNumber() method and
        // getting option of no play,ladder or snake from NextMove() method
        int diceNumber = randomDiceNumber();
        int nextStep = nextMove();

        switch (nextStep) {

            case NO_PLAY -> System.out.println("Sorry its NO PLAY,You are at the same position");

            case LADDER -> {
                System.out.println("Congrats!!! Its a ladder,the player position moves ahead by " + diceNumber + " position");
                start_Position += diceNumber;
                rollDice(start_Position, WINNING_POSITION);
            }

            case SNAKE -> {
                System.out.println("OOPS!!! Its a Snake,the player position move behind by " + diceNumber + " position");
                start_Position -= diceNumber;
            }

            default -> throw new IllegalStateException("Unexpected value: " + nextStep);

        }

        if(start_Position<0)
            start_Position =0;

        return start_Position;

    }

    static int randomDiceNumber(){

        // dice value is between 1 and 6
        int MIN_DICE_VALUE = 1;
        int MAX_DICE_VALUE = 6;

        //nextInt is exclusive of top value so added plus 1
        return ThreadLocalRandom.current().nextInt(MIN_DICE_VALUE, MAX_DICE_VALUE + 1);

    }

    static int nextMove(){

        //generating random numbers 0,1,2 for no play,ladder,snake
        return (int) (Math.floor(Math.random() * 10)) % 3;

    }

}
