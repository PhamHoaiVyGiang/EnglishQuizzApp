/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.pojo;

import java.util.List;

/**
 *
 * @author GIANG
 */
public class Questions {
    private int id;
    private String content;
    private String hint;
    private String image;
    private Category category;
    private Level level;
    private List<Choice> choices;

    private Questions(Builder b){
        this.id=b.id;
        this.content=b.content;
        this.hint=b.hint;
        this.image=b.image;
        this.category=b.category;
        this.level=b.level;
        this.choices=b.choices;
        
    }
    
    public static class Builder{
        private int id;
        private String content;
        private String hint;
        private String image;
        private Category category;
        private Level level;
        private List<Choice> choices;

        /**
         * @param id the id to set
         * @return 
         */
        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        /**
         * @param content the content to set
         * @return 
         */
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * @param hint the hint to set
         * @return 
         */
        public Builder setHint(String hint) {
            this.hint = hint;
            return this;
        }

        /**
         * @param image the image to set
         */
        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        /**
         * @param category the category to set
         * @return 
         */
        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        /**
         * @param level the level to set
         * @return 
         */
        public Builder setLevel(Level level) {
            this.level = level;
            return this;
        }
        public Builder addChoice(Choice c){
            this.choices.add(c);
            return this;
        }
        public Questions build(){
            return new Questions(this);
        }
      
        
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * @param hint the hint to set
     */
    public void setHint(String hint) {
        this.hint = hint;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * @return the choices
     */
    public List<Choice> getChoices() {
        return choices;
    }

    /**
     * @param choices the choices to set
     */
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
    
    
}
