package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {

    public String skillsToLearn(){
        return "<h1> Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>";


    }

    @GetMapping("/")
    @ResponseBody
    public String renderHomePage(){
        return skillsToLearn();
    }

    @GetMapping("/form")
    @ResponseBody
    public String renderForm(){
        return "<html>" +
                "<body>" +
                "<form action='/answer' method='post'>" +
                "<label for='name'>Name:</label>" +
                "<br>" +
                "<input type='text' id='name' name='name'>" +
                "<br>" +
                "<label for='language1'>My favorite language</label>" +
                "<br>" +
                "<select name='language1'>" +
                    "<option value='Java'>Java</option>" +
                    "<option value='JavaScript'>JavaScript</option>" +
                    "<option value='Python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<label for='language2'>My two favorite language</label>" +
                "<br>" +
                "<select name='language2'>" +
                    "<option value='Java'>Java</option>" +
                    "<option value='JavaScript'>JavaScript</option>" +
                    "<option value='Python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<label for='language3'>My third favorite language</label>" +
                "<br>" +
                "<select name='language3'>" +
                    "<option value='Java'>Java</option>" +
                    "<option value='JavaScript'>JavaScript</option>" +
                    "<option value='Python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="/answer")
    @PostMapping("/answer")
    @ResponseBody
    public String renderUserAnswer(String name, String language1, String language2, String language3){
        return "<h1>" + name + "</h1>" +
                "</br>" +
                "<table>" +
                "<tr>" +
                "<td>" + "1." + "</td>" +
                "<td>" + language1 + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>" + "2." + "</td>" +
                "<td>" + language2 + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>" + "3." + "</td>" +
                "<td>" + language3 + "</td>" +
                "</tr>" +
                "</table>";
    }

}
