package com.exam;
public class Main {
    public static void main(String[] args) {
    	Operations o = new Operations();
    	
        User u1 = new User("Ram", 123, 12345);
        User u2 = new User("Shyam", 456, 54321);
        User u3 = new User("Raju", 789, 12345);
        User u4 = new User("Babu", 101, 67891);

        o.users.add(u1);
        o.users.add(u2);
        
        System.err.println("●-●-●-●-●-●-●-●-●-●-●-●-●-●- Welcome to Online Exam Portal -●-●--●-●-●-●--●-●-●-●-●-●-●\n");
        o.start();
       
    }
}
