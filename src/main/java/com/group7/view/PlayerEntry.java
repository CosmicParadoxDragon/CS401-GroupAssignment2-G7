package com.group7.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static java.lang.System.exit;

public class PlayerEntry {

    ViewController thisView;
    //panel elements
    private JTextArea taWelcome;
    private JTextField tfPlayerName;
    private JButton btnPlayerInfoSubmit;
    private JLabel lblPlayerName;
    private JPanel panelPlayerEntry;
    private JButton btnGithubLink;
    private JButton btnQuit;
    private JLabel lblImageBanner;

    public PlayerEntry(ViewController inThisView){

        thisView = inThisView;

        //taWelcome.setLineWrap(true);
        //taWelcome.setWrapStyleWord(true);

        lblImageBanner.setIcon(new ImageIcon("src/main/java/com/group7/view/images/earthGameBannerth.png"));
        btnPlayerInfoSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                thisView.sfx.acknowledge();
                thisView.setWindowTitle(tfPlayerName.getText());
                thisView.controller.getWaiter().countDown();

            }
        });

        btnGithubLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://github.com/CosmicParadoxDragon/CS401-GroupAssignment2-G7").toURI());
                } catch (Exception g) {
                    g.printStackTrace();
                }
            }
        });
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });
    }

    public JPanel getPanel(){
        return (panelPlayerEntry);
    }
}


