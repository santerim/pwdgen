package pwdgen;

import java.awt.*;
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
//        System.out.println(pg.Generate(15));
//        final JFrame frame = new JFrame();
//        final JOptionPane pane = new JOptionPane();
//        String input = pane.showInputDialog(frame, "Give password length (1-50)", 25);
//        int inputInt = 0;
//
//        try {
//            inputInt = Integer.parseInt(input);
//        } catch (NumberFormatException error) {
//            System.out.println(error);
//        }
//
//        if (inputInt > 0 && inputInt < 50) {
//            String pwd = pg.Generate(inputInt);
//            System.out.println("PWD: " + pwd);
//        }

        JFrame frame = new JFrame("pwdgen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        
        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setMinimumSize(new Dimension(400, 300));
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel labelLengthInfo = new JLabel("Length of password (8-50 characters)");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 95;
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.weightx = 0.9;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(labelLengthInfo, gbc);
        
        JTextField inputTextField = new JTextField(2);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(inputTextField, gbc);
        
        JButton genButton = new JButton("Generate");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 15, 0);
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(genButton, gbc);
        
        JLabel outputTextField = new JLabel(" ", SwingConstants.CENTER);
//        outputTextField.setBounds(new Rectangle(0, 0, 500, 10));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
//        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(outputTextField, gbc);
        
        genButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String pwd = "";
                try{
                    int length = Integer.parseInt(inputTextField.getText());
                    if(length < 1) {
                        outputTextField.setText("Fill in the desired password length");
                    }
                    if(length > 0 && length < 51) {
                        pwd = pg.Generate(length);

                        outputTextField.setText(pwd);
                    } else {
                        outputTextField.setText("Password length too long");
                    }
                }
                catch (NumberFormatException error) {
                    outputTextField.setText("Number format error");
                }
                catch (NullPointerException error) {
                    
                }
                
            }
        });

        frame.add(panel);
//        frame.pack();
        frame.setVisible(true);
        
        

//        System.exit(0);
    }

}
