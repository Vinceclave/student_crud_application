import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeletePanel extends JPanel implements ActionListener, MouseListener {
    public UserAuthenticationFrame parentFrame;
    private AccountFrame accFrame;
    FontManager fontManager = new FontManager();
    private Font headingFont = fontManager.getHeadingFont();
    private Font textFont = fontManager.getTextFont();
    private JPanel searchPanel, accountsPanel, accountPanel;
    private JLabel createLabel, firstNameLabel, lastNameLabel, ageLabel, courseLabel, yearLabel, addressLabel, genderLabel;
    public JTextField firstNameTextField, lastNameTextField, ageTextField, yearTextField, addressTextField,courseTextField, genderTextField;

    private JButton editButton, addButton, viewButton;

    public DeletePanel(UserAuthenticationFrame parentFrame, AccountFrame accFrame) {
        this.parentFrame = parentFrame;
        this.accFrame = accFrame;
        this.viewButton = viewButton;

        setOpaque(true);
        setBackground(Color.decode("#fdfffc"));
        setLayout(new GridBagLayout());
        DeleteInitComponents();
        setVisible(true);
    }

    public void DeleteInitComponents() {
        StudentAccount searchedStudent = parentFrame.studentList.searchStudent();
        if (searchedStudent != null) {
            GridBagConstraints firstNameGridBagConstraints = new GridBagConstraints();

            firstNameGridBagConstraints.gridx = 0;
            firstNameGridBagConstraints.gridy = 0;
            firstNameGridBagConstraints.insets = new Insets(0, 20 , 10, 0);
            firstNameLabel = new JLabel("First name: ");
            firstNameLabel.setFont(headingFont.deriveFont(14f));
            add(firstNameLabel, firstNameGridBagConstraints);

            firstNameGridBagConstraints.gridx = 1;
            firstNameGridBagConstraints.gridy = 0;
            firstNameGridBagConstraints.insets = new Insets(0, 20 , 10, 0);
            firstNameTextField = new JTextField();
            firstNameTextField.setBackground(Color.decode("#2f3e46"));
            firstNameTextField.setForeground(Color.decode("#f8f9fa"));
            firstNameTextField.setBorder(null);
            firstNameTextField.setPreferredSize(new Dimension(100, 30));
            firstNameTextField.setPreferredSize(new Dimension(100, 30));
            firstNameTextField.setEnabled(false);
            firstNameTextField.setText(searchedStudent.getFirstName());
            add(firstNameTextField, firstNameGridBagConstraints);

            GridBagConstraints lastNameGridBagConstraints = new GridBagConstraints();

            lastNameGridBagConstraints.gridx = 0;
            lastNameGridBagConstraints.gridy = 1;
            lastNameGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            lastNameLabel = new JLabel("Last name: ");
            lastNameLabel.setFont(headingFont.deriveFont(14f));
            add(lastNameLabel, lastNameGridBagConstraints);

            lastNameGridBagConstraints.gridx = 1;
            lastNameGridBagConstraints.gridy = 1;
            lastNameGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            lastNameTextField = new JTextField();
            lastNameTextField.setBackground(Color.decode("#2f3e46"));
            lastNameTextField.setForeground(Color.decode("#f8f9fa"));
            lastNameTextField.setBorder(null);
            lastNameTextField.setPreferredSize(new Dimension(100, 30));
            lastNameTextField.setPreferredSize(new Dimension(100, 30));
            lastNameTextField.setEnabled(false);
            lastNameTextField.setText(searchedStudent.getLastName());

            add(lastNameTextField, lastNameGridBagConstraints);

            GridBagConstraints ageGridBagConstraints = new GridBagConstraints();

            ageGridBagConstraints.gridx = 0;
            ageGridBagConstraints.gridy = 2;
            ageGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            ageLabel = new JLabel("Age: ");
            ageLabel.setFont(headingFont.deriveFont(14f));
            add(ageLabel, ageGridBagConstraints);

            ageGridBagConstraints.gridx = 1;
            ageGridBagConstraints.gridy = 2;
            ageGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            ageTextField = new JTextField();
            ageTextField.setBackground(Color.decode("#2f3e46"));
            ageTextField.setForeground(Color.decode("#f8f9fa"));
            ageTextField.setBorder(null);
            ageTextField.setPreferredSize(new Dimension(100, 30));
            ageTextField.setPreferredSize(new Dimension(100, 30));
            ageTextField.setEnabled(false);
            ageTextField.setText(searchedStudent.getAge());

            add(ageTextField, ageGridBagConstraints);

            GridBagConstraints yearGridBagConstraints = new GridBagConstraints();

            yearGridBagConstraints.gridx = 0;
            yearGridBagConstraints.gridy = 3;
            yearGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            yearLabel = new JLabel("Year: ");
            yearLabel.setFont(headingFont.deriveFont(14f));
            add(yearLabel, yearGridBagConstraints);

            yearGridBagConstraints.gridx = 1;
            yearGridBagConstraints.gridy = 3;
            yearGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            yearTextField = new JTextField();
            yearTextField.setBackground(Color.decode("#2f3e46"));
            yearTextField.setForeground(Color.decode("#f8f9fa"));
            yearTextField.setBorder(null);
            yearTextField.setPreferredSize(new Dimension(100, 30));
            yearTextField.setPreferredSize(new Dimension(100, 30));
            yearTextField.setEnabled(false);
            yearTextField.setText(searchedStudent.getYear());

            add(yearTextField, yearGridBagConstraints);

            GridBagConstraints courseGridBagConstraints = new GridBagConstraints();
            courseGridBagConstraints.gridx = 0;
            courseGridBagConstraints.gridy = 4;
            courseGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            courseLabel = new JLabel("Course: ");
            courseLabel.setFont(headingFont.deriveFont(14f));
            add(courseLabel, courseGridBagConstraints);

            courseGridBagConstraints.gridx = 1;
            courseGridBagConstraints.gridy = 4;
            courseGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            courseTextField = new JTextField();
            courseTextField.setBackground(Color.decode("#2f3e46"));
            courseTextField.setForeground(Color.decode("#f8f9fa"));
            courseTextField.setBorder(null);
            courseTextField.setPreferredSize(new Dimension(100, 30));
            courseTextField.setPreferredSize(new Dimension(100, 30));
            courseTextField.setEnabled(false);
            courseTextField.setText(searchedStudent.getCourse());

            add(courseTextField, courseGridBagConstraints);

            GridBagConstraints addressGridBagConstraints = new GridBagConstraints();

            addressGridBagConstraints.gridx = 0;
            addressGridBagConstraints.gridy = 5;
            addressGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            addressLabel = new JLabel("Address: ");
            addressLabel.setFont(headingFont.deriveFont(14f));
            add(addressLabel, addressGridBagConstraints);

            addressGridBagConstraints.gridx = 1;
            addressGridBagConstraints.gridy = 5;
            addressGridBagConstraints.insets = new Insets(0, 20, 10, 0);
            addressTextField = new JTextField();
            addressTextField.setBackground(Color.decode("#2f3e46"));
            addressTextField.setForeground(Color.decode("#f8f9fa"));
            addressTextField.setBorder(null);
            addressTextField.setPreferredSize(new Dimension(100, 30));
            addressTextField.setPreferredSize(new Dimension(100, 30));
            addressTextField.setEnabled(false);
            addressTextField.setText(searchedStudent.getAddress());


            add(addressTextField, addressGridBagConstraints);

            GridBagConstraints genderGridBagConstraints = new GridBagConstraints();

            genderGridBagConstraints.gridx = 0;
            genderGridBagConstraints.gridy = 6;
            genderGridBagConstraints.insets = new Insets(0, 20, 20, 0);
            genderLabel = new JLabel("Gender: ");
            genderLabel.setFont(headingFont.deriveFont(14f));
            add(genderLabel, genderGridBagConstraints);

            genderGridBagConstraints.gridx = 1;
            genderGridBagConstraints.gridy = 6;
            genderGridBagConstraints.insets = new Insets(0, 20, 20, 0);
            genderTextField = new JTextField();
            genderTextField.setBackground(Color.decode("#2f3e46"));
            genderTextField.setForeground(Color.decode("#f8f9fa"));
            genderTextField.setBorder(null);
            genderTextField.setPreferredSize(new Dimension(100, 30));
            genderTextField.setPreferredSize(new Dimension(100, 30));
            genderTextField.setEnabled(false);
            genderTextField.setText(searchedStudent.getGender());


            add(genderTextField, genderGridBagConstraints);

            GridBagConstraints editButtonGridBagConstraints = new GridBagConstraints();
            editButtonGridBagConstraints.gridx = 0;
            editButtonGridBagConstraints.gridy = 7;
            editButtonGridBagConstraints.insets = new Insets(0, 15, 20, 0);
            editButtonGridBagConstraints.anchor = GridBagConstraints.CENTER;

            editButton = new JButton("Edit");
            editButton.setPreferredSize(new Dimension(100, 30));
            editButton.setContentAreaFilled(false);
            editButton.setBorderPainted(false);
            editButton.setFocusPainted(false);
            editButton.setOpaque(true);


            editButton.addActionListener(this);
            editButton.setForeground(Color.decode("#FFFFFF"));
            editButton.setBackground(Color.decode("#2f3e46"));
            add(editButton, editButtonGridBagConstraints);


            GridBagConstraints addButtonGridBagConstraints = new GridBagConstraints();
            addButtonGridBagConstraints.gridx = 1;
            addButtonGridBagConstraints.gridy = 7;
            addButtonGridBagConstraints.anchor = GridBagConstraints.CENTER;
            addButtonGridBagConstraints.insets = new Insets(0, 15, 20, 0);

            addButton = new JButton("Save");
            addButton.setPreferredSize(new Dimension(100, 30));
            addButton.setContentAreaFilled(false);
            addButton.setBorderPainted(false);
            addButton.setFocusPainted(false);
            addButton.setOpaque(true);

            addButton.addActionListener(this);
            addButton.setForeground(Color.decode("#FFFFFF"));
            addButton.setBackground(Color.decode("#2f3e46"));
            add(addButton, addButtonGridBagConstraints);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton) {
            textFieldEnabled();
        }

        if (e.getSource() == addButton) {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String year = yearTextField.getText();
            String age = ageTextField.getText();
            String address = addressTextField.getText();
            String course = courseTextField.getText();
            String gender = genderTextField.getText();

            if(firstName.isEmpty() ||
                    lastName.isEmpty()  ||
                    age.isEmpty()       ||
                    course.isEmpty()    ||
                    age.isEmpty()      ||
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
                int ageInt = Integer.parseInt(age);
                int yearInt = Integer.parseInt(year);

                if (ageInt < 0 || ageInt > 150) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid age (between 0 and 150).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                switch(yearInt) {
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

            parentFrame.studentList.editAccount(firstName, lastName, age, gender, year, course, address);

            setVisible(false);

            // Show success message
            String message = "Account successfully Edited.";
            JOptionPane.showMessageDialog(null, message, "Registration Success", JOptionPane.INFORMATION_MESSAGE);

            // Show the innerMainCenterPanel
            accFrame.innerMainCenterPanel.setVisible(true);

            accFrame.messageLabel.setVisible(true);
            accFrame.messageLabel.setText("Student detail has been updated! Student No: " + parentFrame.studentList.searchStudent().getStudentIDNo()    );
            accFrame.mainPanel.remove(this);

            // Hide the create account panel
            setVisible(false);

            accFrame.mainPanel.add(accFrame.innerMainCenterPanel, BorderLayout.CENTER);

            // Revalidate and repaint the main panel
            accFrame.mainPanel.revalidate();
            accFrame.mainPanel.repaint();
            accFrame.viewButton.setEnabled(true);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void textFieldEnabled() {
        firstNameTextField.setEnabled(true);
        lastNameTextField.setEnabled(true);
        yearTextField.setEnabled(true);
        ageTextField.setEnabled(true);
        courseTextField.setEnabled(true);
        yearTextField.setEnabled(true);
        addressTextField.setEnabled(true);
        genderTextField.setEnabled(true);
    }
}
