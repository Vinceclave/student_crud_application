import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateAccountPanel extends JPanel implements ActionListener, MouseListener {
    public StudentAccount student;
    private UserAuthenticationFrame parentFrame;
    private AccountFrame accFrame;
    private StudentAccount studentDetail;
    public LoginPanel loginPanel;

    private  FontManager fontManager = new FontManager();
    private Font headingFont = fontManager.getHeadingFont();
    private Font textFont = fontManager.getTextFont();
    String firstName, lastName, course, address, gender, ageString, yearString;
    private JLabel createLabel, firstNameLabel, lastNameLabel, ageLabel, courseLabel, yearLabel, addressLabel, genderLabel;
    public JTextField firstNameTextField, lastNameTextField, ageTextField, yearTextField, addressTextField,courseTextField, genderTextField;
    private JButton createButton;

    public CreateAccountPanel(UserAuthenticationFrame parentFrame, LoginPanel loginPanel, AccountFrame accFrame) {
        this.parentFrame = parentFrame;
        this.loginPanel = loginPanel;

        this.accFrame = accFrame;
        setLayout(new GridBagLayout());
        CreateAccountInitComponents();
        setOpaque(true);
        setBackground(Color.decode("#fdfffc"));
        setVisible(true);
    }
    public void CreateAccountInitComponents() {
        GridBagConstraints createGridBagConstraints = new GridBagConstraints();

        createGridBagConstraints.gridx = 0;
        createGridBagConstraints.gridy = 0;
        createGridBagConstraints.anchor = GridBagConstraints.CENTER;
        createGridBagConstraints.insets = new Insets(-30, 0, 90, 0);
        createGridBagConstraints.gridwidth = GridBagConstraints.REMAINDER; // set gridwidth to REMAINDER
        createGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        createGridBagConstraints.anchor = GridBagConstraints.CENTER;
        createLabel = new JLabel("Create Student Credential");
        createLabel.setFont(headingFont.deriveFont(21.5f));

        add(createLabel, createGridBagConstraints);

        GridBagConstraints firstNameGridBagConstraints = new GridBagConstraints();

        firstNameGridBagConstraints.gridx = 0;
        firstNameGridBagConstraints.gridy = 1;
        firstNameGridBagConstraints.insets = new Insets(-100, 20 , 5, 0);
        firstNameLabel = new JLabel("First name: ");
        firstNameLabel.setFont(headingFont.deriveFont(14f));
        add(firstNameLabel, firstNameGridBagConstraints);

        firstNameGridBagConstraints.gridx = 1;
        firstNameGridBagConstraints.gridy = 1;
        firstNameGridBagConstraints.insets = new Insets(-100, 20 , 5, 0);
        firstNameTextField = new JTextField();
        firstNameTextField.setBackground(Color.decode("#2f3e46"));
        firstNameTextField.setForeground(Color.decode("#f8f9fa"));
        firstNameTextField.setBorder(null);
        firstNameTextField.setPreferredSize(new Dimension(100, 30));
        firstNameTextField.setPreferredSize(new Dimension(100, 30));
        add(firstNameTextField, firstNameGridBagConstraints);

        GridBagConstraints lastNameGridBagConstraints = new GridBagConstraints();

        lastNameGridBagConstraints.gridx = 0;
        lastNameGridBagConstraints.gridy = 2;
        lastNameGridBagConstraints.insets = new Insets(-25, 20, 10, 0);
        lastNameLabel = new JLabel("Last name: ");
        lastNameLabel.setFont(headingFont.deriveFont(14f));
        add(lastNameLabel, lastNameGridBagConstraints);

        lastNameGridBagConstraints.gridx = 1;
        lastNameGridBagConstraints.gridy = 2;
        lastNameGridBagConstraints.insets = new Insets(-25, 20, 10, 0);
        lastNameTextField = new JTextField();
        lastNameTextField.setBackground(Color.decode("#2f3e46"));
        lastNameTextField.setForeground(Color.decode("#f8f9fa"));
        lastNameTextField.setBorder(null);
        lastNameTextField.setPreferredSize(new Dimension(100, 30));
        lastNameTextField.setPreferredSize(new Dimension(100, 30));
        add(lastNameTextField, lastNameGridBagConstraints);

        GridBagConstraints ageGridBagConstraints = new GridBagConstraints();

        ageGridBagConstraints.gridx = 0;
        ageGridBagConstraints.gridy = 3;
        ageGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        ageLabel = new JLabel("Age: ");
        ageLabel.setFont(headingFont.deriveFont(14f));
        add(ageLabel, ageGridBagConstraints);

        ageGridBagConstraints.gridx = 1;
        ageGridBagConstraints.gridy = 3;
        ageGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        ageTextField = new JTextField();
        ageTextField.setBackground(Color.decode("#2f3e46"));
        ageTextField.setForeground(Color.decode("#f8f9fa"));
        ageTextField.setBorder(null);
        ageTextField.setPreferredSize(new Dimension(100, 30));
        ageTextField.setPreferredSize(new Dimension(100, 30));
        add(ageTextField, ageGridBagConstraints);

        GridBagConstraints yearGridBagConstraints = new GridBagConstraints();

        yearGridBagConstraints.gridx = 0;
        yearGridBagConstraints.gridy = 4;
        yearGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        yearLabel = new JLabel("Year: ");
        yearLabel.setFont(headingFont.deriveFont(14f));
        add(yearLabel, yearGridBagConstraints);

        yearGridBagConstraints.gridx = 1;
        yearGridBagConstraints.gridy = 4;
        yearGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        yearTextField = new JTextField();
        yearTextField.setBackground(Color.decode("#2f3e46"));
        yearTextField.setForeground(Color.decode("#f8f9fa"));
        yearTextField.setBorder(null);
        yearTextField.setPreferredSize(new Dimension(100, 30));
        yearTextField.setPreferredSize(new Dimension(100, 30));
        add(yearTextField, yearGridBagConstraints);

        GridBagConstraints courseGridBagConstraints = new GridBagConstraints();
        courseGridBagConstraints.gridx = 0;
        courseGridBagConstraints.gridy = 5;
        courseGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        courseLabel = new JLabel("Course: ");
        courseLabel.setFont(headingFont.deriveFont(14f));
        add(courseLabel, courseGridBagConstraints);

        courseGridBagConstraints.gridx = 1;
        courseGridBagConstraints.gridy = 5;
        courseGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        courseTextField = new JTextField();
        courseTextField.setBackground(Color.decode("#2f3e46"));
        courseTextField.setForeground(Color.decode("#f8f9fa"));
        courseTextField.setBorder(null);
        courseTextField.setPreferredSize(new Dimension(100, 30));
        courseTextField.setPreferredSize(new Dimension(100, 30));
        add(courseTextField, courseGridBagConstraints);

        GridBagConstraints addressGridBagConstraints = new GridBagConstraints();

        addressGridBagConstraints.gridx = 0;
        addressGridBagConstraints.gridy = 6;
        addressGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        addressLabel = new JLabel("Address: ");
        addressLabel.setFont(headingFont.deriveFont(14f));
        add(addressLabel, addressGridBagConstraints);

        addressGridBagConstraints.gridx = 1;
        addressGridBagConstraints.gridy = 6;
        addressGridBagConstraints.insets = new Insets(0, 20, 10, 0);
        addressTextField = new JTextField();
        addressTextField.setBackground(Color.decode("#2f3e46"));
        addressTextField.setForeground(Color.decode("#f8f9fa"));
        addressTextField.setBorder(null);
        addressTextField.setPreferredSize(new Dimension(100, 30));
        addressTextField.setPreferredSize(new Dimension(100, 30));

        add(addressTextField, addressGridBagConstraints);

        GridBagConstraints genderGridBagConstraints = new GridBagConstraints();

        genderGridBagConstraints.gridx = 0;
        genderGridBagConstraints.gridy = 7;
        genderGridBagConstraints.insets = new Insets(0, 20, 20, 0);
        genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(headingFont.deriveFont(14f));
        add(genderLabel, genderGridBagConstraints);

        genderGridBagConstraints.gridx = 1;
        genderGridBagConstraints.gridy = 7;
        genderGridBagConstraints.insets = new Insets(0, 20, 20, 0);
        genderTextField = new JTextField();
        genderTextField.setBackground(Color.decode("#2f3e46"));
        genderTextField.setForeground(Color.decode("#f8f9fa"));
        genderTextField.setBorder(null);
        genderTextField.setPreferredSize(new Dimension(100, 30));
        genderTextField.setPreferredSize(new Dimension(100, 30));

        add(genderTextField, genderGridBagConstraints);


        GridBagConstraints createButtonGridBagConstraints = new GridBagConstraints();
        createButtonGridBagConstraints.gridx = 0;
        createButtonGridBagConstraints.gridy = 8;
        createButtonGridBagConstraints.anchor = GridBagConstraints.CENTER;
        createButtonGridBagConstraints.gridwidth = 2; // set gridwidth to 3 for centeri		createButton = JButton("Create account");

        createButton = new JButton("Create account");
        createButton.setPreferredSize(new Dimension(230, 30));
        createButton.addActionListener(this);
        createButton.addMouseListener(this);
        createButton.setForeground(Color.decode("#FFFFFF"));
        createButton.setBackground(Color.decode("#2f3e46"));
        add(createButton, createButtonGridBagConstraints);

        buttonConfig();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            firstName = firstNameTextField.getText();
            lastName = lastNameTextField.getText();
            course = courseTextField.getText();
            address = addressTextField.getText();
            gender = genderTextField.getText();
            ageString = ageTextField.getText();
            yearString = yearTextField.getText();

            if(firstName.isEmpty() ||
                    lastName.isEmpty()  ||
                    ageString.isEmpty()       ||
                    course.isEmpty()    ||
                    yearString.isEmpty()      ||
                    address.isEmpty()   ||
                    gender.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!firstName.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null, "First name can only contain letters.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!lastName.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null, "Last name can only contain letters.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!address.matches("^[a-zA-Z0-9\\s]+$")) {
                JOptionPane.showMessageDialog(null, "Address can only contain letters, numbers, and spaces.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int age = Integer.parseInt(ageString);
                int year = Integer.parseInt(yearString);

                if (age < 0 || age > 150) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid age (between 0 and 150).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                switch(year) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Please enter a valid year level (between 1 to 4).", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Age and year must be numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
                JOptionPane.showMessageDialog(null, "Gender must be either 'male' or 'female'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (studentDetail != null &&
                    !studentDetail.getFirstName().isEmpty() &&
                    !studentDetail.getLastName().isEmpty() &&
                    !studentDetail.getAge().isEmpty() &&
                    !studentDetail.getCourse().isEmpty() &&
                    !studentDetail.getAddress().isEmpty() &&
                    !studentDetail.getYear().isEmpty() &&
                    !studentDetail.getGender().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You can't create another account!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // stop execution of actionPerformed method
            }

            for (StudentAccount student : parentFrame.studentList.getStudentList()) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    // The new student data already exists, so display an error message
                    JOptionPane.showMessageDialog(null, "Student data already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    clearFields();
                    return;
                }
            }

            if (parentFrame.studentList.count == parentFrame.studentList.list.length) {
                JOptionPane.showMessageDialog(null, "Cannot add student account. List is full.", "Error", JOptionPane.ERROR_MESSAGE);
                clearFields();
                return;
            }

            parentFrame.student = new StudentAccount(firstName, lastName, ageString, gender, yearString, course, address);
            parentFrame.studentList.addAccount(parentFrame.student);

            System.out.println("Searching for admin with username: " + loginPanel.userNameTextField.getText());
            for (adminAccount account : parentFrame.adminList.getAdminList()) {
                System.out.println("Checking admin with username: " + account.getUserName());
                System.out.println("");
                if (accFrame.userName.equals(account.getUserName())) {
                    System.out.println("Match found for admin with username: " + account.getUserName());

                    accFrame.greetingsLabel.setText("Hello, Admin " + account.getFirstName());
                    accFrame.greetingsLabel.setVisible(true);
                    break; // Exit the loop once a matching admin account is found
                }
            }

// Show success message
            String message = "Account successfully registered.";
            JOptionPane.showMessageDialog(null, message, "Registration Success", JOptionPane.INFORMATION_MESSAGE);

// Show the innerMainCenterPanel
            accFrame.innerMainCenterPanel.setVisible(true);

            accFrame.messageLabel.setVisible(true);
            accFrame.messageLabel.setText("New student recently added! Student No: " + parentFrame.studentList.CurrentStudent().getStudentIDNo());
            accFrame.mainPanel.remove(this);

// Hide the create account panel
            setVisible(false);

            accFrame.mainPanel.add(accFrame.innerMainCenterPanel, BorderLayout.CENTER);

// Clear input fields
            clearFields();

// Revalidate and repaint the main panel
            accFrame.mainPanel.revalidate();
            accFrame.mainPanel.repaint();
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
        if(e.getSource() == createButton) {
            createButton.setBackground(Color.decode("#52796f"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == createButton) {
            createButton.setBackground(Color.decode("#354f52"));
        }
    }

    public void clearFields() {
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        ageTextField.setText("");
        courseTextField.setText("");
        yearTextField.setText("");
        addressTextField.setText("");
        genderTextField.setText("");
    }

    public void buttonConfig() {
        createButton.setContentAreaFilled(false);
        createButton.setBorderPainted(false);
        createButton.setFocusPainted(false);
        createButton.setOpaque(true);
    }
}
