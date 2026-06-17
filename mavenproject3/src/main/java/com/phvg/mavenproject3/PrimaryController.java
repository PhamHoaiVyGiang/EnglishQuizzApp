package com.phvg.mavenproject3;

import com.phvg.utils.MyAlertSingleton;
import com.phvg.utils.themes.ThemeStyles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;



public class PrimaryController implements Initializable{
    @FXML private ComboBox<ThemeStyles> cbTheme;
    

    public void mangeQuestions( ActionEvent e){
        MyAlertSingleton.getInstance().showMeg("[ mangeQuestions] comming soon");
    }
    public void practiceQuestions( ActionEvent e){

         MyAlertSingleton.getInstance().showMeg("[practiceQuestions] comming soon");
    }
    public void examQuestions( ActionEvent e){

         MyAlertSingleton.getInstance().showMeg("[  examQuestions] comming soon");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.cbTheme.setItems(FXCollections.observableArrayList(ThemeStyles.values()));
    }
    public void changeTheme( ActionEvent e){
        switch(this.cbTheme.getSelectionModel().getSelectedItem()){
            case DARK:
                this.cbTheme.getScene().getRoot().getStylesheets().clear();
                this.cbTheme.getScene().getRoot().getStylesheets().add(App.class.getResource("Dark.css").toExternalForm());
                break;
            case LIGHT:
                this.cbTheme.getScene().getRoot().getStylesheets().clear();
                this.cbTheme.getScene().getRoot().getStylesheets().add(App.class.getResource("Light.css").toExternalForm());
                break;
            default:
                this.cbTheme.getScene().getRoot().getStylesheets().clear();
                this.cbTheme.getScene().getRoot().getStylesheets().add(App.class.getResource("Styles.css").toExternalForm());
        }
    }
    
    
}
