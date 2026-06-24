/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.utils.themes;

import com.phvg.mavenproject3.App;

/**
 *
 * @author adminpubl
 */
public class DefaultFactory extends ThemeAbstractFactory{

    @Override
    public String getStyleSheet() {      
        return App.class.getResource("Styles.css").toExternalForm();
    }
    
}
