/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

/**
 *
 * @author Rowan
 */
public class JointAccount extends AbstractBankAccount{
    JointAccount(String accString){
        type='J';
        number=accString.substring(1,accString.length());
        String b = readBalance();
        if(b!=null)
            balance=Double.parseDouble(b);
    }
}
