package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/*
import java.sql.SQLException;

public class DemoApplication {
    public static void main(String[] args) throws SQLException {

        QService QService = new QService();
        Theme theme = new Theme("Есть ли жизнь на марсе?","2020/01/07", "2020/01/10");
        QService.saveTheme(theme);
        Question q1 = new Question("Марс это планета?", 0, 0);
        q1.setTheme(theme);
        theme.addQuestion(q1);
        Question q2 = new Question("На Марсе есть атмосфера?", 0, 0);
        q2.setTheme(theme);
        theme.addQuestion(q2);
        QService.updateTheme(theme);
    }
}
*/