package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String displayHome(Model model) {
        Set<Category> categories = categoryRepository.findAll();
        Set<Car> cars = carRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("cars", cars);
        return "home";
    }

    @GetMapping("/new-car")
    public String displayCarForm(Model model) {
        Car aCar = new Car();

        Set<Category> categories = categoryRepository.findAll();
        model.addAttribute("allCategories", categories);

        model.addAttribute("car", aCar);
        return "new-car";
    }

    @PostMapping("save-car")
    public String createCar(Model model, Car car) {
        carRepository.save(car);
        return "redirect:/new-car";
    }

    @GetMapping("/new-category")
    public String displayCategoryForm(Model model) {
        Category aCategory = new Category();

        model.addAttribute("category", aCategory);
        return "new-category";
    }

    @PostMapping("save-category")
    public String createCategory(Model model, Category category) {
        categoryRepository.save(category);
        return "redirect:/new-category";
    }
}
