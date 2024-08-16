import java.util.Random;
import java.util.Scanner;

class Game{
    int num, turn = 1;
    public static int input;

    public int userInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Attempt " +turn+ " :- ");
        input = (int)sc.nextDouble();
        return input;
    }

    Game(){
        Random rand = new Random();
        num = rand.nextInt(1,100);
        System.out.println("Computer Guess No. for testing - " +num+"\n");
    }

    public boolean isCorrect(){
        
        if(input == num){
            System.out.println("Yeah, you got the no. " +num+ " ---'YOU WON!'---");
            int score = 5;
            score = score-turn+1;
            System.out.println("\nYour Score :- "+score+"/5\n");
            return true;
        }
        else if(input < num){
            System.out.println("Miss this chance, your no. is too small...");
            if(turn == 5){
                System.out.println("Your all attempts are over!!\n");
                return true;
            }
            turn++;
            return false;
        }
        else{
            System.out.println("Miss this chance, your no. is too big...");
            if(turn == 5){
                System.out.println("!!Your all attempts are over!!\n");
                return true;
            }
            turn++;
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while(playAgain){
            System.out.println("Guess the no. matching by computer's no. ---\nYou have only 5 chance ---\n");
            Game g = new Game();

            boolean b = false;
            while(!b){
                g.userInput();
                if(input<=100){
                    b = g.isCorrect();
                }
                else{
                    System.out.println("Guess no. between 1 to 100...\nRetry...\n");
                    g.userInput();
                }
            }
            System.out.println("Press 1 - Play Again...\nPress 2 - For Exit!");
            System.out.print("choose :- ");
            int n = sc.nextInt();
    
            if(n == 2){
                System.out.println("\nExited!\n");
                playAgain = false;
            }
            else{
                System.out.println("\nRestart...\nPlay --->\n");
                playAgain = true;
            }
        }
    }
}