package pwdgen;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Santeri
 */
public class Pwdgen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final PasswordGenerator pg = new PasswordGenerator();

        JFrame frame = new JFrame("pwdgen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 300);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel labelLengthInfo = new JLabel("Length of password (8-50 characters)");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 95;
        gbc.insets = new Insets(15, 15, 15, 0);
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(labelLengthInfo, gbc);
        
        JTextField inputTextField = new JTextField(2);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(inputTextField, gbc);
        
        JButton genButton = new JButton("Generate");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 15, 15);
        gbc.weightx = 0.2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(genButton, gbc);
        
        JLabel outputTextField = new JLabel("No password generated yet", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 0, 10, 0);
        panel.add(outputTextField, gbc);
        
        JButton copyButton = new JButton("Copy");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 0, 15, 0);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.PAGE_END;
        panel.add(copyButton, gbc);
        
        // ActionListener for password generation button
        genButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pwd = "";
                try{
                    int length = Integer.parseInt(inputTextField.getText());
                    System.out.println(length);
                    if(length < 9) {
                        outputTextField.setText("Password too short");
                        inputTextField.setText("");
                    }
                    else if(length > 0 && length < 51) {
                        pwd = pg.Generate(length);
                        outputTextField.setText(pwd);
                    } else {
                        outputTextField.setText("Password length too long");
                        inputTextField.setText("");
                    }
                }
                catch (NumberFormatException error) {
                    outputTextField.setText("Number format error");
                }
                catch (NullPointerException error) {
                    
                }
                
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StringSelection ss = new StringSelection(outputTextField.getText());
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                cb.setContents(ss, null);
                outputTextField.setText("Copied to clipboard");
        }
        });
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        
        

//        System.exit(0);
    }

}
