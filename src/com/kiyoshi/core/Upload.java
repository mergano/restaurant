/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.core;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author vchuk
 */
public class Upload {

    public void uploadImage(String filename) {

        String SFTPHOST = "128.199.117.93";
        int SFTPPORT = 22;
        String SFTPUSER = "juk";
        String SFTPPASS = "Serio.ome*1181+";
        String SFTPWORKINGDIR = "/var/kiyoshi/";
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);

            File f1 = new File("com/kiyoshi/data/foods/test.jpg");
            channelSftp.put(new FileInputStream(f1), f1.getName());
            channelSftp.exit();
            session.disconnect();
        } catch (JSchException | SftpException | FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
