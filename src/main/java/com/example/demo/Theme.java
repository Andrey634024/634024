package com.example.demo;

/**
 *
 * @author Андрей
 */


//import ch.qos.logback.classic.pattern.DateConverter;
import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.*;

@Entity
@Table (name = "themes")
public class Theme implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate dta1;
    private LocalDate dta2;
    private int active;



    @JsonManagedReference
    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    public Theme() {
    }

    public Theme(String name, String dta1, String dta2, int active) {
        this.name = name;
        this.dta1 = LocalDate.parse(dta1);
        this.dta2 = LocalDate.parse(dta2);
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        question.setTheme(this);
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }
    
    public void setActive(int active) {
        this.active = active;
    }    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDta1() {
        return dta1;
    }

    public void setDta1(String dta1) {
        this.dta1 = LocalDate.parse(dta1);
    }
    
    public LocalDate getDta2() {
        return dta2;
    }

    public void setDta2(String dta2) {
        this.dta2 = LocalDate.parse(dta2);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "theme {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dta1=" + dta1 + '\'' +
                ", dta2=" + dta2 +
                '}';
    }
}