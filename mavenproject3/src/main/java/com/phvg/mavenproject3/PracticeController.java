/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.phvg.mavenproject3;

import com.phvg.pojo.Category;
import com.phvg.pojo.Level;
import com.phvg.pojo.QuestionQueryBuilder;
import com.phvg.pojo.Questions;
import com.phvg.services.questions.QuestionServiceDecorator;
import com.phvg.utils.Configs;
import com.phvg.utils.MyAlertSingleton;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {

    @FXML
    private ComboBox<Category> cbSearchCates;
    @FXML
    private ComboBox<Level> cbSearchLevels;
    @FXML
    private TextField txtNum;
     @FXML
    private Label lblContent;
      @FXML
    private VBox vChoices;
    List<Questions> questions;
    private int currentInd=-1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
              this.cbSearchCates.setItems(FXCollections.observableList(Configs.cateServices.getCates()));
            this.cbSearchLevels.setItems(FXCollections.observableList(Configs.lvlServices.getLevels()));

        } catch (SQLException ex) {

        }
    }

    public void start(ActionEvent e) throws SQLException {
          QuestionQueryBuilder query = new QuestionQueryBuilder()
                .withCategory(this.cbSearchCates.getSelectionModel().getSelectedItem())
                .withLevel(this.cbSearchLevels.getSelectionModel().getSelectedItem())
                .setOrderBy(" rand() ")
                .setLimit(this.txtNum.getText());

          Configs.questionServices.setQuery(query);
          
        try {
            this.questions= new QuestionServiceDecorator(Configs.questionServices).getQuestions();
            this.showQuestion(1);
        } catch (SQLException ex) {
            Logger.getLogger(PracticeController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
          
    }
    public void next(ActionEvent e){
        this.showQuestion(1);
    }
    public void previous(ActionEvent e){
        this.showQuestion(-1);
    }
    public void checkAnswer(ActionEvent e){
        Questions q=this.questions.get(this.currentInd);
        for(int i=0;i<this.vChoices.getChildren().size();i++){
            RadioButton r= (RadioButton)this.vChoices.getChildren().get(i);
            if(r.isSelected()){
                 if(q.getChoices().get(i).isCorrect()==true)
                     MyAlertSingleton.getInstance().showMsg("Chinh xac !",Alert.AlertType.CONFIRMATION);
                 else
                     MyAlertSingleton.getInstance().showMsg("Sai roi ! ",Alert.AlertType.ERROR);
                 break;
            }
        }
    }
    private void showQuestion(int step){
        this.currentInd+=step;
        if(this.currentInd>=0&&this.currentInd<this.questions.size()){
            Questions q=this.questions.get(this.currentInd);
            this.lblContent.setText(q.getContent());
            
            this.vChoices.getChildren().clear();
            ToggleGroup t =new ToggleGroup();
            for(var c: q.getChoices()){
                RadioButton r=new RadioButton(c.getContent());
                r.setToggleGroup(t);
                this.vChoices.getChildren().add(r);
            }
            
        }
    }
}
