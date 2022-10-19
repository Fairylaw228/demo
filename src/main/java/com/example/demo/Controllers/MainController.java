package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MainController {



    @GetMapping("/")
    public String home( Model model) {
        return "home";
    }

    @GetMapping("/home")
    public String get(@RequestParam(value="one", required = false) double one,
                      @RequestParam(value="to", required = false) double to,
                      @RequestParam(value="operacia", required = false ) String math, Model model) {


        double otv = switch (math) {
            case "+"-> one + to;
            case "-"-> one - to;
            case "*"-> one * to;
            case "/"-> one / to;
            default -> 0;
        };
        model.addAttribute("resulte", otv);

        return "resultat";
    }

    @PostMapping("/home")
    public String post(@RequestParam(value="one", required = false) double one,
                       @RequestParam(value="to", required = false) double to,
                       @RequestParam(value="operacia", required = false ) String operacia, Model model) {


        double otv = switch (operacia) {
            case "+"-> one + to;
            case "-"-> one - to;
            case "*"-> one * to;
            case "/"-> one / to;
            default -> 0;
        };
        model.addAttribute("resulte", otv);

        return "resultat";
    }

}
