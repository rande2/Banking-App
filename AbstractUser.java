/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

/**
 *
 * @author rande2
 */
abstract class AbstractUser {
    protected String id;
    protected char idMarker;
    protected static final char userIDMarker = 'U';
    protected static final char employeeIDMarker = 'E';
    protected static final char passwordMarker='P';
    protected static final char accountMarker='A';
    protected static final char terminatorMarker='T';
    protected static final char nameMarker='N';
    public String getID(){return id;}
    public char getIDMarker(){return idMarker;}
    public static final char getUserIDMarker(){return userIDMarker;}
    public static final char getEmployeeIDMarker(){return employeeIDMarker;}
    public static final char getPasswordMarker(){return passwordMarker;}
    public static final char getAccountMarker(){return accountMarker;}
    public static final char getTerminatorMarker(){return terminatorMarker;}
    public static final char getNameMarker(){return nameMarker;}
    
}
