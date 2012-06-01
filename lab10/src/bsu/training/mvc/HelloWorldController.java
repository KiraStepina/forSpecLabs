package bsu.training.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@SessionAttributes
public class HelloWorldController {
 
    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
         String message = "Great! Hello World, I’m Spring Web MVC!";
        return new ModelAndView("hello", "message", message);
    }
    
    @RequestMapping("/do")
    public ModelAndView indexPage() {
          return new ModelAndView("index");
    }
}
