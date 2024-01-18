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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Rowan
 */
public class Hash {
    public enum Item{
        EMPLOYEE_ID,USER_ID,PASSWORD,NAME,ACCOUNTS
    }
    
    public static String userID(String string){
        char marker=AbstractUser.getUserIDMarker();
        boolean foundMarker=false;
        boolean reading=false;
        int start=0;
        for(int i=0;i<string.length();i++){
            if(!reading){
                if(foundMarker){
                    if(string.charAt(i)==marker){
                        reading=true;
                        start=i+1;
                    }else if(string.charAt(i)==AbstractUser.getTerminatorMarker())
                        break;
                    foundMarker=false;
                }else if(string.charAt(i)=='*'){
                    foundMarker=true;
                }  
            }else{
               if(string.charAt(i)=='*'){
                   return (string.substring(start,i));
               }
            }
        }
        return null;
    }
    
    public static String employeeID(String string){
        char marker=AbstractUser.getEmployeeIDMarker();
        boolean foundMarker=false;
        boolean reading=false;
        int start=0;
        for(int i=0;i<string.length();i++){
            if(!reading){
                if(foundMarker){
                    if(string.charAt(i)==marker){
                        reading=true;
                        start=i+1;
                    }else if(string.charAt(i)==AbstractUser.getTerminatorMarker())
                        break;
                    foundMarker=false;
                }else if(string.charAt(i)=='*'){
                    foundMarker=true;
                }  
            }else{
               if(string.charAt(i)=='*'){
                   return (string.substring(start,i));
               }
            }
        }
        return null;
    }
            
    public static String password(String string){
        char marker=AbstractUser.getPasswordMarker();
        boolean foundMarker=false;
        boolean reading=false;
        int start=0;
        for(int i=0;i<string.length();i++){
            if(!reading){
                if(foundMarker){
                    if(string.charAt(i)==marker){
                        reading=true;
                        start=i+1;
                    }else if(string.charAt(i)==AbstractUser.getTerminatorMarker())
                        break;
                    foundMarker=false;
                }else if(string.charAt(i)=='*'){
                    foundMarker=true;
                }  
            }else{
               if(string.charAt(i)=='*'){
                   return (string.substring(start,i));
               }
            }
        }
        return null;
    }
    
    public static String name(String string){
        char marker=AbstractUser.getNameMarker();
        boolean foundMarker=false;
        boolean reading=false;
        int start=0;
        for(int i=0;i<string.length();i++){
            if(!reading){
                if(foundMarker){
                    if(string.charAt(i)==marker){
                        reading=true;
                        start=i+1;
                    }else if(string.charAt(i)==AbstractUser.getTerminatorMarker())
                        break;
                    foundMarker=false;
                }else if(string.charAt(i)=='*'){
                    foundMarker=true;
                }  
            }else{
               if(string.charAt(i)=='*'){
                   return (string.substring(start,i));
               }
            }
        }
        return null;
    }
    
    public static ArrayList<AbstractBankAccount> accounts(String userString){
        ArrayList<AbstractBankAccount> result=new ArrayList<>();
        char marker=AbstractUser.getAccountMarker();
        boolean foundMarker=false;
        boolean reading=false;
        int start=0;
        for(int i=0;i<userString.length();i++){
            if(!reading){
                if(foundMarker){
                    if(userString.charAt(i)==marker){
                        reading=true;
                        start=i+1;
                    }else if(userString.charAt(i)==AbstractUser.getTerminatorMarker())
                        break;
                    foundMarker=false;
                }else if(userString.charAt(i)=='*'){
                    foundMarker=true;
                }  
            }else{
               if(userString.charAt(i)=='*'){
                   result.add(AbstractBankAccount.newAccount(userString.substring(start,i)));
                   reading=false;
                   foundMarker=true;
               }
            }
        }
        return result;
    }
    
    
    //TODO: chage cardNum to a string and move the 0 appender to other code
    public static String userText(String cardNum,byte[] hash,String first,String last,List<AbstractBankAccount> accounts){
        Base64.Encoder enc = Base64.getEncoder();
        StringBuilder builder = new StringBuilder();
        builder.append("*U");
        builder.append(cardNum);
        builder.append("*P");
        builder.append(enc.encodeToString(hash));
        builder.append("*N");
        builder.append(first);
        builder.append(" ");
        builder.append(last);
        for(AbstractBankAccount i:accounts){
            builder.append("*A");
            builder.append(i.getType());
            builder.append(i.getNumber());
        }
        builder.append("*T");
        return builder.toString();
    }
    
    public static String employeeText(Long id,byte[] hash,String first,String last){
        Base64.Encoder enc = Base64.getEncoder();
        StringBuilder builder = new StringBuilder();
        builder.append("*E");
        builder.append(id.toString());
        builder.append("*P");
        builder.append(enc.encodeToString(hash));
        builder.append("*N");
        builder.append(first);
        builder.append(" ");
        builder.append(last);
        builder.append("*T");
        return builder.toString();
    }
    
    public static String accountText(AbstractBankAccount account){
        StringBuilder builder=new StringBuilder();
        builder.append("*N");
        builder.append(account.getNumber());
        builder.append("*Y");
        builder.append(account.getType());
        builder.append("*B");
        builder.append(account.getBalance());
        builder.append("*T");
        return builder.toString();
    }
    
    public static String accountNumber(String accString){
        char marker='N';
        boolean foundMarker=false;
        boolean reading=false;
        int start=0;
        for(int i=0;i<accString.length();i++){
            if(!reading){
                if(foundMarker){
                    if(accString.charAt(i)==marker){
                        reading=true;
                        start=i+1;
                    }else if(accString.charAt(i)==AbstractUser.getTerminatorMarker())
                        break;
                    foundMarker=false;
                }else if(accString.charAt(i)=='*'){
                    foundMarker=true;
                }  
            }else{
               if(accString.charAt(i)=='*'){
                   return accString.substring(start,i);
               }
            }
        }
        return null;
    }
    
    public static String accountBalance(String accString){
        char marker='B';
        boolean foundMarker=false;
        boolean reading=false;
        int start=0;
        for(int i=0;i<accString.length();i++){
            if(!reading){
                if(foundMarker){
                    if(accString.charAt(i)==marker){
                        reading=true;
                        start=i+1;
                    }else if(accString.charAt(i)==AbstractUser.getTerminatorMarker())
                        break;
                    foundMarker=false;
                }else if(accString.charAt(i)=='*'){
                    foundMarker=true;
                }  
            }else{
               if(accString.charAt(i)=='*'){
                   return accString.substring(start,i);
               }
            }
        }
        return null;
    }
    
    public static void createBankAccount(AbstractBankAccount account){
        Path accountFile = PathGetter.programResource("resources/accounts.txt");
        PathGetter.ensureExistance(accountFile);
        try(BufferedWriter accWriter = Files.newBufferedWriter(accountFile,StandardOpenOption.CREATE,StandardOpenOption.APPEND)){
            accWriter.write(accountText(account));
            accWriter.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static byte[] hash(String password,byte[] salt,int itterationCount){
        int keyLength = salt.length*8;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),salt,itterationCount,keyLength);
        byte[] hash;
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            hash = new byte[1];
            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }
    
    //unused
    public static byte[] charsToBytes(char[] chars){
        java.nio.charset.Charset charset = java.nio.charset.Charset.forName("UTF-16");
        java.nio.ByteBuffer byteBuffer = charset.encode(java.nio.CharBuffer.wrap(chars));
        //zero out the array
        for(int i=0;i<chars.length;i++)
            chars[i]=0;
        return Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());
    }
    
}
