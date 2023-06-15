import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class RegisterPanel extends JPanel implements ActionListener, FocusListener, MouseListener {
    public UserAuthenticationFrame parentFrame;
    private boolean isUsernameValidated = false;
    private boolean isPasswordValidated = false;

    private  adminAccount admin;

    private String firstName, lastName, newUserName, newPassWord;
    Border paddingBorder = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    // font
    private FontManager fontManager = new FontManager();
    private Font headingFont = fontManager.getHeadingFont();
    private Font textFont = fontManager.getTextFont();
    private JPanel registerForm, registerSidePanel;
    private JButton backButton, resetButton, registerButton;
    private JLabel registerText, firstNameLabel, lastNameLabel, userNameLabel, passWordLabel;
    private JTextField firstNameTextField, lastNameTextField, userNameTextField;
    private JPasswordField passWordField;

    public RegisterPanel(UserAuthenticationFrame parentFrame, adminAccount admin) {
        this.parentFrame = parentFrame;
        this.admin = parentFrame.admin;

        setBackground(Color.decode("#15616d"));
        setLayout(new BorderLayout());
        RegisterInitComponents();
        setVisible(true);
        repaint();
        revalidate();
    }

    public void RegisterInitComponents() {
        registerSidePanel = new JPanel(new BorderLayout());
        registerSidePanel.setBackground(Color.decode("#15616d"));
        registerSidePanel.setPreferredSize(new Dimension(265, 500));

        String image = getClass().getResource("/images/back.png").getPath();
        ImageIcon backIcon = new ImageIcon(image);

        // creating a child panel to nest and manipulate the parent panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setOpaque(false);

        backButton = new JButton(backIcon);
        buttonPanel.add(backButton);
        backButton.setPreferredSize(new Dimension(40, 40));
        backButton.addActionListener(this);

        registerSidePanel.add(buttonPanel, BorderLayout.NORTH);
        registerSidePanel.setBackground(Color.decode("#2f3e46"));
        // creating a child panel to nest and manipulate the parent panel
        JPanel registerTextCon = new JPanel(new GridBagLayout());
        registerTextCon.setOpaque(false);

        GridBagConstraints registerTextConstraints = new GridBagConstraints();
        registerTextConstraints.gridx = 0;
        registerTextConstraints.gridy = 0;
        registerTextConstraints.gridwidth = 1;
        registerTextConstraints.anchor = GridBagConstraints.CENTER; // Set to valid constant
        registerTextConstraints.insets = new Insets(0, 0, 20, 0);

        registerText = new JLabel("Create an account");
        registerText.setForeground(Color.decode("#f8f9fa"));
        registerText.setFont(headingFont.deriveFont(21.5f));
        registerTextCon.add(registerText, registerTextConstraints);

        GridBagConstraints loginConstraints = new GridBagConstraints();
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 1;
        loginConstraints.gridwidth = 1;
        loginConstraints.anchor = GridBagConstraints.WEST; // Set to valid constant
        registerSidePanel.add(registerTextCon, BorderLayout.CENTER);


        registerForm = new JPanel(new GridBagLayout());
        registerForm.setBackground(Color.decode("#f8f9fa"));
        registerForm.setPreferredSize(new Dimension(360, parentFrame.initialHeight));


        GridBagConstraints firstNameGridBagConstrains = new GridBagConstraints();
        firstNameGridBagConstrains.gridx = 0;
        firstNameGridBagConstrains.gridy = 0;
        firstNameGridBagConstrains.gridwidth = 1;
        firstNameGridBagConstrains.insets = new Insets(0, 0, 20, 0);

        firstNameLabel = new JLabel("First name: ");
        firstNameLabel.setFont(headingFont.deriveFont(14f));
        firstNameLabel.setForeground(Color.decode("#2f3e46"));
        registerForm.add(firstNameLabel, firstNameGridBagConstrains);

        firstNameGridBagConstrains.gridx = 1;
        firstNameGridBagConstrains.gridy = 0;
        firstNameGridBagConstrains.gridwidth = 1;
        firstNameGridBagConstrains.insets = new Insets(0, 20, 20, 0);

        firstNameTextField = new JTextField(10);
        firstNameTextField.setBorder(paddingBorder);
        firstNameTextField.setBackground(Color.decode("#2f3e46"));
        firstNameTextField.setForeground(Color.decode("#f8f9fa"));
        firstNameTextField.setPreferredSize(new Dimension(100, 30));
        firstNameTextField.setBorder(null);
        registerForm.add(firstNameTextField, firstNameGridBagConstrains);

        GridBagConstraints lastNameGridBagConstrains = new GridBagConstraints();
        lastNameGridBagConstrains.gridx = 0;
        lastNameGridBagConstrains.gridy = 1;
        lastNameGridBagConstrains.insets = new Insets(0, 0, 20, 0);

        lastNameLabel = new JLabel("Last name: ");
        lastNameLabel.setForeground(Color.decode("#2f3e46"));
        lastNameLabel.setFont(headingFont.deriveFont(14f));
        registerForm.add(lastNameLabel, lastNameGridBagConstrains);

        lastNameGridBagConstrains.gridx = 1;
        lastNameGridBagConstrains.gridy = 1;
        lastNameGridBagConstrains.insets = new Insets(0, 20, 20, 0);

        lastNameTextField = new JTextField(10);
        lastNameTextField.setForeground(Color.decode("#f8f9fa"));
        lastNameTextField.setBackground(Color.decode("#2f3e46"));
        lastNameTextField.setPreferredSize(new Dimension(100, 30));
        lastNameTextField.setBorder(null);
        registerForm.add(lastNameTextField, lastNameGridBagConstrains);

        GridBagConstraints userNameGridBagConstrains = new GridBagConstraints();
        userNameGridBagConstrains.gridx = 0;
        userNameGridBagConstrains.gridy = 3;
        userNameGridBagConstrains.insets = new Insets(0, 0, 20, 0);

        userNameLabel = new JLabel("Username: ");
        userNameLabel.setForeground(Color.decode("#2f3e46"));
        userNameLabel.setFont(headingFont.deriveFont(14f));
        registerForm.add(userNameLabel, userNameGridBagConstrains);

        userNameGridBagConstrains.gridx = 1;
        userNameGridBagConstrains.gridy = 3;
        userNameGridBagConstrains.insets = new Insets(0, 20, 20, 0);

        userNameTextField = new JTextField(10);
        userNameTextField.setForeground(Color.decode("#f8f9fa"));
        userNameTextField.setBackground(Color.decode("#2f3e46"));
        userNameTextField.setPreferredSize(new Dimension(100, 30));
        userNameTextField.setBorder(null);
        userNameTextField.addFocusListener(this);
        registerForm.add(userNameTextField, userNameGridBagConstrains);

        GridBagConstraints passWordGridBagConstrains = new GridBagConstraints();
        passWordGridBagConstrains.gridx = 0;
        passWordGridBagConstrains.gridy = 4;
        passWordGridBagConstrains.insets = new Insets(0, 0, 20, 0);
        passWordLabel = new JLabel("Password: ");
        passWordLabel.setFont(headingFont.deriveFont(14f));

        registerForm.add(passWordLabel, passWordGridBagConstrains);

        passWordGridBagConstrains.gridx = 1;
        passWordGridBagConstrains.gridy = 4;
        passWordGridBagConstrains.insets = new Insets(0, 20, 20, 0);
        passWordField = new JPasswordField(10);
        passWordField.addFocusListener(this);
        passWordField.setBackground(Color.decode("#2f3e46"));
        passWordField.setForeground(Color.decode("#f8f9fa"));
        passWordField.setPreferredSize(new Dimension(100, 30));
        passWordField.setBorder(null);
        registerForm.add(passWordField, passWordGridBagConstrains);

        registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(100, 30));
        registerButton.setFont(headingFont.deriveFont(14f));
        registerButton.setBackground(Color.decode("#354f52"));
        registerButton.setForeground(Color.decode("#f8f9fa"));
        registerButton.addMouseListener(this);
        registerButton.addActionListener(this);

        GridBagConstraints registerButtonGridBagConstraints = new GridBagConstraints();
        registerButtonGridBagConstraints.gridx = 0;
        registerButtonGridBagConstraints.gridy= 5;
        registerButtonGridBagConstraints.insets = new Insets(0, 25, 0, 0);
        registerForm.add(registerButton, registerButtonGridBagConstraints);

        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(100, 30));
        resetButton.setFont(headingFont.deriveFont(14f));
        resetButton.addActionListener(this);
        resetButton.addMouseListener(this);
        resetButton.setBackground(Color.decode("#354f52"));
        resetButton.setForeground(Color.decode("#f8f9fa"));

        GridBagConstraints resetButtonGridBagConstraints = new GridBagConstraints();
        resetButtonGridBagConstraints.gridx = 1;
        resetButtonGridBagConstraints.gridy= 5;
        resetButtonGridBagConstraints.insets = new Insets(0, 25, 0, 0);
        registerForm.add(resetButton, resetButtonGridBagConstraints);

        add(registerSidePanel, BorderLayout.WEST);
        add(registerForm, BorderLayout.EAST);

        buttonConfig();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            if (!firstNameTextField.getText().equals("") ||
                !lastNameTextField.getText().equals("") ||
                !userNameTextField.getText().equals("") ||
                !passWordField.getText().equals("")) {

                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back? Any unsaved changes will be discarded.", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    userNameTextField.removeFocusListener(this);
                    passWordField.removeFocusListener(this);

                    setVisible(false);
                    parentFrame.mainPanel.setVisible(true);
                    parentFrame.setTitle("Get Started");
                    parentFrame.setPreferredSize(new Dimension(parentFrame.initialWidth, parentFrame.initialHeight));
                    parentFrame.pack();
                }
            }

            userNameTextField.removeFocusListener(this);
            passWordField.removeFocusListener(this);
            setVisible(false);
            parentFrame.mainPanel.setVisible(true);
            parentFrame.setTitle("Get Started");
            parentFrame.setPreferredSize(new Dimension(parentFrame.initialWidth, parentFrame.initialHeight));
            parentFrame.pack();
        }
        if (e.getSource() == registerButton) {
            try {
                firstName = firstNameTextField.getText();
                lastName = lastNameTextField.getText();
                newUserName = userNameTextField.getText();
                newPassWord = passWordField.getText();

                if (firstName.isEmpty() || lastName.isEmpty() || newUserName.isEmpty() || newPassWord.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // stop execution of actionPerformed method
                }

                if (!isUsernameValidated) {
                    // Don't show password validation message if username field hasn't been validated
                    isUsernameValidated = false;
                    return;
                }

                if (newUserName.length() < 8) {
                    userNameTextField.addFocusListener(this);
                    return;
                } else {
                    isUsernameValidated = true;
                }

                if (newPassWord.length() < 8) {
                    String message = "Password must be at least 8 characters long.";
                    passWordField.requestFocusInWindow();
                    return; // stop execution of actionPerformed method
                }

                for (adminAccount admin : parentFrame.adminList.getAdminList()) {
                    if (admin.getPassWord().equals(newUserName)  ||
                            admin.getUserName().equals(newPassWord)) {
                        JOptionPane.showMessageDialog(null, "Cannot add admin account. An account already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                        clearFields();
                        return;
                    }
                }

                if (parentFrame.adminList.count == parentFrame.adminList.list.length) {
                    JOptionPane.showMessageDialog(null, "Cannot add admin account. List is full.", "Error", JOptionPane.ERROR_MESSAGE);
                    clearFields();
                    return;
                }

                // If all validations pass, add the admin account
                parentFrame.adminList.addAccount(new adminAccount(firstName, lastName, newUserName, newPassWord));

                System.out.println("Admin accounts:");
                adminAccount[] adminArray = parentFrame.adminList.getAdminList();
                for (int i = 0; i < adminArray.length ; i++) {
                    if (adminArray[i] != null && !adminArray[i].toString().isEmpty()) {
                        System.out.println("Admin: " + ( i + 1 ));
                        System.out.println(adminArray[i].toString());
                    } else {
                        System.out.println("Index " + i + " is null.");
                    }
                }
                clearFields();

                JOptionPane.showMessageDialog(null, "Admin account added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                parentFrame.add(parentFrame.loginPanel);
                parentFrame.setSize(300, 500);
                parentFrame.loginPanel.setVisible(true);
                parentFrame.loginPanel.userNameTextField.setText("");
                parentFrame.loginPanel.passwordField.setText("");
                parentFrame.setTitle("Login");
                parentFrame.revalidate();
                parentFrame.repaint();
            } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding admin account: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

        if (e.getSource() == resetButton) {
                clearFields();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == userNameTextField) {
            if (userNameTextField.getText().length() < 8) {
                String message = "Username must be at least 8 characters long.";
                JOptionPane.showMessageDialog(null, message, "Invalid Username", JOptionPane.ERROR_MESSAGE);
                userNameTextField.requestFocusInWindow(); // set focus back to username field
            } else {
                isUsernameValidated = true;
            }
        } else if (e.getSource() == passWordField) {
            if (!isUsernameValidated) {
                // Don't show password validation message if username field hasn't been validated
                isUsernameValidated = false;
                return;
            }

            if (passWordField.getText().length() < 8) {
                String message = "Password must be at least 8 characters long.";
                JOptionPane.showMessageDialog(null, message, "Invalid Password", JOptionPane.ERROR_MESSAGE);
                passWordField.requestFocusInWindow(); // set focus back to password field
            } else {
                isPasswordValidated = true;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == registerButton) {
            registerButton.setBackground(Color.decode("#52796f"));
        }

        if(e.getSource() == resetButton) {
            resetButton.setBackground(Color.decode("#52796f"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == registerButton) {
            registerButton.setBackground(Color.decode("#354f52"));
        }

        if(e.getSource() == resetButton) {
            resetButton.setBackground(Color.decode("#354f52"));
        }
    }

    public void buttonConfig() {
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(true);

        resetButton.setContentAreaFilled(false);
        resetButton.setBorderPainted(false);
        resetButton.setFocusPainted(false);
        resetButton.setOpaque(true);
    }

    public void clearFields() {
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        userNameTextField.setText("");
        passWordField.setText("");
    }
}
