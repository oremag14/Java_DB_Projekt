
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

    //Globale Variablen die ich in mehrere methoden verwenden will.
    private Connection con = null;
    DatabaseMetaData d = null;
    OurTableModel tableModel=null;
    int primPos;
    String primary_key;
    int ComboBoxIndex=0;

    
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
        delete_button = new javax.swing.JButton();
        Label_Database1 = new javax.swing.JLabel();

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

        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        Label_Database1.setText("Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_Database1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(delete_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Connection_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(Disconnection_Button)))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Database1)
                    .addComponent(delete_button)
                    .addComponent(Connection_Button))
                .addGap(29, 29, 29)
                .addComponent(Disconnection_Button)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Connection_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Connection_ButtonActionPerformed
       
        //Diese Methode macht die Verbindung mit der Daten Bank

        //Hier speichere ich die Werte die ich auf mein JDBC link verwenden werde,
        String server = Text_Server.getText();
        int port = Integer.parseInt(Text_Port.getText());
        String database = Text_Database.getText();
        String user = Text_User.getText();
        String password = Text_Password.getText();
        
        
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, password); //JDBC link mit die obere Variablen
            Text_Server.setEnabled(false);
            Text_Port.setEnabled(false);
            Text_Database.setEnabled(false);
            Text_Server.setEnabled(false);
            Text_User.setEnabled(false);
            Text_Password.setEnabled(false);
            Connection_Button.setEnabled(false);
            Disconnection_Button.setEnabled(true);
            jScrollPane1.setEnabled(true);
            //Verfuegbarkeit der andere Buttons wenn ich auf "Connect" druecke. 
        } catch (SQLException ex) {
            System.out.println("Could not connect to the database!");
            javax.swing.JOptionPane.showMessageDialog(this, "Could not connect to the  Server");
        }
        try {
            d = con.getMetaData();
            ResultSet res = d.getTables(null, null, null, null);
            while (res.next()) {
                ComboBox.addItem(res.getString(3));
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
            
        ComboBox.removeAllItems(); //Die Tabelle entleeren.
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

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        if(ComboBox.getSelectedItem()!=null){
            try {
                ComboBoxIndex=ComboBox.getSelectedIndex();
                d=con.getMetaData();
                ResultSet res =d.getColumns(null, null, ComboBox.getItemAt(ComboBoxIndex).toString(), null);
                ResultSet primaryKey=d.getPrimaryKeys(null, null, ComboBox.getItemAt(ComboBoxIndex));
                primaryKey.next();
                primPos=primaryKey.getInt("KEY_SEQ");
                primary_key=primaryKey.getString(4);
                System.out.println(primPos);
                tableModel=new OurTableModel(primPos-1);
                int num_cols=0;
                while(res.next()){
                    tableModel.addColumn(res.getString(4));
                    System.out.println(res.getString(4));
                    num_cols++;
                }
               
                Table.setModel(tableModel);
                Statement stm=con.createStatement();
                res=stm.executeQuery("select * from "+ComboBox.getItemAt(ComboBoxIndex));
                while(res.next()){
                    Object[] arr= new Object[num_cols];
                    for(int i=0;i<num_cols;i++){
                        arr[i]=res.getObject(i+1);
                    }
                    tableModel.addRow(arr);
                }

                tableModel.addRow(new Object[num_cols]);
                Table.setModel(tableModel);
                tableModel.addTableModelListener(new TableModelListener(){

                    @Override
                    public void tableChanged(TableModelEvent e) {
                        tblChanged(e);
                    }
                }
                );

                
            } catch (SQLException ex) {
                Logger.getLogger(Mejn_Frejmi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        int row=Table.getSelectedRow();//Eine Reihe selektieren.
        
        if(row!=Table.getModel().getRowCount()-1){
            int id=Integer.parseInt(Table.getModel().getValueAt(row, primPos-1).toString());
            try {
                PreparedStatement delete=con.prepareStatement("delete from "+ComboBox.getItemAt(ComboBoxIndex)+ " where "+primary_key+"=?");
                
                delete.setInt(1, id);
                delete.executeUpdate();
                tableModel.removeRow(row);
                
            } catch (SQLException ex) {
                Logger.getLogger(Mejn_Frejmi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

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
    private void tblChanged(TableModelEvent e){
        int row=e.getFirstRow();
        String columnName=Table.getModel().getColumnName(e.getColumn());
        if(row!=Table.getModel().getRowCount()-1){
            String id=Table.getModel().getValueAt(row, primPos-1).toString();
            System.out.println(columnName+row+id);
            String value=Table.getModel().getValueAt(row,e.getColumn()).toString();

            try {
                PreparedStatement update=con.prepareStatement("update " +ComboBox.getItemAt(ComboBoxIndex)+ " set "+columnName+"=? where "+primary_key+"=?");

                update.setString(1, value);
                update.setString(2, ""+id);
                System.out.println(update.toString());
                update.executeUpdate();//Update durchfuehren.
                
            } catch (SQLException ex) {
                Logger.getLogger(Mejn_Frejmi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //</editor-fold>
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mejn_Frejmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Mejn_Frejmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Mejn_Frejmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Mejn_Frejmi.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Auf jedes Betriebsystem schaut die Fenster anders.
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
    private javax.swing.JLabel Label_Database1;
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
    private javax.swing.JButton delete_button;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
