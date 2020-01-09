/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author Андрей
 */
@RestController
public class QController {
    
    private QDao qDao;

    @Autowired
    public QController(QDao qDao) {
        this.qDao = qDao;
    }

    @GetMapping("/theme/all")
    public List<Theme> allThemes(String sorted) {
        return qDao.findAll(sorted);
        
    }
    
    @RequestMapping(value = "/del1")
    @ResponseBody
    public String del1(long id) {
        try {
            Theme theme = qDao.findThemeById(id);
            qDao.deleteTheme(theme);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Theme(id=" + id + ") succesfully deleted!";
    }
    
    @RequestMapping(value = "/del2")
    @ResponseBody
    public String del2(long id) {
        try {
            Question question = qDao.findQuestionById(id);
            qDao.deleteQuestion(question);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Theme(id=" + id + ") succesfully deleted!";
    }
    
    @RequestMapping(value = "/save1")
    @ResponseBody
    public String create1(String name, String dta1, String dta2, int active) {
        long id=0;
        try {
            Theme theme = new Theme();
            theme.setName(name);
            theme.setDta1(dta1);
            theme.setDta2(dta2);
            theme.setActive(active);
            qDao.saveTheme(theme);
            id=theme.getId();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Theme (" + name + " " + dta1 + " " + dta2+") succesfully saved with id=" + id;
    }
    
    @RequestMapping(value = "/save2")
    @ResponseBody
    public String create2(String name, int ord, long parent) {
        long id=0;
        try {
            Question question = new Question();
            question.setName(name);
            question.setParent(parent);
            question.setOrd(ord);
            qDao.saveQuestion(question);
            id=question.getId();
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Question (" + name + " " + parent + ") succesfully saved with id=" + id;
    }
    
    @RequestMapping(value = "/update1")
    @ResponseBody
    public String update1(long id, String name, String dta1, String dta2, int active) {
        try {
            Theme theme = qDao.findThemeById(id);
            theme.setName(name);
            theme.setDta1(dta1);
            theme.setDta2(dta2);
            theme.setActive(active);
            qDao.updateTheme(theme);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Theme (" + name + " " + dta1 + " " + dta2+") succesfully updated with id=" + id;
    }
    
    @RequestMapping(value = "/update2")
    @ResponseBody
    public String update2(long id, String name, int ord) {
        try {
            Question question = qDao.findQuestionById(id);
            question.setName(name);
            question.setOrd(ord);
            qDao.updateQuestion(question);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Question (" + name + ") succesfully updated with id=" + id;
    }
    
    @RequestMapping(value = "/update3")
    @ResponseBody
    public String update2(long id, String name) {
        try {
            Question question = qDao.findQuestionById(id);
            question.setName(name);
            qDao.updateQuestion(question);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Question (" + name + ") succesfully updated with id=" + id;
    }
    
    
   
}