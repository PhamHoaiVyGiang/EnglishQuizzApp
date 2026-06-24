/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.utils.themes;

import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public class ThemeManager {
    private static ThemeAbstractFactory factory=new DefaultFactory();
    
    public static void applyTheme(Scene scene){
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(factory.getStyleSheet());
    }

    /**
     * @param aFactory the factory to set
     */
    public static void setFactory(ThemeAbstractFactory aFactory) {
        factory = aFactory;
    }
}
