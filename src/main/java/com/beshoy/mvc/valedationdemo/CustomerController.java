package com.beshoy.mvc.valedationdemo;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an initbinder ..... to convert trim input strings
    // remove leading
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showform(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {
        System.out.println("Last Name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding results: "+theBindingResult.toString());
        System.out.println("\n\n\n\n\n");

        if(theBindingResult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-success";
        }
    }

}
