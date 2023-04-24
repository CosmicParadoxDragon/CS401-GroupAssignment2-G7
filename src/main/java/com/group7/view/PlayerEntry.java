package com.group7.view;

import com.group7.view.sfx.sfxController;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PlayerEntry {

    //panel elements
    private JTextArea taWelcome;
    private JTextField tfPlayerName;
    private JButton btnPlayerInfoSubmit;
    private JLabel lblPlayerName;
    private JPanel panelPlayerEntry;
    private JCheckBox checkboxPlaceholder1;
    private JCheckBox checkboxPlaceholder2;
    private JRadioButton radiobuttonPlaceholder1;
    private JRadioButton radiobuttonPlaceholder2;

    public PlayerEntry(ViewController thisView){

        taWelcome.setLineWrap(true);
        taWelcome.setWrapStyleWord(true);
        btnPlayerInfoSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                thisView.sfx.acknowledge();
                thisView.setWindowTitle(tfPlayerName.getText());
                thisView.drawGameHome();
            }
        });

    }

    public JPanel getPanel(){
        return (panelPlayerEntry);
    }

    /* dumb.
    public static JPanel getPanel(ViewController inThisView){
        //PlayerEntry retPlayerEntry = new PlayerEntry(inThisView);
        return (retPlayerEntry.panelPlayerEntry);
    }
    */
}


