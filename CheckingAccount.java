/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

/**
 *
 * @author Rowan
 */
public class CheckingAccount extends AbstractBankAccount{
    CheckingAccount(String accString){
        type='C';
        number=accString.substring(1,accString.length());
        readBalance();
        //avoid errors with returning null
        String b = readBalance();
        if(b!=null)
            balance=Double.parseDouble(b);
    }
    
    public String getCheck(String name,double amount){
        //ensure valid amount
        if(amount<0)
            return null;
        //return a string representing the check
        return"Recipient: "+name+", From: "+number+", Amount: "+String.format("%.2f",amount);
    }
    
}
