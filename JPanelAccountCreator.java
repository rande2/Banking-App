/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bankProject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rowan
 */
public class JPanelAccountCreator extends javax.swing.JPanel {

    private JFrameMain frame;
    private Employee employee;

    /**
     * Creates new form JPanelAccountCreator
     */
    public JPanelAccountCreator(JFrameMain f, Employee e) {
        frame = f;
        employee = e;
        initComponents();
        Path log = PathGetter.programResource("resources/log.txt");
        //display all the log data for the employee to read
        //TODO: avoid filling the RAM with a large log file, change to bufferedreader
        //and load the file in segments
        try {
            jTextPaneLog.setText(
                Files.newBufferedReader(log).lines().collect(java.util.stream.Collectors.joining(System.lineSeparator()))
            );
        } catch (IOException ex) {
            Logger.getLogger(JPanelAccountCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonCreateUser = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneLog = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUserID = new javax.swing.JTextField();
        jTextFieldAccountType = new javax.swing.JTextField();
        jButtonCreateAccount = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneNewUserID = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Signed in as Employee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButtonCreateUser.setText("Create User");
        jButtonCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateUserActionPerformed(evt);
            }
        });

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        jTextPaneLog.setEditable(false);
        jScrollPane1.setViewportView(jTextPaneLog);

        jLabel3.setText("User ID(s):");

        jLabel4.setText("Account type(C,J,S):");

        jButtonCreateAccount.setText("Create Account");
        jButtonCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateAccountActionPerformed(evt);
            }
        });

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Password:");

        jTextPaneNewUserID.setEditable(false);
        jScrollPane2.setViewportView(jTextPaneNewUserID);

        jLabel6.setText("Separate the IDs by a comma");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldAccountType))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldName))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldUserID))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldPassword))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButtonCreateUser)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonCreateAccount)
                        .addGap(142, 142, 142)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCreateUser)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCreateAccount))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frame.setPanel(new JPanelEmployeeLogin(frame));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateUserActionPerformed
        //load required files for encryption and ID info
        Path encryptFile = PathGetter.programResource("resources/encrypt.txt");
        Path bankData = PathGetter.programResource("resources/bankData.txt");
        Path usersFile = PathGetter.programResource("resources/users.txt");
        String name = jTextFieldName.getText();
        String passwordStr = jTextFieldPassword.getText();
        //only continue if the fields are not empty
        if(name==null||passwordStr==null){
            jTextPaneNewUserID.setText("Field is empty");
            return;
        }
        try {
            //index: 0: salt, 1:ittrs
            List<String> encrypt = Files.readAllLines(encryptFile);
            int ittrs = Integer.parseInt(encrypt.get(1));
            byte[] password = Credentials.hash(passwordStr, encrypt.get(0).getBytes(), ittrs);
            List<String> data = Files.readAllLines(bankData);
            //get next user id number
            String userID = data.get(0);
            Long temp = Long.valueOf(userID);
            //get future id number
            Long newID = temp + 1;
            //ensure leading zeros
            int length=userID.length();
            for (int i = 0; i < (10 - length); i++) {
                userID = "0" + userID;
            }
            //rewrite the next ID number to the bankData file
            data.set(0, newID.toString());
            BufferedWriter writer = Files.newBufferedWriter(bankData, StandardOpenOption.TRUNCATE_EXISTING);
            for (String i : data) {
                writer.write(i);
                writer.newLine();
            }
            writer.close();
            //write the new user's data to the users file
            String userText = Credentials.userText(userID, password, name, null);
            writer = Files.newBufferedWriter(usersFile, StandardOpenOption.APPEND);
            writer.write(userText);
            writer.newLine();
            writer.close();
            //display the new ID
            jTextPaneNewUserID.setText("New user ID: " + userID);
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(JPanelAccountCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextFieldName.setText(null);
        jTextFieldPassword.setText(null);
    }//GEN-LAST:event_jButtonCreateUserActionPerformed

    private void jButtonCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateAccountActionPerformed
        //get required files
        Path bankData = PathGetter.programResource("resources/bankData.txt");
        Path accountsFile = PathGetter.programResource("resources/accounts.txt");
        Path usersFile = PathGetter.programResource("resources/users.txt");
        String idStr = jTextFieldUserID.getText();
        //get separated user ids from the input text
        idStr = idStr.replaceAll("\\s", "");
        String[] ids = idStr.split(",");
        String type = jTextFieldAccountType.getText();
        //only continue if valid type count
        if (type.length() == 1) {
            //only continue if valid type is provided
            //if the type is not Joint, allow only one user to own the account
            char t = type.charAt(0);
            if (!(t == 'J' || t == 'C' || t == 'S') || (t != 'J' && ids.length > 1)) {
                System.out.println("fail");
                return;
            }
            List<String> data;
            try {
                data = Files.readAllLines(bankData);
                //get next user id number
                String accountNum = data.get(1);
                Long temp = Long.valueOf(accountNum);
                //get future id number
                Long newAccountNum = temp + 1;
                //ensure leading zeros
                int length=accountNum.length();
                for (int i = 0; i < 10 - length; i++) {
                    accountNum = "0" + accountNum;
                }
                //rewrite new id to file
                data.set(0, newAccountNum.toString());
                BufferedWriter writer = Files.newBufferedWriter(bankData, StandardOpenOption.TRUNCATE_EXISTING);
                for (String i : data) {
                    writer.write(i);
                    writer.newLine();
                }
                writer.close();
                //create bank account and write its data to the accounts file
                AbstractBankAccount account = AbstractBankAccount.newAccount(type + accountNum);
                writer = Files.newBufferedWriter(accountsFile, StandardOpenOption.APPEND);
                writer.write(Credentials.accountText(account));
                writer.newLine();
                writer.close();
                //read all users from the users file
                List<String> lines = Files.readAllLines(usersFile);
                String id;
                String line;
                for (int i = 0; i < lines.size(); i++) {
                    //get the user's id
                    line = lines.get(i);
                    id = Credentials.userID(line);
                    for (String j : ids) {
                        //if the string corresponds to a target ID
                        if (id!=null&&id.equals(j)) {
                            byte[] password = Base64.getDecoder().decode(Credentials.password(line));
                            //add the account to the list of accounts owned by the user.
                            ArrayList<AbstractBankAccount> accounts = Credentials.accounts(line);
                            accounts.add(account);
                            //set the user's text to the updated text containing the new account
                            String name = Credentials.name(line);
                            lines.set(i, Credentials.userText(id, password, name, accounts));
                        }
                    }
                }
                //rewrite the users to the users file
                writer = Files.newBufferedWriter(usersFile, StandardOpenOption.APPEND);
                for (String i : lines) {
                    writer.write(i);
                    writer.newLine();
                }

            } catch (IOException ex) {
                Logger.getLogger(JPanelAccountCreator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButtonCreateAccountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCreateAccount;
    private javax.swing.JButton jButtonCreateUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAccountType;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUserID;
    private javax.swing.JTextPane jTextPaneLog;
    private javax.swing.JTextPane jTextPaneNewUserID;
    // End of variables declaration//GEN-END:variables
}
