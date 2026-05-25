/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Random;
/**
 *
 * @author ST10521302
 */
public class MessageTest{
    
    //Declarations
class Message {
    private String recipient;
    private String messageText;
    private String messageHash;
    private String messageID;

    public Message(String recipient, String messageText) {
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = "Message ID generated: " + generateID();
        this.messageHash = createMessageHash();
    }

    public String checkRecipientCell() {
        if (recipient.startsWith("+") && recipient.length() <= 10) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String checkMessageLength() {
        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int over = messageText.length() - 250;
            return "Message exceeds 250 characters by " + over + "; please reduce the size.";
        }
    }

    public String sentMessage(String option) {
        if (option.equals("Send Message")) {
            return "Message successfully sent.";
        } else if (option.equals("Disregard Message")) {
            return "Press 0 to delete the message.";
        } else if (option.equals("Store Message")) {
            return "Message successfully stored.";
        }
        return "";
    }

    private String generateID() {
        Random rand = new Random();
        return String.valueOf(1000000L + rand.nextInt(900000));
    }

    private String createMessageHash() {
        
        String firstWord = messageText.split(" ")[0].toUpperCase();
        return "00:0:" + firstWord;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }
}

// Public test class 
public class MessageTest {

    // Test 1 Message length <= 250 is a Success
    
    public void testMessageLengthSuccess() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }

    // Test 2 Message length > 250 - Failure
    
    public void testMessageLengthFailure() {
        String longMessage = "a".repeat(260);
        Message msg = new Message("+27718693002", longMessage);
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.", msg.checkMessageLength());
    }

    // Test 3 Recipient format correct - Success
    public void testRecipientFormatSuccess() {
        Message msg = new Message("+27718693002", "Test message");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    // Test 4 Recipient format incorrect - Failure
    public void testRecipientFormatFailure() {
        Message msg = new Message("27718693002", "Test message");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCell());
    }

    // Test 5 Message hash is correct for Test Case 1
    public void testMessageHash() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("00:0:HI", msg.getMessageHash());
    }

    // Test 6 Message ID is created
    public void testMessageIDCreated() {
        Message msg = new Message("+27718693002", "Test message");
        assertTrue(msg.getMessageID().startsWith("Message ID generated: "));
    }

    // Test 7 MessageSent - Send Message
    public void testMessageSent() {
        Message msg = new Message("+27718693002", "Test message");
        assertEquals("Message successfully sent.", msg.sentMessage("Send Message"));
    }

    // Test 8 MessageSent - Disregard Message
    public void testMessageDisregarded() {
        Message msg = new Message("+27718693002", "Test message");
        assertEquals("Press 0 to delete the message.", msg.sentMessage("Disregard Message"));
    }

    // Test 9 MessageSent - Store Message
    public void testMessageStored() {
        Message msg = new Message("+27718693002", "Test message");
        assertEquals("Message successfully stored.", msg.sentMessage("Store Message"));
    }

        private void assertEquals(String message_successfully_stored, String sentMessage) {
       
        }

        private void assertTrue(boolean startsWith) {
        }
    }
}
