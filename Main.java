/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rande2
 */
public class Main {

    /*
    Example user:
    *U1234567890*PzOEmrMvUAQj/mbChZHHKWQ==*N*John Doe*A1234567890*A0987654321*T
     */
    //u:user or e:employee, p:password, n:name, a:account, t:terminator
    //use Arrays.equals(arr,arr) to compare hashes
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path users = PathGetter.getPath("resources/users.txt", PathGetter.Location.PROGRAM);
        PathGetter.ensureExistance(users);
        Path accountsF = PathGetter.getPath("resources/accounts.txt", PathGetter.Location.PROGRAM);
        PathGetter.ensureExistance(accountsF);
        Path encryptStuff = PathGetter.getPath("resources/encrypt.txt", PathGetter.Location.PROGRAM);
        if (!Files.exists(encryptStuff))
            try {
            Files.write(encryptStuff, "abcdefghijklmnop\n65536".getBytes(), java.nio.file.StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Long card = 1234567890L;
        String p = "my_pass";
        ArrayList<AbstractBankAccount> accounts = new ArrayList<>();
        accounts.add(new AbstractBankAccount(1234567890L, 'C'));
        accounts.add(new AbstractBankAccount(9876543210L, 'J'));
        List<String> encrypt;
        try {
            encrypt = Files.readAllLines(encryptStuff);
            int ittr = Integer.parseInt(encrypt.get(1));
            System.out.println(PathGetter.getProgramDir());
            System.out.println(encrypt.get(0));
            System.out.println(Arrays.toString(encrypt.get(0).getBytes()));
            byte[] salt = encrypt.get(0).getBytes();
            byte[] hash = Hash.hash(p, salt, ittr);
            String first = "John";
            String last = "Does";

            String string = Hash.userText(card, hash, first, last, accounts);
            System.out.println(string);

            System.out.println("ID: " + Hash.userID(string));
            System.out.println("Pass: " + Hash.password(string));
            System.out.println("Name: " + Hash.name(string));
            ArrayList<String> accs = Hash.accounts(string);
            System.out.println("Accs:");
            for (String i : accs) {
                System.out.println(i);
            }
            System.out.println("a");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameMain frame = new JFrameMain();
                frame.setVisible(true);
                frame.setSize(400,300);
            }
        });
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

}
