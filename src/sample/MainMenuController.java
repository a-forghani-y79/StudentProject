package sample;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {


    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtID;
    public TextField txtUnitL3;
    public TextField txtUnitL2;
    public TextField txtUnitL1;
    public TextField txtGradeL1;
    public TextField txtGradeL2;
    public TextField txtGradeL3;
    public JFXCheckBox chBoxMale;
    public JFXCheckBox chBoxFemale;

    private boolean flagChkBox = true;

    public static DataCenter[] students = new DataCenter[100];
    public static int i = 0;

    public void onClickFirstLesson(){
        PDFWriter.main(new String[]{"1"});
    }
    public void onClickSecondLesson(){
        PDFWriter.main(new String[]{"2"});
    }
    public void onClickThirdLesson(){
        PDFWriter.main(new String[]{"3"});
    }
    public void onClickTopStudents(){
        String[] str ={"4",String.valueOf(getFirstNumber())};
        PDFWriter.main(str);
    }
    public void onClickThirdRate(){
        String[] str = {"5",String.valueOf(getThirdNumber())};
        PDFWriter.main(str);
    }
    public void onClickConditionalStidents(){
        PDFWriter.main(new String[]{"6"});
    }


    public void onClickSubmit() {
        String gender = chBoxMale.isSelected() ? "Male" : "Female";
        students[i] = new DataCenter(txtFirstName.getText(), txtLastName.getText(), txtID.getText(), gender, Double.parseDouble(txtGradeL1.getText()), Double.parseDouble(txtGradeL2.getText()), Double.parseDouble(txtGradeL3.getText()), Integer.parseInt(txtUnitL1.getText()), Integer.parseInt(txtUnitL2.getText()), Integer.parseInt(txtUnitL3.getText()));
        i++;
        sortStudents();
        clear();

    }


    public int getSumAllUnits() {
        int sum = 0;
        for (int j = i; j > -1; j--)
            sum += students[i].getSumUnits();
        return sum;
    }

    public double getSumAllGrades() {
        double sum = 0;
        for (int k = i; k > -1; k--)
            sum += students[k].getSumGrades();
        return sum;
    }

    public void onClickReset() {
        clear();
        txtUnitL1.clear();
        txtUnitL2.clear();
        txtUnitL3.clear();

    }

    void clear() {
        txtGradeL1.clear();
        txtGradeL2.clear();
        txtGradeL3.clear();

        txtLastName.clear();
        txtFirstName.clear();

        txtID.clear();

    }


    public void onClickChkBox(ActionEvent actionEvent) {
        JFXCheckBox chkBox = (JFXCheckBox) actionEvent.getSource();
        System.out.println(chkBox.isSelected());
        System.out.println(chkBox.getId());

        if (chkBox.getId().equals("chBoxMale")) {
            chBoxFemale.setDisable(flagChkBox);
            flagChkBox = !flagChkBox;
        } else {
            chBoxMale.setDisable(flagChkBox);
            flagChkBox = !flagChkBox;
        }
    }


    public void sortStudents() {
        DataCenter temp;

        for (int l = 0; l < i; l++)
            for (int m = l + 1; m < i; m++)
                if (students[l].getLastName().compareTo(students[m].getLastName()) > 0) {
                    temp = students[l];
                    students[l] = students[m];
                    students[m] = temp;
                }


    }

    double getThirdNumber() {
        double[] avreges = new double[i];
        for (int h = 0; h < i; h++)
            avreges[h] = students[h].getAvrege();

        double first = avreges[0], second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i = 1; i < avreges.length; i++) {
            /* If current element is greater than first,
        then update first, second and third */
            if (avreges[i] > first) {
                third = second;
                second = first;
                first = avreges[i];
            } /* If arr[i] is in between first and second */ else if (avreges[i] > second) {
                third = second;
                second = avreges[i];
            } /* If arr[i] is in between second and third */ else if (avreges[i] > third) {
                third = avreges[i];
            }
        }
        return third;
    }

    double getFirstNumber() {
        double[] d = new double[i];
        for (int h = 0; h < i; h++)
            d[h] = students[h].getAvrege();
        double max = d[0];
        for (int i = 1; i < d.length; i++)
            if (d[i] > max)
                max = d[i];

        return max;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
