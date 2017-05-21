package bookingsystem;

import static bookingsystem.LoginForm.log;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AllBookingSlot extends javax.swing.JFrame {

    ArrayList<Booking> booking;

    /**
     * Creates new form AllBookingSlot
     */
    public AllBookingSlot() {
        initComponents();
        refreshBookingList();
        /*DefaultListModel model = new DefaultListModel();
        ArrayList<booking> booking = new ArrayList<booking>();
        
        try {
            ResultSet rs = bdb.selectQuery("SELECT * from bookings WHERE " +
                    "businessID =" );
            
            if (rs.isClosed()) {
                jList2.setModel(model);
            }
            
            while(rs.next()) {
                booking tmpBooking = new booking(rs.getInt("id"),
                        rs.getInt("businessID"),
                        rs.getInt("employeeID"),
                        rs.getInt("customerID"),
                        rs.getLong("timeStart"),
                        rs.getLong("timeFinish"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phonenumber"));
                booking.add(tmpBooking);
            }
            
            jList2.setModel(model);
        } catch (SQLException e) {
            jList2.setModel(model);
        }
        
        jList2.setModel(model);*/
    }

    /**
     * Refresh the list of bookings for the current business.
     *
     */
    public void refreshBookingList() {
        log.info("refreshing the list");
        DefaultListModel model = new DefaultListModel();

        // Get all bookings and display them
        booking = Business.currBusiness.getAllBooking();

        for (int i = 0; i < booking.size(); i++) {
            String str = new String();
            Booking tmpBooking = booking.get(i);
            Employee em = Business.currBusiness.getEmployee(tmpBooking.getEmployeeID());
            String bookingState = new String();

            // customerID of a booking will be a customer ID if it is booked,
            // customerIDs are always above 0.
            if (tmpBooking.getCustomerID() > 0) {
                bookingState = "Booked";
            } else {
                bookingState = "Not Booked";
            }
            str = "        " + tmpBooking.getEmployeeID() + "                      " + em.getName() + "                  "
                    + tmpBooking.getTimeStart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy   hh:mm a")) + " - " + tmpBooking.getTimeFinish().format(DateTimeFormatter.ofPattern("hh:mm a"))
                    + "          " + bookingState;
            model.addElement(str);
        }
        jList2.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("All Booking Slot");

        jButton1.setText("<-- Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList2.setToolTipText("");
        jList2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList2.setFixedCellHeight(35);
        jList2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jList2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jList2);

        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(deleteButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButton1.getAccessibleContext().setAccessibleName("Back");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new EmployeeArrangement().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jList2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jList2AncestorAdded

    /**
     * Delete a selected booking.
     *
     */
    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        Booking b = booking.get(jList2.getSelectedIndex());
        try {
            Business.currBusiness.deleteBooking(b);
        } catch (SQLException e) {
            log.warning("delete failed.");
            JOptionPane.showMessageDialog(this, "Error deleting booking", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        refreshBookingList();
    }//GEN-LAST:event_deleteButtonMouseClicked

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
            java.util.logging.Logger.getLogger(AllBookingSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllBookingSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllBookingSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllBookingSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllBookingSlot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
