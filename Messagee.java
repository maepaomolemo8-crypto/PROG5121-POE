/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author ST10521302
 */
public class Messagee {
    
}
// Declarations
    private String recipient;
    private String messageText;
    private String messageHash;
    private int numMessages;
    private String messageID;

    //The list that keeps track of all messages sent during the session
    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static int totalMessagesSent = 0;
    private static int messageCounter = 0;
    
       public Message(String recipient, String messageText){
        this.recipient = recipient;
        this.messageText = messageText;
    
        this.messageID = generateMessageID();
        messageCounter++;
        this.numMessages = messageCounter;
        this.messageHash = createMessageHash();
    }

    // Generates a random 10 digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        long id = (long) (rand.nextDouble() * 9000000000L) + 1000000000L;
        return String.valueOf(id);
    }

    // Checking that the message ID is not more than 10 characters
    public boolean checkMessageID() {
        if (messageID.length() <= 10) {
            return true;
        }
        return false;
    }

    // Checking the recipient cell number - must be 10 chars or less and start with +
    public String checkRecipientCell() {
        if (recipient.length() <= 10 && recipient.startsWith("+")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Creates the message hash using first 2 digits of ID, message number, first and last word
    public String createMessageHash() {
        String firstTwoOfID = messageID.substring(0, 2);
        
        String[] words = messageText.trim().split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", "");

        String hash = firstTwoOfID + ":" + numMessages + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // User must choose to send, store, or disregard the message
    public String sentMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");

        int choice = sc.nextInt();

        if (choice == 1) {
            totalMessagesSent++;
            sentMessages.add("Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageText);
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            return "Message successfully stored.";
        } else {
            return "Invalid option selected.";
        }
    }
    public String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }

        String result = "";
        for (int i = 0; i < sentMessages.size(); i++) {
            result = result + "\n--- Message " + (i + 1) + " ---\n";
            result = result + sentMessages.get(i) + "\n";
        }
        return result;
    }
    public int returnTotalMessages() {
        return totalMessagesSent;
    }

    public String checkMessageLength() {
        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int over = messageText.length() - 250;
            return "Message exceeds 250 characters by " + over + "; please reduce the size.";
        }
    }
    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public int getNumMessages() {
        return numMessages;
    }

