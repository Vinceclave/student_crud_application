import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserAuthenticationFrame extends JFrame implements ActionListener, MouseListener {
    public adminAccount admin;
    public StudentAccount student;
    public adminAccountList adminList = new adminAccountList();
    public StudentAccountList studentList = new StudentAccountList();
    public LoginPanel loginPanel;
    private FontManager fontManager = new FontManager();
    private Font headingFont = fontManager.getHeadingFont();
    private Font textFont = fontManager.getTextFont();
    public JPanel mainPanel;
    private JButton registerButton, loginButton;
    private JLabel mainTitle, mainIcon;
    public int initialWidth = 300; // initial width of the JFrame
    public int initialHeight = 500; // initial height of the JFrame
    public int expandedWidth = 600; // expanded width of the JFrame
    public int expandedHeight = 500; // expanded height of the JFrame


    public UserAuthenticationFrame() {
        loginPanel = new LoginPanel(this, admin);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image logoImage = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(logo.getImage());
        setTitle("Get Started");
        setSize(initialWidth, initialHeight);
        setLocationRelativeTo(null);
        setResizable(false);

        // Initialize the components of the JFrame
        UserInitComponents();
        // Set the JFrame to be visible
        setVisible(true);
    }

    public void UserInitComponents() {
        // Initialize the main panel and its components
        mainPanel = new JPanel(new GridBagLayout());

        // Set the main panel background color
        mainPanel.setBackground(Color.decode("#2f3e46"));


        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 1;
        titleConstraints.gridwidth = 1;
        titleConstraints.anchor = GridBagConstraints.CENTER;
        titleConstraints.insets = new Insets(10, 0, 10, 0);

        // Create the main title label and set its font and color
        mainTitle = new JLabel("Get Started");
        mainTitle.setFont(headingFont.deriveFont(32f)); // importing font
        mainTitle.setForeground(Color.decode("#f8f9fa"));
        // Add the main title label to the main panel
        mainPanel.add(mainTitle, titleConstraints);

        // Create a GridBagConstraints object for the main icon label
        GridBagConstraints iconConstraints = new GridBagConstraints();
        iconConstraints.gridx = 0;
        iconConstraints.gridy = 0;
        iconConstraints.gridwidth = 1;
        iconConstraints.anchor = GridBagConstraints.CENTER;
        iconConstraints.insets = new Insets(10, 0, 10, 0);

        // Import the image and add it to the main icon label
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/user.png")); // importing image
        Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        // Set the scaled icon as the icon for the main icon label
        mainIcon = new JLabel(scaledIcon);
        mainPanel.add(mainIcon, iconConstraints);

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        // Create a GridBagConstraints object for the register button
        GridBagConstraints registerButtonConstraints = new GridBagConstraints();
        registerButtonConstraints.gridx = 0;
        registerButtonConstraints.gridy = 2;
        registerButtonConstraints.gridwidth = 1;
        registerButtonConstraints.anchor = GridBagConstraints.CENTER;
        registerButtonConstraints.insets = new Insets(10, 0, 10, 0);

        // Create the register button and set its font and color
        registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(100, 30));
        registerButton.setBackground(Color.decode("#354f52"));
        registerButton.setForeground(Color.decode("#f8f9fa"));
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.addActionListener(this);
        registerButton.addMouseListener(this);
        // imported font
        registerButton.setFont(headingFont.deriveFont(14f));

        // Add the register button to the main panel
        mainPanel.add(registerButton, registerButtonConstraints);

        // Create a GridBagConstraints object for the login button
        GridBagConstraints loginButtonConstraints = new GridBagConstraints();
        loginButtonConstraints.gridx = 0;
        loginButtonConstraints.gridy = 3;
        loginButtonConstraints.gridwidth = 1;
        loginButtonConstraints.anchor = GridBagConstraints.CENTER;
        loginButtonConstraints.insets = new Insets(10, 0, 10, 0);

        // Create the login button and set its font and color
        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.setBackground(Color.decode("#354f52"));
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        loginButton.setForeground(Color.decode("#f8f9fa"));
        loginButton.setFont(headingFont.deriveFont(14f));
        mainPanel.add(loginButton, loginButtonConstraints);

        add(mainPanel);
        buttonConfig();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            if(adminList.getAdminList() == null || adminList.getAdminList().length == 0) {
                mainPanel.setVisible(false);
                RegisterPanel registerPanel = new RegisterPanel(UserAuthenticationFrame.this, admin);
                setTitle("Create an account");
                setSize(expandedWidth, expandedHeight);
                loginPanel.setVisible(false);
                add(registerPanel);
                System.out.print(true);
            } else {
                System.out.println("Admin list is not null or empty.");
                mainPanel.setVisible(false);
                LoginPanel loginPanel = new LoginPanel(UserAuthenticationFrame.this, admin);
                setSize(initialWidth, initialHeight);
                setTitle("Log in");
                add(loginPanel);
            }
        }

        if(e.getSource() == registerButton) {
            mainPanel.setVisible(false);
            RegisterPanel registerPanel = new RegisterPanel(UserAuthenticationFrame.this, admin);
            setTitle("Create an account");
            setSize(expandedWidth, expandedHeight);

            add(registerPanel);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // nothing to do
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // nothing to do

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // nothing to do

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == registerButton) {
            registerButton.setBackground(Color.decode("#52796f"));
        }

        if(e.getSource() == loginButton) {
            loginButton.setBackground(Color.decode("#52796f"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == registerButton) {
            registerButton.setBackground(Color.decode("#354f52"));
        }

        if(e.getSource() == loginButton) {
            loginButton.setBackground(Color.decode("#354f52"));
        }
    }

    public void buttonConfig() {
        // removing the static design of button
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(true);

        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(true);
        loginButton.setFocusPainted(false);
    }

}
