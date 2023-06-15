import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudentGradesPanel extends JFrame implements ActionListener, MouseListener {
    public UserAuthenticationFrame parentFrame;
    FontManager fontManager = new FontManager();

    public ViewPanel viewPanel;
    private Font headingFont = fontManager.getHeadingFont();
    private Font textFont = fontManager.getTextFont();

    private JPanel StudentGradePanel, GradePanel;
    public JLabel StudentGradeLabel, mathGradeLabel, englishGradeLabel, programmingGradeLabel, averageGradeLabel;
    public JTextField mathGradeTextField, englishGradeTextField, programmingGradeTextField;
    public JButton editGradeButton, submitGradeButton;


    public StudentGradesPanel(UserAuthenticationFrame parentFrame, ViewPanel viewPanel) {
        this.parentFrame = parentFrame;
        this.viewPanel = viewPanel;
        getContentPane().setBackground(Color.decode("#2f3e46"));
        setSize(300, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        StudentGradesComponents();

        setVisible(true);
    }

    public void StudentGradesComponents() {
        StudentGradePanel = new JPanel(new BorderLayout());
        StudentGradePanel.setBackground(Color.decode("#2f3e46"));
        StudentGradeLabel = new JLabel("Student Grades");
        StudentGradeLabel.setFont(headingFont.deriveFont(21f));
        StudentGradeLabel.setAlignmentX(FlowLayout.LEFT);
        StudentGradeLabel.setForeground(Color.decode("#FFFFFF"));
        StudentGradeLabel.setBorder(new EmptyBorder(15, 15, 15, 15));


        StudentGradePanel.add(StudentGradeLabel, BorderLayout.NORTH);

        GradePanel = new JPanel(new GridBagLayout());
        GradePanel.setBackground(Color.decode("#FFFFFF"));

        mathGradeLabel = new JLabel("Math: ");
        mathGradeLabel.setFont(headingFont.deriveFont(16f));
        GridBagConstraints gridConstraintsMathLabel = new GridBagConstraints();
        gridConstraintsMathLabel.gridx = 0;
        gridConstraintsMathLabel.gridy = 0;
        gridConstraintsMathLabel.insets = new Insets(10, -50, 10, 10); // Padding/margin
        GradePanel.add(mathGradeLabel, gridConstraintsMathLabel);


        mathGradeTextField = new JTextField();
        mathGradeTextField.setPreferredSize(new Dimension(40, 30));
        mathGradeTextField.setBackground(Color.decode("#2f3e46"));
        mathGradeTextField.setForeground(Color.decode("#f8f9fa"));
        mathGradeTextField.setBorder(null);

        GridBagConstraints gridConstraintsMathTextField = new GridBagConstraints();
        gridConstraintsMathTextField.gridx = 1;
        gridConstraintsMathTextField.gridy = 0;
        gridConstraintsMathTextField.insets = new Insets(10, 10, 10, 10); // Padding/margin

        GradePanel.add(mathGradeTextField, gridConstraintsMathTextField);


        englishGradeLabel = new JLabel("English: ");
        englishGradeLabel.setFont(headingFont.deriveFont(16f));

        GridBagConstraints gridConstraintsEnglishLabel = new GridBagConstraints();
        gridConstraintsEnglishLabel.gridx = 0;
        gridConstraintsEnglishLabel.gridy = 1;
        gridConstraintsEnglishLabel.insets = new Insets(10, -40, 10, 10); // Padding/margin
        GradePanel.add(englishGradeLabel, gridConstraintsEnglishLabel);

        englishGradeTextField = new JTextField();
        englishGradeTextField.setPreferredSize(new Dimension(40, 30));
        englishGradeTextField.setBackground(Color.decode("#2f3e46"));
        englishGradeTextField.setForeground(Color.decode("#f8f9fa"));
        englishGradeTextField.setBorder(null);

        GridBagConstraints gridConstraintsEnglishTextField = new GridBagConstraints();
        gridConstraintsEnglishTextField.gridx = 1;
        gridConstraintsEnglishTextField.gridy = 1;
        gridConstraintsEnglishTextField.insets = new Insets(10, 10, 10, 10); // Padding/margin
        GradePanel.add(englishGradeTextField, gridConstraintsEnglishTextField);


        programmingGradeLabel = new JLabel("Programming: ");
        programmingGradeLabel.setFont(headingFont.deriveFont(16f));
        GridBagConstraints gridConstraintsProgrammingLabel = new GridBagConstraints();
        gridConstraintsProgrammingLabel.gridx = 0;
        gridConstraintsProgrammingLabel.gridy = 2;
        gridConstraintsProgrammingLabel.insets = new Insets(10, 10, 10, 10); // Padding/margin
        GradePanel.add(programmingGradeLabel, gridConstraintsProgrammingLabel);

        programmingGradeTextField = new JTextField();
        programmingGradeTextField.setPreferredSize(new Dimension(40, 30));
        programmingGradeTextField.setBackground(Color.decode("#2f3e46"));
        programmingGradeTextField.setForeground(Color.decode("#f8f9fa"));
        programmingGradeTextField.setBorder(null);

        GridBagConstraints gridConstraintsProgrammingTextField = new GridBagConstraints();
        gridConstraintsProgrammingTextField.gridx = 1;
        gridConstraintsProgrammingTextField.gridy = 2;
        gridConstraintsProgrammingTextField.insets = new Insets(10, 10, 10, 10); // Padding/margin
        GradePanel.add(programmingGradeTextField, gridConstraintsProgrammingTextField);

        editGradeButton = new JButton("Edit Grade");
        editGradeButton.addActionListener(this);
        editGradeButton.addMouseListener(this);
        editGradeButton.setBackground(Color.decode("#2f3e46"));
        editGradeButton.setForeground(Color.decode("#FFFFFF"));
        editGradeButton.setPreferredSize(new Dimension(100, 30));
        editGradeButton.setContentAreaFilled(false);
        editGradeButton.setBorderPainted(false);
        editGradeButton.setFocusPainted(false);
        editGradeButton.setOpaque(true);
        GridBagConstraints gridConstraintsEditGradeButton = new GridBagConstraints();
        gridConstraintsEditGradeButton.gridx = 0;
        gridConstraintsEditGradeButton.gridy = 3;
        gridConstraintsEditGradeButton.anchor = GridBagConstraints.CENTER;
        gridConstraintsEditGradeButton.insets = new Insets(10, -15, 10, 10); // Padding/margin

        GradePanel.add(editGradeButton, gridConstraintsEditGradeButton);

        submitGradeButton = new JButton("Save Grade");
        submitGradeButton.addActionListener(this);
        submitGradeButton.addMouseListener(this);
        submitGradeButton.setForeground(Color.decode("#FFFFFF"));
        submitGradeButton.setBackground(Color.decode("#2f3e46"));
        submitGradeButton.setPreferredSize(new Dimension(100, 30));
        submitGradeButton.setContentAreaFilled(false);
        submitGradeButton.setBorderPainted(false);
        submitGradeButton.setFocusPainted(false);
        submitGradeButton.setOpaque(true);

        GridBagConstraints gridConstraintsSubmitGradeButton = new GridBagConstraints();
        gridConstraintsSubmitGradeButton.gridx = 1;
        gridConstraintsSubmitGradeButton.gridy = 3;
        gridConstraintsSubmitGradeButton.anchor = GridBagConstraints.CENTER;
        gridConstraintsSubmitGradeButton.insets = new Insets(10, -20, 10, 10); // Padding/margin
        GradePanel.add(submitGradeButton, gridConstraintsSubmitGradeButton);

        StudentGradePanel.add(GradePanel, BorderLayout.CENTER);

        add(StudentGradePanel);

        repaint();
        revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editGradeButton) {
            System.out.println("Edit Clicked");
            enabledTextFields();
            int studentID = parentFrame.studentList.getSearchID();

            for (StudentAccount student : parentFrame.studentList.getStudentList()) {
                if (studentID == student.getStudentIDNo()) {
                    System.out.println(student.getAverageGrade());
                }
            }
        }

        if (e.getSource() == submitGradeButton) {
            System.out.println("Submit Clicked");

            int studentID = parentFrame.studentList.getSearchID();

            String mathGradeText = mathGradeTextField.getText();
            String engGradeText = englishGradeTextField.getText();
            String progGradeText = programmingGradeTextField.getText();

            if (mathGradeText.isEmpty() || engGradeText.isEmpty() || progGradeText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter grades for all subjects.");
                return;
            }

            try {
                double mathGrade = Double.parseDouble(mathGradeText);
                double engGrade = Double.parseDouble(engGradeText);
                double progGrade = Double.parseDouble(progGradeText);

                for (StudentAccount student : parentFrame.studentList.getStudentList()) {
                    if (studentID == student.getStudentIDNo()) {
                        student.setGrades(mathGrade, engGrade, progGrade);
                        dispose();

                        JOptionPane.showMessageDialog(this, "Grades have been saved successfully for the student.");
                        break;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric grades.");
            }
        }

    }

    public void disabledTextFields() {
        mathGradeTextField.setEnabled(false);
        englishGradeTextField.setEnabled(false);
        programmingGradeTextField.setEnabled(false);
    }

    public void enabledTextFields() {
        mathGradeTextField.setEnabled(true);
        englishGradeTextField.setEnabled(true);
        programmingGradeTextField.setEnabled(true);
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
        if(e.getSource() == editGradeButton) {
            editGradeButton.setBackground(Color.decode("#52796f"));
        }

        if(e.getSource() == submitGradeButton) {
            submitGradeButton.setBackground(Color.decode("#52796f"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == editGradeButton) {
            editGradeButton.setBackground(Color.decode("#354f52"));
        }
        if(e.getSource() == submitGradeButton) {
            submitGradeButton.setBackground(Color.decode("#354f52"));
        }
    }
}
