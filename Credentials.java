/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Rowan
 */
public class Credentials {

    public enum Item {
        EMPLOYEE_ID('E'),
        USER_ID('U'),
        PASSWORD('P'),
        NAME('N'),
        ACCOUNTS('A'),
        BALANCE('B'),
        TERMINATOR('T'),
        ACC_TYPE('Y'),
        ACC_NUM('N'),
        ACC_BALANCE('B'),
        CHECK_SRC('S'),
        CHECK_AMOUNT('A'),
        CHECK_RECIP('R');
        private char marker;
        Item(char m){
            marker=m;
        }
        public char getMarker(){
            return marker;
        }
        
    }
    
    public static String getOneItem(String string,Item item){
        //get marker for user id
        char marker = item.getMarker();
        boolean foundMarker = false;
        boolean reading = false;
        int start = 0;
        //for each char in the string
        for (int i = 0; i < string.length(); i++) {
            if (!reading) {
                if (foundMarker) {
                    if (string.charAt(i) == marker) {
                        //found the desired marker, start reading data
                        reading = true;
                        start = i + 1;
                    } else if (string.charAt(i) == Item.TERMINATOR.getMarker()) {
                        //reached end of string
                        break;
                    }
                    foundMarker = false;
                } else if (string.charAt(i) == '*') {
                    //just found a marker
                    foundMarker = true;
                }
            } else {
                if (string.charAt(i) == '*') {
                    //reached end of data
                    return (string.substring(start, i));
                }
            }
        }
        return null;
    }
    
    public static String checkText(String source,String amount,String recipient){
        StringBuilder builder = new StringBuilder();
        builder.append("*S");
        builder.append(source);
        builder.append("*A");
        builder.append(amount);
        builder.append("*R");
        builder.append(recipient);
        builder.append("*T");
        return builder.toString();
    }
    
    public static String checkAmount(String checkStr){
        return getOneItem(checkStr,Item.CHECK_AMOUNT);
    }
    
    public static String checkRecipient(String checkStr){
        return getOneItem(checkStr,Item.CHECK_RECIP);
    }
    
    public static String checkSource(String checkStr){
        return getOneItem(checkStr,Item.CHECK_SRC);
    } 

    public static String userID(String userStr){
        return getOneItem(userStr,Item.USER_ID);
    }
    
    public static String employeeID(String employeeStr){
        return getOneItem(employeeStr,Item.EMPLOYEE_ID);
    }
    
    public static String password(String passStr){
        return getOneItem(passStr,Item.PASSWORD);
    }
    
    public static String name(String userStr){
        return getOneItem(userStr,Item.NAME);
    }
    
    public static String accountNumber(String accStr){
        return getOneItem(accStr,Item.ACC_NUM);
    }
    
    public static String accountType(String accStr){
        return getOneItem(accStr,Item.ACC_TYPE);
    }
    
    public static String accountBalance(String accStr){
        return getOneItem(accStr,Item.ACC_BALANCE);
    }

    //gets a list of accounts owned by a user
    public static ArrayList<AbstractBankAccount> accounts(String userString) {
        ArrayList<AbstractBankAccount> result = new ArrayList<>();
        char marker = Item.ACCOUNTS.getMarker();
        boolean foundMarker = false;
        boolean reading = false;
        int start = 0;
        for (int i = 0; i < userString.length(); i++) {
            //if reading data
            if (!reading) {
                //if a marker has been found
                if (foundMarker) {
                    //if the marker is for the target marker
                    if (userString.charAt(i) == marker) {
                        //begin reading data at the next character
                        reading = true;
                        start = i + 1;
                    } else if (userString.charAt(i) == Item.TERMINATOR.getMarker()) {
                        //if reached the end of the string, break;
                        break;
                    }
                    foundMarker = false;
                } else if (userString.charAt(i) == '*') {
                    //found a marker
                    foundMarker = true;
                }
            } else {
                //if the beginning of another marker is found
                if (userString.charAt(i) == '*') {
                    //read from the start to this index and create a new account from it
                    result.add(AbstractBankAccount.newAccount(userString.substring(start, i)));
                    reading = false;
                    foundMarker = true;
                }
            }
        }
        return result;
    }

    public static String userText(String cardNum, byte[] hash, String name, List<AbstractBankAccount> accounts) {
        Base64.Encoder enc = Base64.getEncoder();
        StringBuilder builder = new StringBuilder();
        //card number
        builder.append("*U");
        builder.append(cardNum);
        //password
        builder.append("*P");
        //encode the byte array to a string in the Base64 Alphabet
        builder.append(enc.encodeToString(hash));
        //name
        builder.append("*N");
        builder.append(name);
        //add account information
        if (accounts != null) {
            for (AbstractBankAccount i : accounts) {
                builder.append("*A");
                builder.append(i.getType());
                builder.append(i.getNumber());
            }
        }
        //add terminator
        builder.append("*T");
        return builder.toString();
    }
    

    public static String employeeText(String id, byte[] hash, String name) {
        Base64.Encoder enc = Base64.getEncoder();
        StringBuilder builder = new StringBuilder();
        //employee id
        builder.append("*E");
        builder.append(id);
        //password
        builder.append("*P");
        //encode the byte array to a string in the Base64 Alphabet
        builder.append(enc.encodeToString(hash));
        //name
        builder.append("*N");
        builder.append(name);
        //terminator
        builder.append("*T");
        return builder.toString();
    }

    public static String accountText(AbstractBankAccount account) {
        StringBuilder builder = new StringBuilder();
        //number
        builder.append("*N");
        builder.append(account.getNumber());
        //type
        builder.append("*Y");
        builder.append(account.getType());
        //balance
        builder.append("*B");
        //terminator
        builder.append(account.getBalance());
        builder.append("*T");
        return builder.toString();
    }

    public static byte[] hash(String password, byte[] salt, int iterationCount) {
        //length of key to be created in bits
        int keyLength = salt.length * 8;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, keyLength);
        byte[] hash;
        try {
            //hash the password with PBKDF2
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            hash = new byte[1];
            Logger.getLogger(Credentials.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }
}
