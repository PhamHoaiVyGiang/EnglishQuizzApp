package com.phvg.mavenproject3;

import com.phvg.utils.MyAlertSingleton;
import com.phvg.utils.MyStageSingleton;
import com.phvg.utils.themes.DarkFactory;
import com.phvg.utils.themes.DefaultFactory;
import com.phvg.utils.themes.LightFactory;
import com.phvg.utils.themes.ThemeManager;

import com.phvg.utils.themes.ThemeTypes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;



public class PrimaryController implements Initializable{
    @FXML private ComboBox<ThemeTypes> cbTheme;
    

    public void mangeQuestions( ActionEvent e){
        MyStageSingleton.getInstance().showStage("questions");
    }
    public void practiceQuestions( ActionEvent e){

         MyAlertSingleton.getInstance().showMsg("[practiceQuestions] comming soon");
    }
    public void examQuestions( ActionEvent e){

         MyAlertSingleton.getInstance().showMsg("[  examQuestions] comming soon");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.cbTheme.setItems(FXCollections.observableArrayList(ThemeTypes.values()));
    }
    public void changeTheme( ActionEvent e){
        this.cbTheme.getSelectionModel().getSelectedItem().updateTheme(this.cbTheme.getScene());
    }
    
    
}
