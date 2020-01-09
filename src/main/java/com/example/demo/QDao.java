package com.example.demo;

/**
 *
 * @author Андрей
 */

import org.hibernate.Session;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class QDao {
   
    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    
    public Theme findThemeById(long id) {
        return getSession().getReference(Theme.class, id);
    }

    public void saveTheme(Theme theme) {
        getSession().save(theme);
    }

    public void updateTheme(Theme theme) {
        getSession().update(theme);
    }

    public void deleteTheme(Theme theme) {
        getSession().delete(theme);
    }

    public Question findQuestionById(long id) {
        return getSession().getReference(Question.class, id);
    }
    
        public void saveQuestion(Question question) {
        getSession().save(question);
    }

    public void updateQuestion(Question question) {
        getSession().update(question);
    }

    public void deleteQuestion(Question question) {
        getSession().delete(question);
    }
    
     @SuppressWarnings("unchecked")
    public List<Theme> findAll(String sorted) {
        List<Theme> themes = (List<Theme>) getSession().createQuery("From Theme ORDER BY " + sorted).getResultList();
        return themes;
    }
}