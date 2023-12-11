import java.util.*;
public class Solution
{
  private String u_name;
  private String u_pwd;
  boolean flag=false;
  boolean exam=false;
  private int[] ca;
  private int[] ua;

  public  Solution(String u_name,String u_pwd)
  {
    int n=5;
    this.u_name=u_name;
    this.u_pwd=u_pwd;
    this.ua=new int[n];
    this.ca=new int[] {1,3,2,4,1};
  }

//profile update
  public void update()
  {
    System.out.print("Enter username:");
    Scanner sc=new Scanner(System.in);
    String name=sc.nextLine();
    System.out.print("Enter new password:");
    String pwd=sc.nextLine();
    if(pwd.equals(u_pwd))
    {
      System.out.println("Alter! Please enter a new password.");
    }
    else
    {
      System.out.println("Profile updated.\n Start your exam.");
      flag=true;
    }
  }

//exam login
  public void exam()
  {
    if(flag==true)
    {
      int timer=5,marks=0;
      int n=5;
      Scanner sc=new Scanner(System.in);
      for(int i=0;i<n;i++)
      {
        System.out.println();
        System.out.println("Timer:"+timer+"mins left");
        System.out.println("Q"+(i+1) +":");
        System.out.println("Options:" + "1." +"\u0020"+ "2."+"\u0020" + "3."+"\u0020" + "4.");
        int op=sc.nextInt();
        ua[i]=op;
        timer=timer-1;
      }
      for(int i=0;i<n;i++)
      {
        if(ua[i]==ca[i])
        {
          marks++;
        }
      }
      System.out.println("Your Total Score :"+ marks);
      System.out.print("Please Logout.");
      System.out.println();
      exam =true;
    }
    else
    {
      System.out.println("Update your profile properly.");
    }
  }

//exam logout
  public void logout()
  {
    if(exam)
    {
      System.out.println("Successfully LoggedOut.");
    }
    else
    {
      System.out.println("Please finish your exam.");
    }
  }
  
  public  static void main(String[] args)
  {
    System.out.println("\nOnline Examination System");
    Scanner sc=new Scanner(System.in);
    //login details
    System.out.print("Enter your name:");
    String name=sc.nextLine();
    System.out.print("Enter your password:");
    String pwd=sc.nextLine();
    Solution sol=new Solution(name,pwd);
    System.out.println("Login Successful!!\n Please update your profile.");

    while(true)
    {
      System.out.println();
      System.out.println("Select:");
      System.out.println("1.Update Profile");
      System.out.println("2.Start the Test");//mention timing and submit in this method
      System.out.println("3.Logout");
      System.out.println("4.Exit");
      System.out.println("Enter your choice:");
      int ch = sc.nextInt();
      switch(ch)
      {
        case 1: sol.update();
        break;
        case 2: sol.exam();
        break;
        case 3: sol.logout();
        break;
        case 4:System.exit(0);
        break;

        default:
          System.out.println("Invalid Input.");
      }
    }
  }
}