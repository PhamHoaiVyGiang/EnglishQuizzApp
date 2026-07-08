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
import java.io.ObjectInputFilter;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    
    List<Questions> question;

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
          QuestionQueryBuilder query = new QuestionQueryBuilder().withCategory(this.cbSearchCates.getSelectionModel().getSelectedItem())
                .setLimit(this.txtNum.getText())
                 .setOrderBy(" rand() ")
                .withLevel(this.cbSearchLevels.getSelectionModel().getSelectedItem());
          
          Configs.questionServices.setQuery(query);
          
        try {
            this.question= new QuestionServiceDecorator(Configs.questionServices).getQuestions();
            System.out.println("----");
        } catch (SQLException ex) {
            Logger.getLogger(PracticeController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
          
    }
}
