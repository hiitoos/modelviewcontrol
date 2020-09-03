package com.example.demomvc2.controllers;

import com.example.demomvc2.beans.UserRepository;
import com.example.demomvc2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping ("/example")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  //por defecto es singleton, es lo sencillo pero sale caro
public class ExampleController {
    private final UserRepository userRepository;

    @Autowired //Se dice a spring que este es el constructor que tiene que usar
    public ExampleController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("name", "Mike");
        return "index";
    }

    @GetMapping("/view1")
    public ModelAndView view1(){
        return new ModelAndView("index");
    }

    @GetMapping("/view2")
    public ModelAndView view2(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", "Paul");
        return mav;
    }

    @GetMapping("/view3")
    public ModelAndView view3(){
        ModelAndView mav = new ModelAndView("indexMV");
        mav.addObject("User",new User("xavi", "password"));
        return mav;
    }

    @GetMapping("/viewList")
    public ModelAndView viewList(){
        List<User> user = userRepository.getUsers();
        user.get(0).setUser(user.get(0).getUser()+"1");
        user.add(new User("pablo", "pass"));
        ModelAndView mav = new ModelAndView("index2");
        mav.addObject("Users", user);
        System.out.println("ControllerRepositoryImplementation " + hashCode());
        return mav;
    }

    //Como el controller es un singleton, to.do lo que meta dentro aunque sea diferente será singleton,
    // para solucionarlo usariamos una factory
}
