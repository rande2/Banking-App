/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rande2
 */
public abstract class AbstractBankAccount {

    protected String number;
    protected char type;
    protected double balance = 0;

    public static AbstractBankAccount newAccount(String s) {
        //return account type corresponding to type char in the string
        switch (s.charAt(0)) {
            case 'C'://checking
                return new CheckingAccount(s);
            case 'S'://savings
                return new SavingsAccount(s);
            case 'J'://joint
                return new JointAccount(s);
            default:
                return null;
        }
    }

    protected String readBalance() {
        //get file storing bank accounts
        Path file = PathGetter.programResource("resources/accounts.txt");
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                //if the account numbers match
                if (Credentials.accountNumber(line).equals(number)) {
                    //return the balance in the account
                    return Credentials.accountBalance(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AbstractBankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public double getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public char getType() {
        return type;
    }

    public String getTypeString() {
        //convert type char to a full string
        switch (type) {
            case 'C':
                return "Checking";
            case 'S':
                return "Savings";
            case 'J':
                return "Joint";
            default:
                return null;
        }
    }

    public void withdraw(UserAccount user, double amount) {
        //ensure no gaining money through negative withdraw
        if (amount < 0) {
            return;
        }
        Path file = PathGetter.programResource("resources/log.txt");
        //put a timestamp on the log
        String time = new Timestamp(new Date().getTime()).toString();
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            //create and write the log entry
            String logText = "Time: " + time + ", Name: " + user.getName() + ", ID: " + user.getID() + ", Account: " + number + ", Transaction: withdrawal, Amount: $" + String.format("%.2f", amount);
            writer.write(logText);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AbstractBankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        //update balance
        balance -= amount;
        updateBalance();
    }

    public void deposit(UserAccount user, double amount) {
        //ensure valid amount
        if (amount < 0) {
            return;
        }
        Path file = PathGetter.programResource("resources/log.txt");
        //get timestamp
        String time = new Timestamp(new Date().getTime()).toString();
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            //create and write log entry
            String logText = "Time: " + time + ", Name: " + user.getName() + ", ID: " + user.getID() + ", Account: " + number + ", Transaction: deposit, Amount: $" + String.format("%.2f", amount);
            writer.write(logText);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AbstractBankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        //update balance
        balance += amount;
        updateBalance();
    }

    private void updateBalance() {
        //get path to accounts file
        Path file = PathGetter.programResource("resources/accounts.txt");
        //index in the list of lines
        int index = -1;
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            //read all accounts
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            //find where in the list of accounts this account is
            for (int i = 0; i < lines.size(); i++) {
                if (Credentials.accountNumber(lines.get(i)).equals(number)) {
                    //record the index of this account
                    index = i;
                }
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(AbstractBankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        //if found
        if (index >= 0) {
            //create a new string for this account and write it to the list
            //write the list to the file
            try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.TRUNCATE_EXISTING)) {
                if (!lines.isEmpty()) {
                    //update the text for this account and write it to the file
                    lines.set(index, Credentials.accountText(this));
                    for (String i : lines) {
                        writer.write(i);
                        writer.newLine();
                    }
                }
                writer.close();
            } catch (Exception ex) {
                Logger.getLogger(AbstractBankAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
