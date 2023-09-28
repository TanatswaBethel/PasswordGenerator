package passwordGeneratorAndSecurity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGenerator extends JFrame {

    private PasswordGenBackend passwordGenBackend;
    private String password;
    private String name;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PasswordGenerator() {
        super("Password Generator");
        setSize(540, 570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenBackend = new PasswordGenBackend();

        addGuiComponents();

    }


    protected void addGuiComponents() {

        this.setPassword(password);

        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setForeground(Color.PINK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 39);
        add(titleLabel);


        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));


        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 73);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.PINK));
        setPassword(String.valueOf(add(passwordOutputPane)));

        JLabel passwordLengthLabel = new JLabel("Password Length:");
        passwordLengthLabel.setFont(new Font("Dialog", Font.BOLD, 28));
        passwordLengthLabel.setForeground(Color.PINK);
        passwordLengthLabel.setBounds(25, 220, 272, 39);
        add(passwordLengthLabel);

        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialogue", Font.BOLD, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.PINK));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        add(passwordLengthInputArea);

        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialogue", Font.BOLD, 26));
        uppercaseToggle.setBorder(BorderFactory.createLineBorder(Color.PINK));
        uppercaseToggle.setForeground(Color.PINK);
        uppercaseToggle.setBounds(25, 302, 225, 56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialogue", Font.BOLD, 26));
        lowercaseToggle.setBorder(BorderFactory.createLineBorder(Color.PINK));
        lowercaseToggle.setForeground(Color.PINK);
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialogue", Font.BOLD, 26));
        numbersToggle.setBorder(BorderFactory.createLineBorder(Color.PINK));
        numbersToggle.setForeground(Color.PINK);
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialogue", Font.BOLD, 26));
        symbolsToggle.setBorder(BorderFactory.createLineBorder(Color.PINK));
        symbolsToggle.setForeground(Color.PINK);
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialogue", Font.BOLD, 26));
        generateButton.setBorder(BorderFactory.createLineBorder(Color.PINK));
        generateButton.setForeground(Color.pink);
        generateButton.setBounds(155, 477, 225, 56);
        generateButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                if (passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                        uppercaseToggle.isSelected() ||
                        numbersToggle.isSelected() ||
                        symbolsToggle.isSelected();

                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());

                if (anyToggleSelected) {
                    String generatedPassword = passwordGenBackend.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    passwordOutput.setText(generatedPassword);
                }


            }
        });
        add(generateButton);

    }

}