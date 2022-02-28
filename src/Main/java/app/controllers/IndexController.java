package app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {


    @PostMapping("/addPassword")
    public String getPassword(String password, Model model) {
        if (password.equals("Hello123")) {

            return "BlogEditor.html";
        } else {
            model.addAttribute("incorrectPassword", "Password incorrect. Try again.");
            return "Index.html";
        }
    }
    @PostMapping("/toBlog")
    public String toBlog(){
        return "MyBlog.html";
    }

}
