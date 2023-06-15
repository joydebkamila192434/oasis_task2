import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessingGame methodToggle = new NumberGuessingGame();
        methodToggle.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodToggle = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("What action would you like to do from the above actions? ");
            int optionList = input.nextInt();
            switch (optionList) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the numbers to be? ");
                    int numLength = input.nextInt();
                    int unknownNumber = methodToggle.unknownNumber(numLength);
                    methodToggle.guessNumber(unknownNumber);
                    break;
                case 2:
                    methodToggle.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game,hope you enjoyed this.");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }
    public int unknownNumber(int numLength) {
        Random random = new Random();
        int unknownNumber = random.nextInt(numLength) + 1;
        return unknownNumber;
    }
    public void guessNumber(int unknownNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > unknownNumber) {
                System.out.println("Lower");
            } else if (userGuess < unknownNumber) {
                System.out.println("Higher");
            }
        } while (unknownNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: " +"\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}