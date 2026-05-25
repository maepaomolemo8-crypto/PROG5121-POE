/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * @author ST10521302
 */
public class Main {

    private static String numMessageToSend;
    private static String messageSentSoFar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Declarations
        String userName;
        String passWord;
        int numMessagesToSend;
        int messagesSentSoFar = 0;
        boolean running = true;
        int menuChoice;
        String recipient;
        String messageText;
        String recipientCheck;
        String LengthCheck;
        String result;
        
        System.out.println("Please enter your username:");
        userName = sc.nextLine();
        
        System.out.println("Please enter your password:");
        passWord = sc.nextLine();
        
        if (userName.isEmpty() || passWord.isEmpty()) {
            System.out.println("Login failed. Please try again.");
            return;
            
        }
         System.out.println("Login successful! Welcome to QuickChat.");
         
         //Asking the user how many messages they would like to send
         System.out.println("How many messages would you like to send?");
         numMessagesToSend = sc.nextInt();
       
              
          //Running the menu until the user quits
          
         while (running){
          
             System.out.println("---QuickChat Menu---");
             System.out.println("1) Send Messages");
             System.out.println("2) Show recently sent messages");
             System.out.println("3) Quit");
             System.out.println("Choose an option:");
             
             menuChoice = sc.nextInt();
             sc.nextLine();
             
         if (menuChoice == 1) {
                 
                 if (messagesSentSoFar >= numMessagesToSend) {
                     System.out.println("You have reached your message limit of " + numMessageToSend + ".");
                 }else{
                   sc.nextLine();
                   
                     
              System.out.println("Enter recipient cell number (must start with + and be 10 characters or less):");
              recipient = sc.nextLine();
              
              System.out.println("Enter your message (max 250 characters):");
              messageText = sc.nextLine();
              
              Messagee msg = new Messagee (recipient, messageText);
              
              recipientCheck = msg.checkRecipientCell();
              System.out.println(recipientCheck);
              
              if (!recipientCheck.equals("Cell phone number successfully captured."));
                System.out.println("Message not created due to invalid recipient number.");
                 
                         
                     LengthCheck = msg.checkMessageLength();
                     System.out.println(LengthCheck);
                     
              if (!LengthCheck.equals("Message ready to send.")) {
                  System.out.println("Please shorten your message and try again.");
              }else{
                  System.out.println("----Message Details----");
                  System.out.println("Message ID: " + msg.getMessageID());
                  System.out.println("Message Hash: " + msg.getMessageHash());
                  System.out.println("recipient:" + msg.getRecipient());
                  System.out.println("Message: " + msg.getMessageText());
                  
                  result = msg.sentMessage();
                  System.out.println(result);
                  
                  if (result.equals("Message successfully sent.")){
                      messagesSentSoFar++;
                      
                  }
                  
              }
                  
              }
             
              
                 }
             else if (menuChoice == 2)
         
                     {  
                  System.out.println("Coming Soon.");
                     }else if (menuChoice == 3) {
                     running = false;
                     
                     }
             System.out.println("\nTotal messages sent: " + messageSentSoFar);
             System.out.println("Goodbye!");
         
        
        System.out.println("Invalid option. Please choose 1,2, or 3.");
                 }
    }
    
}

  


