package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String Hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String Goodbye(){
//        return "Goodbye, Spring!";
//    }

    //handles request of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    public String hellWithQueryParam(@RequestParam String name){
//        return "Whadup " + name;
//    }

    //handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello " + name + "!";
//    }

    //lives at /hello/form
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                    "<body>" +
//                        "<form action='hello' method='post'>" + //submit a request to /hello with post request
//                            "<input type='text' name='name'>" +
//                            "<input type='submit' value='Greet me!'>" +
//                        "</form>" +
//                    "</body>" +
//                "</html>";
//    }

    public static String createMessage(String name, String language){
        String pickLanguage = "World";
        if(language.equals("en")){
            pickLanguage = "Hello ";
        } else if (language.equals("fr")){
            pickLanguage = "Bonjour ";
        } else if (language.equals("sp")){
            pickLanguage = "Hola ";
        } else if (language.equals("ger")){
            pickLanguage = "Hallo ";
        } else if (language.equals("jp")){
            pickLanguage = "こんにちは";
        }
        return  "<strong>" + pickLanguage + "</strong>" + "  " + "<em>" + name + "</em>" + "!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "language")
    public String getLanguageSelection(@RequestParam String name, @RequestParam String language){
        return createMessage(name, language);
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='language' method='post'>" + //submit a request to /hello with post request
                            "<input type='text' name='name'>" +
                            "<select name=language>" +
                                "<option value='en'>English</option>" +
                                "<option value='fr'>French</option>" +
                                "<option value='sp'>Spanish</option>" +
                                "<option value='ger'>German</option>" +
                                "<option value='jp'>Japanese</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
