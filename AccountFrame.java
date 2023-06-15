    import javax.swing.*;
    import javax.swing.text.View;
    import java.awt.*;
    import java.awt.event.*;

    public class AccountFrame  extends JFrame implements ActionListener, MouseListener {
        public DeletePanel deletePanel;
        public String userName;

        public ViewPanel viewPanel;

        static StudentAccountList studentDetail;
        public StudentAccount[] studentList;
        private CreateAccountPanel createPanel;
        private boolean createPanelAdded = false;
        public  UserAuthenticationFrame parentFrame;

        public LoginPanel loginPanel;
        FontManager fontManager = new FontManager();
        private Font headingFont = fontManager.getHeadingFont();
        private Font textFont = fontManager.getTextFont();
        public JPanel sidePanel, mainPanel, innerMainPanel, innerMainCenterPanel , topMainPanel;
        public JLabel adminWelcomeText, greetingsLabel, messageLabel;
        public JButton createButton, viewButton, logoutButton;
        public AccountFrame(UserAuthenticationFrame parentFrame, LoginPanel loginPanel, DeletePanel deletePanel) {
            this.parentFrame = parentFrame;
            this.loginPanel = loginPanel;
            this.createPanel = new CreateAccountPanel(parentFrame, loginPanel, this);
            this.deletePanel = deletePanel;

            viewPanel = new ViewPanel(parentFrame,this, viewButton);
            ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.png"));
            Image logoImage = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            setIconImage(logo.getImage());

            setLayout(new BorderLayout());
            setSize(parentFrame.expandedWidth, parentFrame.expandedHeight);
            setResizable(false);
            setLocationRelativeTo(null);
            AccountFrameInitComponent();
            setTitle("Admin");
            repaint();
            revalidate();
        }

        public void AccountFrameInitComponent() {
            sidePanel = new JPanel();
            sidePanel.setLayout(new GridLayout(2, 1, 0, 0));
            sidePanel.setPreferredSize(new Dimension(150, parentFrame.expandedHeight));
            sidePanel.setOpaque(false);

            createButton = new JButton("Create");
            createButton.setFont(headingFont.deriveFont(21.5f));
            createButton.addActionListener(this);
            createButton.setForeground(Color.decode("#FFFFFF"));
            createButton.setBackground(Color.decode("#2f3e46"));
            createButton.setPreferredSize(new Dimension(200, parentFrame.expandedHeight));
            sidePanel.add(createButton);

            viewButton = new JButton("View");
            viewButton.setFont(headingFont.deriveFont(21.5f));
            viewButton.addActionListener(this);
            viewButton.setSize(200, parentFrame.expandedHeight);
            viewButton.setForeground(Color.decode("#FFFFFF"));
            viewButton.setBackground(Color.decode("#2f3e46"));
            sidePanel.add(viewButton);

            mainPanel = new JPanel(new BorderLayout());
            mainPanel.setOpaque(true);
            mainPanel.setBackground(Color.decode("#FFFFFF"));

            topMainPanel = new JPanel(new BorderLayout(10, 10));
            topMainPanel.setOpaque(false);
            topMainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel greetingsPanel = new JPanel();
            for (adminAccount account : parentFrame.adminList.getAdminList()) {
                if (loginPanel.userNameTextField.getText().equals(account.getUserName())) {
                    userName = account.getUserName();
                    greetingsLabel = new JLabel("Hello, Admin " + account.getFirstName());
                }
            }
            greetingsLabel.setFont(headingFont.deriveFont(15f));
            greetingsPanel.add(greetingsLabel);
            greetingsPanel.setOpaque(false);
            topMainPanel.add(greetingsPanel, BorderLayout.WEST);

            JPanel logoutPanel = new JPanel();
            logoutPanel.setOpaque(false);
            logoutButton = new JButton("Logout");

            logoutButton.setPreferredSize(new Dimension(100, 30));
            logoutButton.addActionListener(this);
            logoutButton.addMouseListener(this);
            logoutButton.setFont(headingFont.deriveFont(14f));
            logoutButton.setForeground(Color.decode("#FFFFFF"));
            logoutButton.setBackground(Color.decode("#2f3e46"));
            topMainPanel.add(logoutButton, BorderLayout.EAST);


            innerMainPanel = new JPanel();
            innerMainCenterPanel = new JPanel();
            innerMainCenterPanel.setOpaque(false);
            innerMainCenterPanel.setBackground(Color.decode("#FFFFFF"));

            messageLabel = new JLabel();
            messageLabel.setFont(textFont.deriveFont(18f));
            messageLabel.setForeground(Color.decode("#2f3e46"));
            messageLabel.setVisible(false);
            innerMainCenterPanel.add(messageLabel);

            mainPanel.add(topMainPanel, BorderLayout.NORTH);
            mainPanel.add(innerMainCenterPanel, BorderLayout.CENTER);

            add(sidePanel, BorderLayout.WEST);
            add(mainPanel, BorderLayout.CENTER);
            buttonConfig();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logoutButton) {
                System.out.println("Log out");
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to log out?", "Confirm Logout",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (confirmed == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    parentFrame.setVisible(true);
                    parentFrame.loginPanel.userNameTextField.setText("");
                    parentFrame.loginPanel.passwordField.setText("");
                }
            }
            if (e.getSource() == createButton) {
                System.out.println("Create");
                setTitle("Create Student Account");
                innerMainCenterPanel.setVisible(false);
                createPanelAdded = false;
                createPanel.setVisible(true);
                viewButton.setEnabled(true);
                viewPanel.setVisible(false);
                viewPanel.searchTextField.setText("");
                greetingsLabel.setText("Create");
                System.out.println("DELETE IS NULL");

                mainPanel.remove(innerMainCenterPanel);
                mainPanel.add(createPanel, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
            if (e.getSource() == viewButton) {
                System.out.println("View");

                if(parentFrame.studentList == null || parentFrame.studentList.list == null || parentFrame.studentList.count == 0) {
                    JOptionPane.showMessageDialog(null, "No student detail available", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // stop execution of actionPerformed method
                }

                clearFields();
                    viewPanel.searchTextField.setText("");
                viewButton.setEnabled(true);
                viewButton.setEnabled(true);
                innerMainCenterPanel.setVisible(false);
                createPanel.setVisible(false);
                greetingsLabel.setText("Student Detail");
                setTitle("View Student");

                mainPanel.remove(innerMainCenterPanel);
                mainPanel.add(viewPanel, BorderLayout.CENTER);
                viewPanel.setVisible(true);
                viewPanel.searchPanel.setVisible(true);
                viewPanel.accountPanel.setVisible(false);
                mainPanel.revalidate();
                mainPanel.repaint();
                viewButton.setEnabled(false);

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
            if(e.getSource() == logoutButton) {
                logoutButton.setBackground(Color.decode("#52796f"));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == logoutButton) {
                logoutButton.setBackground(Color.decode("#354f52"));
            }
        }

        public void buttonConfig() {
            createButton.setContentAreaFilled(false);
            createButton.setBorderPainted(false);
            createButton.setOpaque(true);

            viewButton.setContentAreaFilled(false);
            viewButton.setBorderPainted(false);
            viewButton.setOpaque(true);
            viewButton.setEnabled(true);

            logoutButton.setContentAreaFilled(false);
            logoutButton.setBorderPainted(false);
            logoutButton.setFocusPainted(false);
            logoutButton.setOpaque(true);
        }

        public void clearFields() {
            createPanel.firstNameTextField.setText("");
            createPanel.lastNameTextField.setText("");
            createPanel.ageTextField.setText("");
            createPanel.addressTextField.setText("");
            createPanel.genderTextField.setText("");
            createPanel.genderTextField.setText("");
            createPanel.yearTextField.setText("");
            createPanel.courseTextField.setText("");
        }
    }
