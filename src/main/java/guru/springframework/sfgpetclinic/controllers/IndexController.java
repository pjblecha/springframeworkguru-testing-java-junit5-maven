package guru.springframework.sfgpetclinic.controllers;

import org.apache.commons.lang3.NotImplementedException;

public class IndexController {

    public String index(){
        return "index";
    }

    public String oopsHandler(){
        throw new CustomExceptionThrowingException();
    }
}
