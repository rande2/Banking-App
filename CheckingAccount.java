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
    CheckingAccount(String string){
        type='C';
        number=string.substring(1,string.length());
        readBalance();
        balance=Double.parseDouble(readBalance());
    }
    
}
