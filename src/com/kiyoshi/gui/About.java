package com.kiyoshi.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class About extends javax.swing.JFrame {

    public About() {
        initComponents();
    }

    private javax.swing.JPanel about_body;
    private javax.swing.JButton about_close;
    private javax.swing.JScrollPane about_descrip_scroll;
    private javax.swing.JTextArea about_descrip_textbox;
    private javax.swing.JPanel about_footer;
    private javax.swing.JPanel about_header;
    private javax.swing.JLabel about_picture;
    private javax.swing.JLabel about_title;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel product_version_label;
    private javax.swing.JTextField version_label;

    private void initComponents() {
        about_header = new javax.swing.JPanel();
        about_title = new javax.swing.JLabel();
        about_descrip_scroll = new javax.swing.JScrollPane();
        about_descrip_textbox = new javax.swing.JTextArea();
        about_body = new javax.swing.JPanel();
        product_version_label = new javax.swing.JLabel();
        about_picture = new javax.swing.JLabel();
        version_label = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        about_footer = new javax.swing.JPanel();
        about_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/kiyoshi/info"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setAlwaysOnTop(true);
        setIconImages(null); // icon image
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("base");
        setPreferredSize(new java.awt.Dimension(350, 375));
        setResizable(false);
        setSize(new java.awt.Dimension(350, 375));
        // About title
        about_title.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18));
        about_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_title.setText("About Kiyoshi Project");
        about_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        about_title.setPreferredSize(new java.awt.Dimension(180, 35));

        // About description scroll box
        about_descrip_scroll.setMinimumSize(new java.awt.Dimension(250, 200));
        about_descrip_scroll.setPreferredSize(new java.awt.Dimension(250, 200));
        about_descrip_textbox.setEditable(false);
        about_descrip_textbox.setColumns(20);
        about_descrip_textbox.setFont(new java.awt.Font("Segoe UI", 0, 12));
        about_descrip_textbox.setLineWrap(true);
        about_descrip_textbox.setRows(5);
        about_descrip_textbox.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n\nFor more information please visit: www.mergano.com  ");
        about_descrip_textbox.setMaximumSize(new java.awt.Dimension(250, 200));
        about_descrip_textbox.setMinimumSize(new java.awt.Dimension(250, 200));
        about_descrip_textbox.setPreferredSize(new java.awt.Dimension(250, 200));
        about_descrip_scroll.setViewportView(about_descrip_textbox);

        javax.swing.GroupLayout about_headerLayout = new javax.swing.GroupLayout(about_header);
        about_header.setLayout(about_headerLayout);
        about_headerLayout.setHorizontalGroup(
                about_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(about_headerLayout.createSequentialGroup()
                        .addComponent(about_title, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, about_headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(about_descrip_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        about_headerLayout.setVerticalGroup(
                about_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(about_headerLayout.createSequentialGroup()
                        .addComponent(about_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(about_descrip_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 189, Short.MAX_VALUE)
                        .addContainerGap())
        );

        getContentPane().add(about_header, java.awt.BorderLayout.NORTH);
        about_body.setPreferredSize(new java.awt.Dimension(245, 250));

        product_version_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        product_version_label.setText("Product version:");
        about_body.add(product_version_label);

        about_picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/kiyoshi/img/kiyoshi_header.png"))); // NOI18N
        about_picture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        about_picture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                about_pictureMouseClicked(evt);
            }
        });
        about_body.add(about_picture);
        version_label.setText("1.0.0");
        about_body.add(version_label);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Our Develop Team");
        about_body.add(jLabel4);

        getContentPane().add(about_body, java.awt.BorderLayout.CENTER);

        about_close.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        about_close.setText("Close");
        about_close.addActionListener((java.awt.event.ActionEvent evt) -> {
            about_closeActionPerformed(evt);
        });

        javax.swing.GroupLayout about_footerLayout = new javax.swing.GroupLayout(about_footer);
        about_footer.setLayout(about_footerLayout);
        about_footerLayout.setHorizontalGroup(
                about_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, about_footerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(about_close, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
        );
        about_footerLayout.setVerticalGroup(
                about_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(about_footerLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(about_close, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(about_footer, java.awt.BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    private void about_closeActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void about_pictureMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Juklab/mergano").toURI());
        } catch (URISyntaxException | IOException e) {
        }
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authenticate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new About().setVisible(true);
    }

}
