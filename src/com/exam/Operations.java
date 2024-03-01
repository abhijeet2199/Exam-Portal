package com.exam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.InputMismatchException;

class User {
  private int id;
  public int pass;
  private String name;

  User(String name, int id,int pass) {
      this.name = name;
      this.id = id;
      this.pass = pass;
  }

  public int getId() {
      return this.id;
  }
  User() {}
  public int getPass() {
      return this.pass;
  }

  public String getName() {
      return this.name;
  }

  public String toString() {
      return this.name;
  }

  public void setName (String name){
      this.name =  name;
  }
  public void setPass(int pass){
      this.pass =  pass;
  } 
}


public class Operations {

    //add user
    ArrayList<User> users = new ArrayList<User>();
    private User currentUser = null; 
    public static int score=0;
    public static int correct=0;
    public static int wrong=0;
    Scanner sc = new Scanner(System.in);
    User u = new User();

    char correctAnswers[]={'b','d','c','b','c','d','c','b','b','c'};
    char userAnswers[]=new char[10];
    
    public void start() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your Choice: ");
        System.out.println("1.For SignUp  2.For Login  3.To Exit");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            signup();
        }
        else if (choice == 2) {
        	System.out.println("----- REDIRECTING TO LOGIN PAGE PLEASE WAIT -----\n");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.err.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^ LOGIN PAGE ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!\n");
        	login();
        } 
        else if(choice == 3){
        	System.out.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^ THANKYOU ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!");
            System.out.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^! EXITED ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!");
            System.exit(0);
        }
        else {
            System.out.println("-*-.-*-.-*-.-*-.-*-.-*-.-* INVALID CHOICE ! *-.-*-.-*-.-*-.-*-.-*-.-*-.-*");
            start();
        }
    }
    
    public void signup() {
        Random rand = new Random();
        System.out.println("----- REDIRECTING TO SIGNUP PAGE PLEASE WAIT -----\n");
 
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.err.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^ SIGNUP PAGE ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!\n");
        System.out.println("Enter your name : ");
        String name = sc.nextLine();
        
        System.out.println("Enter your password in numbers : ");
        int pass = sc.nextInt();    

        int id = rand.nextInt(1000); 
        User u1 = new User(name, id, pass);
        users.add(u1);

        System.err.println("\n^!^!^!^!^!^!^!^!^!^!^!^ REGISTRATION SUCCESSFULL ^!^!^!^!^!^!^!^!^!^!^!\n");
        System.out.println("YOUR LOGIN ID IS : " + id);
        System.out.println("KEEP LOGIN ID FOR FUTURE USE\n");
        currentUser = u1; // Set the current user
        System.out.println("Enter Your Choice: 1.Update your profile  2.Dashboard");
        int choice=sc.nextInt();
        if (choice == 1) {
        	System.out.println("------ REDIRECTING TO UPDATE PROFILE PAGE PLEASE WAIT ------");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.err.println("\n^!^!^!^!^!^!^!^!^!^!^!^!^!^! UPDATE PROFILE ^!^!^!^!^!^!^!^!^!^!^!^!^!^!\n");
        	update();
        }
        else if (choice == 2) {
        	dashboard();
        } 
    }
    
    public void login() {

        System.out.print("Enter your 3 digit Id : ");
        int id = sc.nextInt();
        System.out.print("Enter your 5 digit Password : ");
        int pass = sc.nextInt();
        
        for (User i : users) {
            if (i.getId() == id && i.getPass() == pass) { 
            	currentUser = i; // Set the current user
                System.out.println("\n---- LOGIN SUCCESSFULL ----\n");
                System.out.println("^!^!^!^!^!^!^!^!^!^!^!^ WELCOME "+i.getName()+" ^!^!^!^!^!^!^!^!^!^!^!^!\n");
                System.out.println("Enter Your Choice 1.Update your profile 2.Dashboard");
                int choice=sc.nextInt();
                if (choice == 1) {
                	System.out.println("------ REDIRECTING TO UPDATE PROFILE PAGE PLEASE WAIT ------");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.err.println("\n^!^!^!^!^!^!^!^!^!^!^!^!^!^! UPDATE PROFILE ^!^!^!^!^!^!^!^!^!^!^!^!^!^!\n");
                	update();
                }
                else if (choice == 2) {
                	dashboard();
                } 
            }else if(i.getId()!=id && i.getPass()!=pass){
            	System.err.println("INVALID ID OR PASSWORD ! TRY AGAIN");
            	login();
            }
        }
    }
    
    public void update(){
    	
    	if (currentUser == null) {
            System.out.println("Please log in first to update your profile.");
            return;
        }

        System.out.println("\nEnter: 1.To update your name 2.To update password 3.Dashboard 4.Logout");
        int choice = sc.nextInt();
        
        if(choice == 1 ){
            System.out.print("Enter your new name : ");
            sc.nextLine();
            String name = sc.nextLine();
            u.setName(name);
            System.out.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^! NAME CHANGED SUCCESSFULLY ^!^!^!^!^!^!^!^!^!^!^!^!^!^!");
            update();
        }
        else if(choice == 2){
            System.out.print("Enter your new 5 digit password : ");
            int newpass = sc.nextInt();
            u.setPass(newpass);
            System.out.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^ PASSWORD CHANGED SUCCESFULLY ^!^!^!^!^!^!^!^!^!^!^!^!^!");
            update();
        }
        else if(choice==3) {
        	dashboard();
        }
        else if(choice==4) {
        	System.out.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^ THANKYOU VISIT AGAIN ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!");
        	System.exit(0);
        }
        else{
            System.out.println("-*-.-*-.-*-.-*-.-*-.-*-.-*-.-* INVALID CHOICE ! -*-.-*-.-*-.-*-.-*-.-*-.-*-.-*");
        }
       
    }
    
    
    public void dashboard() {

            System.err.println("\n^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^ DASHBOARD ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!\n");
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter Your Choice: ");
            System.out.println("1.Take test  2.To update your profile  3.To Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
            	System.out.println("------ REDIRECTING TO THE TEST PLEASE WAIT ------");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            	examPortal();
            }
            else if (choice == 2) {
                update();
            } 
            else if(choice == 3){
            	System.out.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^ THANKYOU VISIT AGAIN ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!");
            	System.exit(0);
            }
            else {
                System.out.println("-*-.-*-.-*-.-*-.-*-.-*-.-*-.-*-* INVALID CHOICE ! *-.-*-.-*-.-*-.-*-.-*-.-*-.-*-.-*");
            }
            sc.close(); 
    }

    public void examPortal(){
        int i =0;

        System.err.println("\n^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^ EXAM PORTAL ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^\n");
        System.out.println();
        System.out.println("---NOTE: Following test is time bounded");
        System.out.println("---NOTE: Test will be autosubmitted when time is completed !");
        System.out.println("---Time Started....\n");
        System.out.println("*-.-*-.-*-.-*-.-*-.-*-.-*-.-* -*-.-*.-*-.-*-.-*-.-*-.-* -*-.-*-.-*-.-*-.-*-.-*-.-*-.*\n");
        System.err.println("---TEST NAME: JAVA FUNDAMENTALS                                        TOTAL MARKS: 20\n");
        clock();
        try{ 
            String fileName= "E:\\Eclipse Practice Projects\\Intership Projects\\Online Examination Portal\\EXAM_PORTAL\\Questions.txt";
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            Scanner in = new Scanner(System.in);
           
                while(sc.hasNextLine()){
                    try{
                    String line = sc.nextLine();

                    if(line.isEmpty()){
                        System.err.print("Ans : ");
                        char userAnswer = in.next().charAt(0);

                        System.out.println();

                        if(userAnswer >= 'a' && userAnswer<='d'){
                        userAnswers[i]=userAnswer;
                        i++;
                        
                        }
                        else{
                            System.out.println("-*-.-*-.-*-.-*-.-*-.-*-.-*-.-* INVALID CHOICE TRY AGAIN !-*-.-*-.-*-.-*-.-*-.-*-.-*-.-* ");
                            if(line.isEmpty()){
                            System.err.print("Ans : ");
                            userAnswer = in.next().charAt(0);
                            if(userAnswer >= 'a' && userAnswer<='d'){
                            userAnswers[i]=userAnswer;
                            i++;
                        }}
                        }
                    }
                   else{
                        System.out.println(line);
                    }
                    }catch(InputMismatchException e){
                        System.out.println("-*-.-*-.-*-.-*-.-*-.-*-.-* INVALID INPUT PLEASE RESTART ! *-.-*-.-*-.-*-.-*-.-*-.-* ");
                    }
                }

                Anscheck();

        }catch(FileNotFoundException e){
            System.err.println("-*-.-*-.-*-.-*-.-*-.-*-.-*-.-*  FILE DOES NOT EXISTS ! -*-.-*-.-*-.-*-.-*-.-*-.-*-.-* ");
            dashboard();
        }
    }
    

    public void Anscheck(){
       System.out.println("----EVALUATING YOUR TEST----");
       int i=0,j=0;

       while(i<correctAnswers.length){
        if(userAnswers[i]==correctAnswers[j]){
            score+=2;
            correct++;
            i++;
            j++;
        }
        else if(userAnswers[i]!=correctAnswers[j]){
            wrong++;
            i++;
            j++;
        }
       }try {
            TimeUnit.SECONDS.sleep(2);
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
       System.err.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^SCORE CARD ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^\n");
       try {
           TimeUnit.SECONDS.sleep(2);
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

       if(score>=6) {
       	System.out.println("^!^!^!^!^!^!^!^!^!^!^!^!^ Congratualtions You Passed ^!^!^!^!^!^!^!^!^!^!^!^!^");
       	System.out.println("\nYOUR SCORE OUT OF 20 IS : "+score);
           System.out.println("WRONG ANSWERS : "+wrong);
           System.out.println("CORRECT ANSWERS : "+correct);
           
           correct=0; //resetting the score for next user
           score=0;
           wrong=0;
           logout();
       }else {
       	System.err.println("^!^!^!^!^!^!^!^!^!^!^!^!^!^!^Sorry You Failed ^!^!^!^!^!^!^!^!^!^!^!^!^!^!^!^");
       	System.out.println("\n---YOUR SCORE OUT OF 20 IS : "+score);
           System.out.println("---WRONG ANSWERS : "+wrong);
           System.out.println("---CORRECT ANSWERS : "+correct);
    
           correct=0;  
           score=0;
           wrong=0;
           logout();
       }
    }   
    
    public void logout(){
        char  choice =' ';
        try{
        System.out.println("\n---DO YOU WANT TO LOGOUT ?"); 
        System.out.println("---ENTER 'y' FOR YES &  'n' FOR NO");
        
        choice = sc.next().charAt(0);
        if(choice == 'y'){
            System.out.println("\n^!^!^!^!^!^!^!^!^!^!^!^!^ YOUR ID IS LOGGED OUT ^!^!^!^!^!^!^!^!^!^!^!^!^! ");
            System.out.println("^!^!^!^!^!^!^!^! Keep Studying and UpSkilling Yourself ^!^!^!^!^!^!^!^!^!^!^!\n ");
            System.err.println("●-●-●-●-●-●-●-●-●-●-●-●-●-●-●-●--●-●-●-●--●-●-●-●-●-●-●-●-●-●-●-●-●-●-●-●-●-\n");
            System.exit(0);        
        }
        else if(choice =='n'){
            dashboard();
        }
        else{
        	System.out.println("-*-.-*-.-*-.-*-.-*-.-* INVALID CHOICE TRY AGAIN ! *-.-*-.-*-.-*-.-*-.-* ");
            logout();
        }
    }   catch(InputMismatchException e){
    	System.out.println("-*-.-*-.-*-.-*-.-*-.-*-.-*-.-* INVALID INPUT !-*-.-*-.-*-.-*-.-*-.-*-.-*-.-* ");
        logout();
    }
    }
 
  
    public void clock(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                System.err.println("-*-.-*-.-*-.-*-.-*-.-* TIME IS UP ! AUTOSUBMITTING *-.-*-.-*-.-*-.-*-.-*");
                try{
                    TimeUnit.SECONDS.sleep(2);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                Anscheck();
            }
        };
        
        timer.schedule(task,300000);
       
    }

}