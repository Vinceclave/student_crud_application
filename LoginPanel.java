import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends  JPanel implements ActionListener, FocusListener, MouseListener {
    public DeletePanel deletePanel;
    private FontManager fontManager = new FontManager();
    private Font headingFont = fontManager.getHeadingFont();
    private Font textFont = fontManager.getTextFont();

    private UserAuthenticationFrame parentFrame;
    public static adminAccount admin;
    private RegisterPanel registerPanel;

    // Login Components
    private JPanel backButtonPanel, loginInputPanel; // component panel
    private JLabel loginTitle, userName, passWord;   // component label
    public  JTextField userNameTextField;            // component textfield
    public  JPasswordField passwordField;            // component passwordfield
    private JButton loginButton, backButton;         // component button

    public LoginPanel(UserAuthenticationFrame parentFrame, adminAccount admin) {
        this.parentFrame = parentFrame;
        this.admin = admin;

        setSize(new Dimension(300, 600));
        setLayout(new BorderLayout());
        setBackground(Color.decode("#2f3e46"));
        LoginInitComponents();
        setVisible(true);
    }

    public void LoginInitComponents() {
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setOpaque(false);

        String image = getClass().getResource("/images/back.png").getPath();
        ImageIcon backIcon = new ImageIcon(image);
        backButton = new JButton(backIcon);
        backButton.addActionListener(this);
        backButton.setPreferredSize(new Dimension(32, 32));
        backButtonPanel.add(backButton);

        loginInputPanel = new JPanel(new GridBagLayout());
        loginInputPanel.setOpaque(false);

        GridBagConstraints loginTitleGridBagConstraints = new GridBagConstraints();
        loginTitleGridBagConstraints.gridx = 0;
        loginTitleGridBagConstraints.gridy = 0;
        loginTitleGridBagConstraints.anchor = GridBagConstraints.CENTER;
        loginTitleGridBagConstraints.insets = new Insets(-60, 0, 40, 0);
        loginTitleGridBagConstraints.gridwidth = GridBagConstraints.REMAINDER; // set gridwidth to REMAINDER
        loginTitleGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        loginTitle = new JLabel("Login");
        loginTitle.setFont(headingFont.deriveFont(40f));
        loginTitle.setForeground(Color.decode("#f8f9fa"));
        loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        loginInputPanel.add(loginTitle, loginTitleGridBagConstraints);

        GridBagConstraints userNameGridBagConstraints = new GridBagConstraints();
        userNameGridBagConstraints.gridx = 0;
        userNameGridBagConstraints.gridy = 1;
        userNameGridBagConstraints.insets = new Insets(0, 0, 20, 0);
        userName = new JLabel("Username: ");
        userName.setForeground(Color.decode("#f8f9fa"));
        userName.setFont(headingFont.deriveFont(14f));
        loginInputPanel.add(userName, userNameGridBagConstraints);

        userNameGridBagConstraints.gridx = 1;
        userNameGridBagConstraints.gridy = 1;
        userNameGridBagConstraints.insets = new Insets(0, 20, 20, 0);

        userNameTextField = new JTextField(8);
        userNameTextField.setPreferredSize(new Dimension(100, 30));
        userNameTextField.setBorder(null);
        userNameTextField.setForeground(Color.decode("#2f3e46"));
        userNameTextField.setBackground(Color.decode("#f8f9fa"));

        loginInputPanel.add(userNameTextField, userNameGridBagConstraints);

        GridBagConstraints passWordGridBagConstraints = new GridBagConstraints();
        passWordGridBagConstraints.gridx = 0;
        passWordGridBagConstraints.gridy = 2;
        passWordGridBagConstraints.insets = new Insets(0, 0, 20, 0);

        passWord = new JLabel("Password: ");
        passWord.setForeground(Color.decode("#f8f9fa"));
        passWord.setFont(headingFont.deriveFont(14f));
        loginInputPanel.add(passWord, passWordGridBagConstraints);

        passWordGridBagConstraints.gridx = 1;
        passWordGridBagConstraints.gridy = 2;
        passWordGridBagConstraints.insets = new Insets(0, 20, 20, 0);

        passwordField = new JPasswordField(8);
        passwordField.setPreferredSize(new Dimension(100, 30));
        passwordField.setBorder(null);
        passwordField.setForeground(Color.decode("#2f3e46"));
        passwordField.setBackground(Color.decode("#f8f9fa"));

        loginInputPanel.add(passwordField, passWordGridBagConstraints);

        GridBagConstraints loginButtonGridBagConstraints = new GridBagConstraints();
        loginButtonGridBagConstraints.gridx = 0;
        loginButtonGridBagConstraints.gridy = 3;
        loginButtonGridBagConstraints.anchor = GridBagConstraints.CENTER;
        loginButtonGridBagConstraints.gridwidth = 2; // set gridwidth to 3 for centering
        loginButtonGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#52796f"));
        loginButton.setForeground(Color.decode("#f8f9fa"));

        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        loginButton.setFont(headingFont.deriveFont(14f));
        loginInputPanel.add(loginButton, loginButtonGridBagConstraints);

        add(backButtonPanel, BorderLayout.NORTH);
        add(loginInputPanel, BorderLayout.CENTER);
        buttonConfig();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
            parentFrame.mainPanel.setVisible(true);
            parentFrame.setTitle("Get Started");
            parentFrame.setPreferredSize(new Dimension(parentFrame.initialWidth, parentFrame.initialHeight));
            parentFrame.pack();
        }

        if (e.getSource() == loginButton) {
            if(userNameTextField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                System.out.println("Blank field");
                JOptionPane.showMessageDialog(LoginPanel.this, "Please input on this field");
            } else {
                boolean found = false;
                for (adminAccount account : parentFrame.adminList.getAdminList()) {
                    if (userNameTextField.getText().equals(account.getUserName()) && passwordField.getText().equals(account.getPassWord())) {
                        found = true;
                        JOptionPane.showMessageDialog(LoginPanel.this, "Success");
                        System.out.println("Successfully logged in");
                          AccountFrame accountFrame = new AccountFrame(parentFrame, this, deletePanel);
                        userNameTextField.setText("");
                        passwordField.setText("");
                        accountFrame.setVisible(true);
                        parentFrame.dispose();
                        break; // Exit the loop once a match is found
                    }
                }
                if (!found) {
                    System.out.println("No match found");
                    JOptionPane.showMessageDialog(LoginPanel.this, "Incorrect username or password");
                }
            }

        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

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
        if(e.getSource() == loginButton) {
            loginButton.setBackground(Color.decode("#52796f"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == loginButton) {
            loginButton.setBackground(Color.decode("#354f52"));
        }
    }

    public void buttonConfig() {
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setOpaque(true);
    }
}
