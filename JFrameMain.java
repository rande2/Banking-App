/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bankProject;

/**
 *
 * @author Rowan
 */
public class JFrameMain extends javax.swing.JFrame {
    /**
     * Creates new form JFrameMain
     */
    private javax.swing.JPanel currentPanel=null;
    public JFrameMain() {
        initComponents();
        setPanel(new JPanelUserLogin(this));
    }

    public final void setPanel(javax.swing.JPanel panel){
        //remove any panels it contains
        if(currentPanel!=null)
            remove(currentPanel);
        //set new panel
        currentPanel=panel;
        add(currentPanel);
        currentPanel.setVisible(true);
        //refresh the frame
        super.paintComponents(getGraphics());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Somewhat Functional Banking App");
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
