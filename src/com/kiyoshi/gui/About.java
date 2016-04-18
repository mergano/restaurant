package com.kiyoshi.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class About extends javax.swing.JFrame {

    public About() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        about_header = new javax.swing.JPanel();
        about_title = new javax.swing.JLabel();
        about_descrip_scroll = new javax.swing.JScrollPane();
        about_descrip_textbox = new javax.swing.JTextArea();
        about_body = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        about_picture = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        about_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/kiyoshi/info"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setName("base"); // NOI18N
        setPreferredSize(new java.awt.Dimension(350, 375));
        setResizable(false);

        about_header.setLayout(new java.awt.BorderLayout(0, 10));

        about_title.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        about_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_title.setText("About Kiyoshi Project");
        about_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        about_title.setPreferredSize(new java.awt.Dimension(180, 35));
        about_header.add(about_title, java.awt.BorderLayout.NORTH);

        about_descrip_scroll.setPreferredSize(new java.awt.Dimension(226, 200));

        about_descrip_textbox.setEditable(false);
        about_descrip_textbox.setColumns(20);
        about_descrip_textbox.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        about_descrip_textbox.setLineWrap(true);
        about_descrip_textbox.setRows(5);
        about_descrip_textbox.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n\nFor more information please visit: www.mergano.com  ");
        about_descrip_scroll.setViewportView(about_descrip_textbox);

        about_header.add(about_descrip_scroll, java.awt.BorderLayout.SOUTH);

        getContentPane().add(about_header, java.awt.BorderLayout.NORTH);

        about_body.setPreferredSize(new java.awt.Dimension(243, 250));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Product version:");

        about_picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/about.png"))); // NOI18N
        about_picture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        about_picture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                about_pictureMouseClicked(evt);
            }
        });

        jTextField1.setText("1.0.0");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Our Develop Team");

        javax.swing.GroupLayout about_bodyLayout = new javax.swing.GroupLayout(about_body);
        about_body.setLayout(about_bodyLayout);
        about_bodyLayout.setHorizontalGroup(
            about_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(about_bodyLayout.createSequentialGroup()
                .addGroup(about_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(about_bodyLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(about_picture))
                    .addGroup(about_bodyLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(327, Short.MAX_VALUE))
        );
        about_bodyLayout.setVerticalGroup(
            about_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(about_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(about_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(about_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(about_bodyLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(about_picture)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        getContentPane().add(about_body, java.awt.BorderLayout.SOUTH);

        about_close.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        about_close.setText("Close");
        about_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_closeActionPerformed(evt);
            }
        });
        getContentPane().add(about_close, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void about_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_about_closeActionPerformed

    private void about_pictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_about_pictureMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Juklab/mergano").toURI());
        } catch (URISyntaxException | IOException e) {
        }
    }//GEN-LAST:event_about_pictureMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel about_body;
    private javax.swing.JButton about_close;
    private javax.swing.JScrollPane about_descrip_scroll;
    private javax.swing.JTextArea about_descrip_textbox;
    private javax.swing.JPanel about_header;
    private javax.swing.JLabel about_picture;
    private javax.swing.JLabel about_title;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
