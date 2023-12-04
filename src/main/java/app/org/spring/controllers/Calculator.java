package app.org.spring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @GetMapping("/calculator")
    public String calculate(
            @RequestParam("a") String a,
            @RequestParam("b") String b,
            @RequestParam("action") String action,
            Model model) {

        double result = 0;
        double operandA = 0;
        double operandB = 0;
        String error = "";
        boolean isError = false;

        try {
            operandA = Double.parseDouble(a);
            operandB = Double.parseDouble(b);
        }
        catch (Exception e) {
            String message = e.getMessage();
            int firstColonIndex = message.indexOf(":");
            error = "incorrect format: " + message.substring(firstColonIndex + 1);
            isError = true;
        }

        if (!isError) {
            switch (action) {
            case "add" -> {
                result = operandA + operandB;
            }

            case "subtract" -> {
                result = operandA - operandB;
            }

            case "multiply" -> {
                result = operandA * operandB;
            }

            case "divide" ->
                    result = operandA / operandB;

            default -> {
                error = "Operator " + "\"" + action + "\"" + " doesn't exist!";
                isError = true;
            }}
        }
        model.addAttribute("resultOfCalculation", isError ? error : Double.toString(result));

        return "first/calculator";
    }
}
