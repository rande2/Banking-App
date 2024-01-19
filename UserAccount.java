/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

import java.util.ArrayList;

/**
 *
 * @author rande2
 */
public class UserAccount extends AbstractUser{
    private ArrayList<AbstractBankAccount> accountNumbers;
    private String name;
    UserAccount(String id,String n,ArrayList<AbstractBankAccount> accNums){
        this.id=id;
        name=n;
        idMarker='U';
        accountNumbers=accNums;
    }
    public String getName(){return name;}
    public ArrayList<AbstractBankAccount> getAccounts(){return accountNumbers;}
}
