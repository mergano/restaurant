package com.kiyoshi.core;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Website {

    public void openWebsite(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (URISyntaxException | IOException e) {
            System.out.println(e);
        }
    }
}
