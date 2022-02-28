package app;

import app.controllers.HashtagController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    @Autowired
    HashtagController hashController;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
