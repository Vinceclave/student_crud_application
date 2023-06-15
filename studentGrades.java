public class studentGrades {
    private double mathGrade, englishGrade, comProgGrade;
    public studentGrades() {
        this.mathGrade = 0;
        this.englishGrade = 0;
        this.comProgGrade = 0;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public void setEnglishGrade(double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public void setComProgGrade(double comProgGrade) {
        this.comProgGrade = comProgGrade;
    }
    public double getMathGrade() {
        return mathGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public double getComProgGrade() {
        return comProgGrade;
    }

    public String toString() {
        return "Math Grade: " + mathGrade + "\n" +
                "English Grade: " + englishGrade + "\n" +
                "Computer Programming: " + comProgGrade;
    }

    public double gradesAverage() {
        return (getMathGrade() + getEnglishGrade() + getComProgGrade()) / 3.0;
    }
    public String gradeAverage() {
        double totalGrades = (getMathGrade() + getEnglishGrade() + getComProgGrade()) / 3.0;

        int grade = 0;
        if (totalGrades >= 1 && totalGrades < 2) {
            grade = 1; // Very Good
        } else if (totalGrades >= 2 && totalGrades < 3) {
            grade = 2; // Good
        } else {
            grade = 3; // Failed
        }

        String gradeText;
        switch (grade) {
            case 1:
                gradeText = "Very Good";
                break;
            case 2:
                gradeText = "Good";
                break;
            case 3:
                gradeText = "Failed";
                break;
            default:
                gradeText = "Unknown";
                break;
        }

        return gradeText;
    }

}
