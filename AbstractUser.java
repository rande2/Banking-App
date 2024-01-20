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
    
    public String getID(){
        return id;
    }
    public char getIDMarker(){
        return idMarker;
    }
    
}
