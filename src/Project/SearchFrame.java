package Project;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Aman
 */
public class SearchFrame extends javax.swing.JFrame {
    
    private static Connection conn = Database.connection; 
    
    public SearchFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priceFromLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        sortByComboBox = new javax.swing.JComboBox<>();
        priceToLabel = new javax.swing.JLabel();
        streetNameLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        minbedroomLabel = new javax.swing.JLabel();
        bedroomSpinner = new javax.swing.JSpinner();
        ViewButton = new javax.swing.JButton();
        stateTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        cityLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        countryTextField = new javax.swing.JTextField();
        sortByLabel = new javax.swing.JLabel();
        streetNameTextField = new javax.swing.JTextField();
        priceToTextField = new javax.swing.JTextField();
        priceFromTextField = new javax.swing.JTextField();
        availableForComboBox = new javax.swing.JComboBox<>();
        availableForLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Real_Estate");
        setMinimumSize(new java.awt.Dimension(570, 375));

        priceFromLabel.setText("From:");

        cityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityTextFieldActionPerformed(evt);
            }
        });

        sortByComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Price Low to High", "Price High to Low" }));

        priceToLabel.setText("To:");

        streetNameLabel.setText("Street Name:");

        stateLabel.setText("State:");

        countryLabel.setText("Country:");

        minbedroomLabel.setText("Min. Bedroom:");

        ViewButton.setText("Search");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });

        stateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateTextFieldActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(resultTable);

        cityLabel.setText("City:");

        priceLabel.setText("Price:");

        countryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryTextFieldActionPerformed(evt);
            }
        });

        sortByLabel.setText("Sort By:");

        streetNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetNameTextFieldActionPerformed(evt);
            }
        });

        priceToTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceToTextFieldActionPerformed(evt);
            }
        });

        priceFromTextField.setToolTipText("");
        priceFromTextField.setInheritsPopupMenu(true);
        priceFromTextField.setName(""); // NOI18N
        priceFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFromTextFieldActionPerformed(evt);
            }
        });

        availableForComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Both for Sell and Rent", "Sell Only", "Rent Only" }));

        availableForLabel.setText("Available For:");

        editMenu.setText("Edit");
        menuBar.add(editMenu);

        viewMenu.setText("View");
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceFromLabel))
                    .addComponent(priceToLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(streetNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(priceToTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceFromTextField)
                            .addComponent(streetNameTextField))
                        .addGap(18, 18, 18)
                        .addComponent(cityLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(ViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(67, 67, 67)
                                .addComponent(sortByLabel)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(minbedroomLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bedroomSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(availableForLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityTextField)
                        .addGap(35, 35, 35)
                        .addComponent(stateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stateTextField)
                        .addGap(16, 16, 16)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(sortByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(availableForComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(countryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countryTextField)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetNameLabel)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityLabel)
                    .addComponent(stateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateLabel)
                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryLabel)
                    .addComponent(streetNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceLabel)
                            .addComponent(priceFromLabel)
                            .addComponent(priceFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceToLabel)
                            .addComponent(priceToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(minbedroomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bedroomSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(availableForComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(availableForLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewButton)
                    .addComponent(sortByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortByLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void countryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryTextFieldActionPerformed

    private void stateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateTextFieldActionPerformed

    private void cityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityTextFieldActionPerformed

    private void streetNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetNameTextFieldActionPerformed

    private void priceToTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceToTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceToTextFieldActionPerformed

    private void priceFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFromTextFieldActionPerformed

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButtonActionPerformed
        prepQuery();
    }//GEN-LAST:event_ViewButtonActionPerformed
    
    private void prepQuery() {
        PreparedStatement pStmt;
        String order = (String)sortByComboBox.getSelectedItem();
        if(order.equals("Price Low to High")) order="Asc";
        else order="Desc";
        try {
            String[] values = new String[8];
            values[0] = streetNameTextField.getText();
            values[1] = cityTextField.getText();
            values[2] = stateTextField.getText();
            values[3] = countryTextField.getText();
            values[4] = priceToTextField.getText();
            values[5] = priceFromTextField.getText();
            values[6] = bedroomSpinner.getValue().toString();
            values[7] = (String)availableForComboBox.getSelectedItem();
            if(values[7].equals("Both for Sell and Rent")) values[7] = "Available%";
            else if(values[7].equals("Sell Only")) values[7] = "%Sell";
            else values[7] = "%Rent";
       	
            for(int i=0; i<4; i++) {
                if(values[i].equals("")) values[i] = "%";
            }
            if(values[4].equals("")) values[4] = "0";
            if(values[5].equals("")) values[5] = Integer.toString(Integer.MAX_VALUE);
            pStmt = conn.prepareStatement("SELECT Field_Size, Number_Of_Bedrooms as No_Of_Bedroom, Price, Street_Name, City, State, Country from estate natural join in_charge where Street_Name Like ? AND City Like ? AND State Like ? AND Country Like ? AND Price >= ? AND Price <= ? AND Number_Of_Bedrooms >= ? AND Status LIKE ? ORDER BY PRICE " + order);
            for(int i=0; i<8; i++) {
            	pStmt.setString(i+1, values[i]);
            }
            //System.out.println(pStmt);
            runQuery(pStmt);
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
    
    private void printHelper(int noOfColumns, ArrayList<Integer> columnWidth) throws SQLException {
	int i, j;
	for(i = 0; i<noOfColumns; i++) {
		System.out.print("+");
		for(j=0; j<=columnWidth.get(i)+1; j++)
                    System.out.print("-");
	}
	System.out.println("-+");
    }
    
    private void runQuery(PreparedStatement pStmt) {
        ResultSet rset;
	ResultSetMetaData rsmd;
	ArrayList<Integer> columnWidth = new ArrayList<Integer>();
	int i, row, col;
	try {
            rset = pStmt.executeQuery();
            rsmd = rset.getMetaData();
            row = 0; col = rsmd.getColumnCount();            
            //Check Result is not empty
            if(!rset.next()) {
		System.out.println("Empty set.\n");
                return;
            }
				
            //Calculate Column width
            for(i=1; i<=col; i++) {
                columnWidth.add(Math.max(rsmd.getColumnDisplaySize(i), rsmd.getColumnName(i).length()));
            }
				
            //Print Column Heading
            printHelper(col, columnWidth);
            for(i=1; i<=col; i++) {
                System.out.format("| %-" + columnWidth.get(i-1) + "s ", rsmd.getColumnName(i));
            }
            System.out.println(" |");
            printHelper(col, columnWidth);
				
            //Print Result
            do {
                for(i=1; i<=col; i++) {
                    System.out.format("| %-" + columnWidth.get(i-1) + "s ", rset.getString(i));
                }
                System.out.println(" |");
		row++;
            } while(rset.next());
            printHelper(col, columnWidth);
            System.out.println(row + " rows\n");
            columnWidth.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void display() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewButton;
    private javax.swing.JComboBox<String> availableForComboBox;
    private javax.swing.JLabel availableForLabel;
    private javax.swing.JSpinner bedroomSpinner;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JMenu editMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel minbedroomLabel;
    private javax.swing.JLabel priceFromLabel;
    private javax.swing.JTextField priceFromTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceToLabel;
    private javax.swing.JTextField priceToTextField;
    private javax.swing.JTable resultTable;
    private javax.swing.JComboBox<String> sortByComboBox;
    private javax.swing.JLabel sortByLabel;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JLabel streetNameLabel;
    private javax.swing.JTextField streetNameTextField;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
}