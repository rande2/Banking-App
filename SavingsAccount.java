/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

/**
 *
 * @author Rowan
 */
public class SavingsAccount extends AbstractBankAccount{
    SavingsAccount(String accString){
        type='S';
        number=accString.substring(1,accString.length());
        String b = readBalance();
        if(b!=null)
            balance=Double.parseDouble(b);
    }
}
