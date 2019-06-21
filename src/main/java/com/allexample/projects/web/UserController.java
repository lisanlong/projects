package com.allexample.projects.web;

import com.allexample.projects.model.User;
import com.sun.applet2.preloader.event.ErrorEvent;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.jar.Attributes;
@Api(value = "UserController", description = "消息操作 API", position = 100, protocols = "http")
@Controller
@RequestMapping("/")
public class UserController {
    /**
     * JSR验证数据是否正常 Hibernate Validator
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(name = "login",method = RequestMethod.GET)
    public String login(@Valid User user , BindingResult result){
        if (result.hasErrors()){
            List<ObjectError>  ee=result.getAllErrors();
            for(ObjectError error:ee){
                System.out.println(error.getCode()+ error.getDefaultMessage());
            }
        }

    return "webSocket/index";

    }

   /* @RequestMapping(value="get/{name}", method=RequestMethod.GET)
    public String get(@PathVariable String name) {
        return name;
    }*/

}
