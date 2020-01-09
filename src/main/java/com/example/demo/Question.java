/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

/**
 *
 * @author Андрей
 */
import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "questions")
public class Question implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long parent;
    private String name;
    private int ord;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent", nullable=false, insertable = false, updatable = false)
    private Theme theme;

    public Question() {
    }


    public Question(String name, int ord, int parent) {
        this.name = name;
        this.ord = ord;
        this.parent = parent;
    }
        
    public long getId() {
        return id;
    }
        public long getParent() {
        return parent;
    }
    public void setParent(long parent) {
        this.parent = parent;
    }        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrd() {
        return ord;
    }
    
    public void setOrd(int ord) {
        this.ord = ord;
    }

    public Theme getTheme() {
        return theme;
    }

    
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return theme + " " + name;
    }
}