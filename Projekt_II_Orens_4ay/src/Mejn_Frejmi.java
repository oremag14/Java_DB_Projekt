
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GERMAN
 */
public class Mejn_Frejmi extends javax.swing.JFrame {

    
    private Connection con = null;
    DatabaseMetaData d = null;
    
    public Mejn_Frejmi() {
        initComponents();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not load mysql driver!");
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading MySQL Driver");
            System.exit(1);
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

        Connection_Button = new javax.swing.JButton();
        Disconnection_Button = new javax.swing.JButton();
        Label_Server = new javax.swing.JLabel();
        Port_Label = new javax.swing.JLabel();
        Label_User = new javax.swing.JLabel();
        Label_Password = new javax.swing.JLabel();
        Label_Database = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Text_Server = new javax.swing.JTextField();
        Text_Port = new javax.swing.JTextField();
        Text_User = new javax.swing.JTextField();
        Text_Password = new javax.swing.JTextField();
        Text_Database = new javax.swing.JTextField();
        ComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Connection_Button.setText("Connect");
        Connection_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Connection_ButtonActionPerformed(evt);
            }
        });

        Disconnection_Button.setText("Disconnect");
        Disconnection_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Disconnection_ButtonActionPerformed(evt);
            }
        });

        Label_Server.setText("Server");

        Port_Label.setText("Port");

        Label_User.setText("User");

        Label_Password.setText("Password");

        Label_Database.setText("Database");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table);

        Text_Server.setText("localhost");
        Text_Server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_ServerActionPerformed(evt);
            }
        });

        Text_Port.setText("3306");
        Text_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_PortActionPerformed(evt);
            }
        });

        Text_User.setText("root");

        Text_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_PasswordActionPerformed(evt);
            }
        });

        Text_Database.setText("world");
        Text_Database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_DatabaseActionPerformed(evt);
            }
        });

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Server)
                    .addComponent(Port_Label)
                    .addComponent(Label_User)
                    .addComponent(Label_Password)
                    .addComponent(Label_Database))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Text_Database)
                    .addComponent(Text_Password)
                    .addComponent(Text_User)
                    .addComponent(Text_Port)
                    .addComponent(Text_Server))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Connection_Button)
                        .addGap(36, 36, 36)
                        .addComponent(Disconnection_Button))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Server)
                            .addComponent(Text_Server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Port_Label)
                            .addComponent(Text_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_User)
                            .addComponent(Text_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Password))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Database)
                            .addComponent(Text_Database, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Connection_Button)
                    .addComponent(Disconnection_Button)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Connection_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Connection_ButtonActionPerformed
       
        String server = Text_Server.getText();
        int port = Integer.parseInt(Text_Port.getText());
        String database = Text_Database.getText();
        String user = Text_User.getText();
        String password = Text_Password.getText();
        
        
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, password);
            Text_Server.setEnabled(false);
            Text_Port.setEnabled(false);
            Text_Database.setEnabled(false);
            Text_Server.setEnabled(false);
            Text_User.setEnabled(false);
            Text_Password.setEnabled(false);
            Connection_Button.setEnabled(false);
            Disconnection_Button.setEnabled(true);
            jScrollPane1.setEnabled(true);
        } catch (SQLException ex) {
            System.out.println("Could not connect to the database!");
            javax.swing.JOptionPane.showMessageDialog(this, "Could not connect to the  Server");
        }
        try {
            d = con.getMetaData();
            ResultSet res = d.getTables(null, null, null, null);
            while (res.next()) {
                ComboBox.addItem(res.getString(3));
                //System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Could not getdatabase data");
            javax.swing.JOptionPane.showMessageDialog(this, "Could not get database data");
        }
        
        
        
        
        
    }//GEN-LAST:event_Connection_ButtonActionPerformed

    private void Text_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_PasswordActionPerformed

    private void Text_ServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_ServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_ServerActionPerformed

    private void Text_PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_PortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_PortActionPerformed

    private void Text_DatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_DatabaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_DatabaseActionPerformed

    private void Disconnection_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Disconnection_ButtonActionPerformed
        try {
            con.close();
            Text_Server.setEnabled(true);
            Text_Port.setEnabled(true);
            Text_Database.setEnabled(true);
            Text_Server.setEnabled(true);
            Text_User.setEnabled(true);
            Text_Password.setEnabled(true);
            Connection_Button.setEnabled(true);
            Disconnection_Button.setEnabled(false);
            jScrollPane1.setEnabled(false);
        
        } catch (SQLException ex) {
            System.out.println("Error closing database connection");
            javax.swing.JOptionPane.showMessageDialog(this, "Error closing database connection");
        }
        
        
        
    }//GEN-LAST:event_Disconnection_ButtonActionPerformed

    private void cbxTablesActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int num_columns = 0;

        try {
            ResultSet result = d.getColumns(
                    null, null, ComboBox.getSelectedItem().toString(), null);

            //tblEntries.removeAll();
            DefaultTableModel tableModel = new DefaultTableModel();

            while (result.next()) {
                String columnName = result.getString(4);

                tableModel.addColumn(columnName);
                num_columns++;
                //               int columnType = result.getInt(5);
            }
            Table.setModel(tableModel);

        } catch (SQLException ex) {
            System.out.println("Error building column structure for table " + ComboBox.getSelectedItem().toString());
            javax.swing.JOptionPane.showMessageDialog(this, "Error building column structure for table " + ComboBox.getSelectedItem().toString());
        }

        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM " + ComboBox.getSelectedItem().toString());

            while (res.next()) {
                Object[] row = new Object[num_columns];
                for (int i = 1; i <= num_columns; i++) {
                    row[i - 1] = res.getObject(i);
                }
                ((DefaultTableModel) Table.getModel()).insertRow(res.getRow() - 1, row);
            }

            Table.getModel().addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    System.out.println("table changed");
                }
            });

        } catch (SQLException ex) {
            System.out.println("Error building result table from database");
            javax.swing.JOptionPane.showMessageDialog(this, "Error building result table from database");
        }


    }                                         
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Mejn_Frejmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mejn_Frejmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mejn_Frejmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mejn_Frejmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mejn_Frejmi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton Connection_Button;
    private javax.swing.JButton Disconnection_Button;
    private javax.swing.JLabel Label_Database;
    private javax.swing.JLabel Label_Password;
    private javax.swing.JLabel Label_Server;
    private javax.swing.JLabel Label_User;
    private javax.swing.JLabel Port_Label;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Text_Database;
    private javax.swing.JTextField Text_Password;
    private javax.swing.JTextField Text_Port;
    private javax.swing.JTextField Text_Server;
    private javax.swing.JTextField Text_User;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
