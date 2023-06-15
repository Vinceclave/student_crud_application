import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewPanel extends JPanel implements ActionListener, MouseListener {
    public boolean panelExists = false;
    public StudentGradesPanel studentGradeFrame;

    UserAuthenticationFrame parentFrame;
    public int search;
    public DeletePanel deletePanel;
    FontManager fontManager = new FontManager();
    private Font headingFont = fontManager.getHeadingFont();
    private Font textFont = fontManager.getTextFont();
    private AccountFrame accFrame;
    private JLabel accountID;
    public JPanel buttonsPanel, searchPanel, accountsPanel, accountPanel;
    public JTextField searchTextField;
    private JButton searchButton, viewGradesButton, deleteButton, viewButton;
    private JComboBox<String> AccountChoices;

    public ViewPanel(UserAuthenticationFrame parentFrame, AccountFrame accFrame, JButton viewButton) {
        this.accFrame = accFrame;
        this.viewButton = viewButton;
        this.parentFrame = parentFrame;

        setLayout(new BorderLayout());
        ViewInitComponents();
        setOpaque(false);
        setVisible(true);
    }

    public void	ViewInitComponents() {

        searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        searchPanel.setOpaque(false);

        searchTextField = new JTextField(8);
        searchTextField.setPreferredSize(new Dimension(200, 30));
        searchTextField.setBorder(null);
        searchTextField.setForeground(Color.decode("#f8f9fa"));
        searchTextField.setBackground(Color.decode("#2f3e46"));
        searchTextField.setMargin(new Insets(5, 10, 5, 10));
        searchPanel.add(searchTextField);


        searchButton = new JButton("search");
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(this);
        searchButton.addMouseListener(this);
        searchButton.setOpaque(true);
        searchButton.setFont(headingFont.deriveFont(14f));
        searchButton.setForeground(Color.decode("#FFFFFF"));
        searchButton.setBackground(Color.decode("#2f3e46"));
        searchPanel.add(searchButton);

        accountPanel = new JPanel(new BorderLayout());
        accountPanel.setBackground(Color.decode("#000"));
        accountPanel.setOpaque(false);
        accountPanel.setVisible(true);

        AccountChoices = new JComboBox<>(new String[]{"Admin", "Student"});
        AccountChoices.setBackground(Color.decode("#2f3e46"));
        AccountChoices.setForeground(Color.decode("#FFFFFF"));
        AccountChoices.addActionListener(this);
        AccountChoices.setFont(headingFont.deriveFont(15f)); // importing font
        UIManager.put("AccountChoices.buttonBackground", Color.decode("#2f3e46"));
        AccountChoices.setPreferredSize(new Dimension(100, 30));

        searchPanel.add(AccountChoices);

        add(searchPanel, BorderLayout.NORTH);
        add(accountPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            try {
                search = Integer.parseInt(searchTextField.getText());
                parentFrame.studentList.setSearchID(search);

                // Search for the student
                StudentAccount searchedStudent = parentFrame.studentList.searchStudent();

                if (searchedStudent != null) {
                    // Display the student information
                    if (!panelExists) {
                        accountsPanel = new JPanel(new BorderLayout(10, 10));
                        accountsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        accountID = new JLabel(searchedStudent.getStudentIDNo() + ": " + searchedStudent.getFirstName() + " " + searchedStudent.getLastName());
                        accountID.setFont(headingFont.deriveFont(14f));
                        accountID.setForeground(Color.decode("#2f3e46"));

                        accountsPanel.setBackground(Color.decode("#cad2c5"));
                        accountsPanel.setPreferredSize(new Dimension(accFrame.mainPanel.getWidth(), 50));
                        accountsPanel.add(accountID, BorderLayout.WEST);
                        accountsPanel.setVisible(true);

                        buttonsPanel = new JPanel(new FlowLayout());
                        buttonsPanel.setOpaque(false);

                        viewGradesButton = new JButton("Grades");
                        viewGradesButton.setContentAreaFilled(false);
                        viewGradesButton.setBorderPainted(false);
                        viewGradesButton.setFocusPainted(false);
                        viewGradesButton.addActionListener(this);
                        viewGradesButton.addMouseListener(this);
                        viewGradesButton.setOpaque(true);
                        viewGradesButton.setFont(headingFont.deriveFont(10f));
                        viewGradesButton.setPreferredSize(new Dimension(70, 25));
                        viewGradesButton.setForeground(Color.decode("#FFFFFF"));
                        viewGradesButton.setBackground(Color.decode("#2f3e46"));
                        viewGradesButton.setAlignmentX(JButton.CENTER_ALIGNMENT); // Center the text horizontally
                        viewGradesButton.setAlignmentY(JButton.CENTER_ALIGNMENT); // Center the text vertically
                        buttonsPanel.add(viewGradesButton);

                        viewButton = new JButton("View");
                        viewButton.setContentAreaFilled(false);
                        viewButton.setBorderPainted(false);
                        viewButton.setFocusPainted(false);
                        viewButton.addActionListener(this);
                        viewButton.addMouseListener(this);
                        viewButton.setOpaque(true);
                        viewButton.setFont(headingFont.deriveFont(11f));
                        viewButton.setPreferredSize(new Dimension(70, 25));
                        viewButton.setForeground(Color.decode("#FFFFFF"));
                        viewButton.setBackground(Color.decode("#2f3e46"));
                        viewButton.setAlignmentX(JButton.CENTER_ALIGNMENT); // Center the text horizontally
                        viewButton.setAlignmentY(JButton.CENTER_ALIGNMENT); // Center the text vertically
                        buttonsPanel.add(viewButton);

                        deleteButton = new JButton("delete");
                        deleteButton.setContentAreaFilled(false);
                        deleteButton.setBorderPainted(false);
                        deleteButton.setFocusPainted(false);
                        deleteButton.addActionListener(this);
                        deleteButton.addMouseListener(this);
                        deleteButton.setOpaque(true);
                        deleteButton.setFont(headingFont.deriveFont(11f));
                        deleteButton.setPreferredSize(new Dimension(70, 25));
                        deleteButton.setForeground(Color.decode("#FFFFFF"));
                        deleteButton.setBackground(Color.decode("#2f3e46"));
                        deleteButton.setAlignmentX(JButton.CENTER_ALIGNMENT); // Center the text horizontally
                        deleteButton.setAlignmentY(JButton.CENTER_ALIGNMENT); // Center the text vertically
                        buttonsPanel.add(deleteButton);

                        accountsPanel.add(buttonsPanel, BorderLayout.EAST);
                        accountPanel.add(accountsPanel, BorderLayout.NORTH);
                        accountPanel.setVisible(true);
                        accountPanel.revalidate();
                        accountPanel.repaint();
                        panelExists = true;
                    } else {
                        // Update the existing panel with new information
                        accountID.setText(searchedStudent.getStudentIDNo() + ": " + searchedStudent.getFirstName() + " " + searchedStudent.getLastName());
                        accountPanel.setVisible(true);
                        deletePanel.setVisible(false);
                    }
                } else {
                    // Student not found, display an error message
                    JOptionPane.showMessageDialog(null, "Student not found.");
                }
            } catch (NumberFormatException ex) {
                // Create a DefaultTableModel with the student data and column names
                showStudentTable();
            } catch (Exception ex) {
                // Other exceptions, display an error message
            }

            if (deletePanel == null) {
                // handle the null case here
            } else {
               deletePanel.setVisible(false);
            }
        }

        if (e.getSource() == viewButton) {
            deletePanel = new DeletePanel(parentFrame, accFrame);

            System.out.println("view button clicked");
            accFrame.setTitle("Edit Student Detail");
            accFrame.greetingsLabel.setText("Edit Student Detail");
            searchPanel.setVisible(false);
            deletePanel = new DeletePanel(parentFrame,  accFrame);
            accountPanel.remove(accountsPanel);
            panelExists = false;
            // accountsPanel.setVisible(false);
            accountPanel.add(deletePanel, BorderLayout.CENTER);
            searchPanel.setVisible(false);
            deletePanel.setVisible(true);

            accountPanel.revalidate();
            accountPanel.repaint();
            accFrame.mainPanel.revalidate();
            accFrame.mainPanel.repaint();
            accFrame.viewButton.setEnabled(true);

        }
        if (e.getSource() == viewGradesButton) {

            int searchNum = Integer.parseInt(searchTextField.getText());
            if (searchNum == parentFrame.studentList.getSearchID()) {
                boolean hasZeroGrades = false;

                for (StudentAccount student : parentFrame.studentList.getStudentList()) {
                    if (student.getMathGrade() == 0 && student.getEnglishGrade() == 0 && student.getComProgGrade() == 0) {
                        hasZeroGrades = true;
                        break; // Exit the loop as soon as a student with 0 grades is found
                    }
                }

                if (hasZeroGrades) {
                    int choice = JOptionPane.showOptionDialog(
                            this,
                            "Grades are not available for this student. Do you want to continue?",
                            "Confirmation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            new String[]{"Yes", "No"},
                            "No"
                    );

                    if (choice == JOptionPane.YES_OPTION) {
                        studentGradeFrame = new StudentGradesPanel(parentFrame, this);
                        studentGradeFrame.editGradeButton.setEnabled(false);
                    }
                } else {
                    studentGradeFrame = new StudentGradesPanel(parentFrame, this);

                    int studentID = parentFrame.studentList.getSearchID();
                    studentGradeFrame.disabledTextFields();


                    for (StudentAccount student : parentFrame.studentList.getStudentList()) {
                        if (studentID == student.getStudentIDNo()) {
                            studentGradeFrame.englishGradeTextField.setText(String.valueOf(student.getEnglishGrade()));
                            studentGradeFrame.mathGradeTextField.setText(String.valueOf(student.getMathGrade()));
                            studentGradeFrame.programmingGradeTextField.setText(String.valueOf(student.getComProgGrade()));

                            studentGradeFrame.averageGradeLabel = new JLabel();
                            studentGradeFrame.averageGradeLabel.setText(student.getAverageGrade());
                            studentGradeFrame.averageGradeLabel.setFont(headingFont.deriveFont(21f));
                            studentGradeFrame.averageGradeLabel.setAlignmentX(FlowLayout.RIGHT);
                            studentGradeFrame.averageGradeLabel.setBackground(Color.decode("#2f3e46"));
                            studentGradeFrame.averageGradeLabel.setForeground(Color.decode("#FFFFFF"));
                            studentGradeFrame.averageGradeLabel.setBorder(new EmptyBorder(15, 15, 15, 15));
                            studentGradeFrame.add(studentGradeFrame.averageGradeLabel, BorderLayout.SOUTH);

                        }
                    }
                }
            }
        }

        if (e.getSource() == deleteButton) {
            System.out.println("delete button clicked");
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student's account details?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(null, "Student account details successfully deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);

                accFrame.innerMainCenterPanel.setVisible(true);

                accFrame.messageLabel.setVisible(true);
                accFrame.messageLabel.setText("New student recently deleted! Student No: " + parentFrame.studentList.searchStudent().getStudentIDNo());
                parentFrame.studentList.deleteAccount();
                accFrame.mainPanel.remove(this);

                // Revalidate and repaint the main panel
                accFrame.mainPanel.revalidate();
                accFrame.mainPanel.repaint();
                accFrame.viewButton.setEnabled(true);

                // Hide the create account panel
                setVisible(false);

                accFrame.mainPanel.add(accFrame.innerMainCenterPanel, BorderLayout.CENTER);

                // Remove the account panel from the delete panel
                accountPanel.remove(accountsPanel);
                accountPanel.revalidate();
                accountPanel.repaint();

                // Reset the delete panel
                searchTextField.setText("");
                panelExists = false;

                // Re-enable the view button in the account frame
                viewButton.setEnabled(true);
            }
        }

        if (e.getSource() == AccountChoices) {
            if (AccountChoices.getSelectedItem() == "Admin") {
                System.out.println("Admin");
                ShowAdminTable();

            }

            if (AccountChoices.getSelectedItem() == "Student") {
                System.out.println("Student");
                showStudentTable();
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
        if(e.getSource() == searchButton) {
            searchButton.setBackground(Color.decode("#52796f"));
        }

        if(e.getSource() == viewButton) {
            viewButton.setBackground(Color.decode("#52796f"));
        }

        if(e.getSource() == deleteButton) {
            deleteButton.setBackground(Color.decode("#52796f"));
        }

        if (e.getSource() == viewGradesButton) {
            viewGradesButton.setBackground(Color.decode("#52796f"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == searchButton) {
            searchButton.setBackground(Color.decode("#354f52"));
        }

        if(e.getSource() == viewButton) {
            viewButton.setBackground(Color.decode("#354f52"));
        }

        if(e.getSource() == deleteButton) {
            deleteButton.setBackground(Color.decode("#354f52"));
        }
        if (e.getSource() == viewGradesButton) {
            viewGradesButton.setBackground(Color.decode("#354f52"));
        }
    }

    public void showStudentTable() {
        StudentAccount[] studentList = parentFrame.studentList.getStudentList();
        String[] columnNames = {"ID", "First Name", "Last Name", "Age", "Gender", "Year", "Course", "Address"};
        Object[][] data = new Object[studentList.length][parentFrame.studentList.getStudentAccountSize()];
        for (int i = 0; i < studentList.length; i++) {
            data[i][0] = studentList[i].getStudentIDNo();
            data[i][1] = studentList[i].getFirstName();
            data[i][2] = studentList[i].getLastName();
            data[i][3] = studentList[i].getAge();
            data[i][4] = studentList[i].getGender();
            data[i][5] = studentList[i].getYear();
            data[i][6] = studentList[i].getCourse();
            data[i][7] = studentList[i].getAddress();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // disable editing of all cells
            }
        };

// Create a JTable with the non-editable DefaultTableModel
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setReorderingAllowed(false); // disable column reordering

// Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

// Display the table in a dialog
        JOptionPane.showMessageDialog(null, scrollPane, "Student List", JOptionPane.PLAIN_MESSAGE);

    }
    public void ShowAdminTable() {
        adminAccount[] adminList = parentFrame.adminList.getAdminList();
        String[] columnNames = {"ID", "Username", "Password", "First Name", "Last Name"};
        Object[][] data = new Object[adminList.length][parentFrame.adminList.getAdminAccountSize()];
        for (int i = 0; i < adminList.length; i++) {
            data[i][1] = adminList[i].getUserName();
            data[i][2] = adminList[i].getPassWord();
            data[i][3] = adminList[i].getFirstName();
            data[i][4] = adminList[i].getLastName();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // disable editing of all cells
            }
        };

// Create a JTable with the non-editable DefaultTableModel
        JTable table = new JTable(model);

// Set the preferred width of each column
        table.getColumnModel().getColumn(0).setPreferredWidth(50); // ID column
        table.getColumnModel().getColumn(1).setPreferredWidth(100); // Username column
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Password column
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // First Name column
        table.getColumnModel().getColumn(4).setPreferredWidth(100); // Last Name column

// Set the auto resize mode to off
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

// Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

// Display the table in a dialog
        JOptionPane.showMessageDialog(null, scrollPane, "Admin List", JOptionPane.PLAIN_MESSAGE);

    }
}
