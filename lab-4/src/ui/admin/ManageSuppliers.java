/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ManageSuppliers.java
 *
 * Created on Oct 1, 2011, 11:09:26 AM
 */

package ui.admin;

import model.Supplier;
import model.SupplierDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Deeksha Vempati
 */
public class ManageSuppliers extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private SupplierDirectory supplierDirectory;
    
    /** Creates new form ManageSuppliers */
    public ManageSuppliers(JPanel upc, SupplierDirectory sd) {
        initComponents();
        userProcessContainer = upc;
        supplierDirectory = sd;
        refreshTable();
    }
    
    public void refreshTable() {
        
        DefaultTableModel model = (DefaultTableModel)tblSuppliers.getModel();
        model.setRowCount(0);
        
        for(Supplier s : supplierDirectory.getSupplierList()) {
            Object row[] = new Object[1];
            row[0] = s;
           // row[1] = s.getProductCatalog().getProductCount() == 0 ? "None" : s.getProductCatalog().getProductCount();
            model.addRow(row);
        }
    }
  

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuppliers = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblSupplierList = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Supplier Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSuppliers);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnView.setText("View Supplier");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnAdd.setText("Add Supplier");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblSupplierList.setText("Manage Suppliers:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnRemove, btnView});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblSupplierList)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnView)
                    .addComponent(btnRemove))
                .addContainerGap(255, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        //int i=1;
        AddSupplier as = new AddSupplier(userProcessContainer, supplierDirectory);
        userProcessContainer.add("AddSupplier", as);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int row = tblSuppliers.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Supplier s = (Supplier)tblSuppliers.getValueAt(row, 0);
        ViewSupplier vs = new ViewSupplier(userProcessContainer, s);
        userProcessContainer.add("ViewSupplier", vs);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int row = tblSuppliers.getSelectedRow();
        
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Supplier s = (Supplier)tblSuppliers.getValueAt(row, 0);
        supplierDirectory.removeSupplier(s);
        refreshTable();
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSupplierList;
    private javax.swing.JTable tblSuppliers;
    // End of variables declaration//GEN-END:variables

}
