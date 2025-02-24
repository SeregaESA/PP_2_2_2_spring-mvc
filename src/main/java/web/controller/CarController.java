package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.servies.CarServies;

@Controller
public class CarController {

    private final CarServies carServies;

    @Autowired
    public CarController(CarServies carServies) {
        this.carServies = carServies;
    }

    @GetMapping(value = "/cars")
    public String index(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("car", carServies.index(count));
        return "cars";
    }
}
