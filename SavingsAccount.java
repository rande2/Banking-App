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
    SavingsAccount(String string){
        type='S';
        number=string.substring(1,string.length());
    }
}
