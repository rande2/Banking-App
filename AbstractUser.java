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
    protected static final char USER_ID_MARKER = 'U';
    protected static final char EMPLOYEE_ID_NUMBER = 'E';
    protected static final char PASSWORD_MARKER='P';
    protected static final char ACCOUNT_MARKER='A';
    protected static final char TERMINATOR_MARKER='T';
    protected static final char NAME_MARKER='N';
    
    public static final char getUserIDMarker(){return USER_ID_MARKER;}
    public static final char getEmployeeIDMarker(){return EMPLOYEE_ID_NUMBER;}
    public static final char getPasswordMarker(){return PASSWORD_MARKER;}
    public static final char getAccountMarker(){return ACCOUNT_MARKER;}
    public static final char getTerminatorMarker(){return TERMINATOR_MARKER;}
    public static final char getNameMarker(){return NAME_MARKER;}
    
    public String getID(){
        return id;
    }
    public char getIDMarker(){
        return idMarker;
    }
    
}
