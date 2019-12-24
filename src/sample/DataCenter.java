package sample;

public class DataCenter {

    DataCenter(String firstName, String lastName, String id, String gender, double gradeLesson1, double gradeLesson2, double gradeLesson3, int unitLesson1, int unitLesson2, int unitLesson3) {
        FirstName = firstName;
        LastName = lastName;
        ID = id;
        Gender = gender;
        Grades[0] = gradeLesson1;
        Grades[1] = gradeLesson2;
        Grades[2] = gradeLesson3;
        Units[0] = unitLesson1;
        Units[1] = unitLesson2;
        Units[2] = unitLesson3;
    }


    private String FirstName;
    private String LastName;
    private String ID;
    private String Gender;

    private double[] Grades = new double[]{0, 0, 0};
    private int[] Units = new int[]{0, 0, 0};


    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getGender() {
        return Gender;
    }


    public String getID() {
        return ID;
    }

    public double[] getGrades() {
        return Grades;
    }

    public double getSumGrades() {
        return Grades[0] + Grades[1] + Grades[2];
    }

    public int[] getUnits() {
        return Units;
    }

    public int getSumUnits() {
        return Units[0] + Units[1] + Units[2];
    }


    public double getAvrege(){
        double avreg=0;
        int sumU=getSumUnits();
        avreg = (Grades[0]*Units[0]+Grades[1]*Units[1]+Grades[2]*Units[2])/sumU;
        return avreg;
    }

    public int getNameLengh(){
        int length =( getLastName().length()+1+getFirstName().length());
        return length;
    }
}
