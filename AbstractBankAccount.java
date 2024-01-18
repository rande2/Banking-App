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
import java.util.ArrayList;
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
        switch (s.charAt(0)) {
            case 'C':
                return new CheckingAccount(s);
            case 'S':
                return new SavingsAccount(s);
            case 'J':
                return new JointAccount(s);
            default:
                return null;
        }
    }
    
    protected String readBalance(){
        Path file = PathGetter.programResource("resources/accounts.txt");
        String balanceStr=null;
        try(BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while((line=reader.readLine())!=null){
                if(Hash.accountNumber(line).equals(number)){
                    return Hash.accountBalance(line);
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

    public void withdraw(double amount) {
        balance -= amount;
        updateBalance();
    }

    public void deposit(double amount) {
        balance += amount;
        updateBalance();
    }

    private void updateBalance() {
        Path file = PathGetter.programResource("resources/accounts.txt");
        PathGetter.ensureExistance(file);
        int count = -1;
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while((line=reader.readLine())!=null)
                lines.add(line);
            for (int i = 0; i < lines.size(); i++) {
                if (Hash.accountNumber(lines.get(i)).equals(number)) {
                    count = i;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AbstractBankAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (count >= 0) {
            try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.TRUNCATE_EXISTING)) {
                if (lines != null) {
                    lines.set(count,Hash.accountText(this));
                    for (String i : lines) {
                        writer.write(i);
                        writer.newLine();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(AbstractBankAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
