/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.phvg.mavenproject3;

import com.phvg.pojo.Category;
import com.phvg.pojo.Questions;
import com.phvg.services.CategoryServices;
import com.phvg.services.QuestionsServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    @FXML private TableView<Questions> tvQuestions;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoryServices s=new CategoryServices();
        QuestionsServices s2= new QuestionsServices();
        this.loadColumns();
        
        try {
            this.cbCates.setItems(FXCollections.observableList(s.getCates()));
            this.tvQuestions.setItems(FXCollections.observableList(s2.getQuestions()));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    private void loadColumns(){
        TableColumn colId = new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(100);
        
         TableColumn colContent = new TableColumn("Noi dung cau hoi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(300);
        this.tvQuestions.getColumns().addAll(colId,colContent);
    }
    
}
