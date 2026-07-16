/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.phvg.mavenproject3;

import com.phvg.pojo.Questions;
import com.phvg.services.exam.ExamStrategy;
import com.phvg.services.exam.ExamTypes;
import com.phvg.services.exam.FixedExam;
import com.phvg.services.exam.SpecificExam;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ExamController implements Initializable {

    @FXML
    private ComboBox<ExamTypes> cbExamTypes;
    @FXML
    private TextField txtNum;
    @FXML
    private ListView<Questions> lvlQuestions;
    private List<Questions> questions;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbExamTypes.setItems((FXCollections.observableArrayList(ExamTypes.values())));
    }

    public void start(ActionEvent e) {
        switch (this.cbExamTypes.getSelectionModel().getSelectedItem()) {
            case SPECIFIC:
                ExamStrategy s = new SpecificExam(this.txtNum.getText());
                this.questions = s.getQuestions();
                break;
            default:
                ExamStrategy s1 = new FixedExam();

                this.questions = s1.getQuestions();

        }
        this.lvlQuestions.setItems(FXCollections.observableList(this.questions));
    }

}
