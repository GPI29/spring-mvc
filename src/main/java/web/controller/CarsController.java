package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDAO;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/park")
public class CarsController {

    private final CarDAO carDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = "/car")
    public String car(Model model){
        model.addAttribute("cars", carDAO.index());

        return "park/cars";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){

       model.addAttribute("car", carDAO.showCar(id));

       return "park/show";
    }

    @GetMapping("/num")
    public String viewCountCar(@RequestParam("count") int count, Model model){

        model.addAttribute("view", carDAO.viewCar(count));

        return "park/viewcar";
    }


}
