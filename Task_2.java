import java.util.*;

public class Guess_no
{
  private static final int min=1;
  private static final int max=100;
  private static final int max_attempts=10;
  private static final int rounds=2;

  public static void main(String[] args)
  {
    Random rand=new Random();
    Scanner sc=new Scanner(System.in);
    int tot_score=0;

    System.out.println("Welcome to the Number Guessing Game");
    System.out.println("Total Number Of Rounds : 2");
    System.out.println("Total Number of attempts in each round: 10");

    for(int i=1;i<=rounds;i++)
    {
        int no=rand.nextInt(max)+min;
        int attempts=0;

        System.out.printf("Round : %d.\nGuess the number between %d and %d.\n", i,min,max);
       
       // System.out.printf("Chance: %d/%d\n",attempts,max_attempts);

        while(attempts<max_attempts)
        {
          System.out.println("Enter your number: ");
          int guess=sc.nextInt();
           attempts=attempts+1;

          if(guess==no)
          {
            int score=max_attempts-attempts;
            tot_score=tot_score+score;
            System.out.printf("Hurray! Guessed the Number successully.\n Attempts=%d.  Round Score=%d. \n",attempts, score);
            break;
          }

          else if(guess > no)
          {
            System.out.printf("The number is less than %d.\nAttempts left:%d.\n",guess,max_attempts-attempts);
          }

          else
          {
              System.out.printf("The number is greater than %d.\nAttempts left:%d.\n",guess,max_attempts-attempts);
          }
        }
        if(attempts==max_attempts)
        {
          System.out.printf("\n Round: %d\n",i);
          System.out.println("Attempts=0");
          System.out.printf("The actual number is :: %d \n",no);
        }
    }
    System.out.printf("Game Over .\n Total Score : %d\n",tot_score);
    sc.close();
  }
}