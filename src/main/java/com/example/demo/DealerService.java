package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Car findByCarId(long id) {
        return carRepository.findByCarId(id);
    }

    public Category findByCategoryId(long id) {
        return categoryRepository.findByCategoryId(id);
    }

    public void delete(Car theCar) {
        carRepository.delete(theCar);
    }

//    public void safeDelete(long category_id){
//        Category category = categoryRepository.findByCategoryId(category_id);
//        for(Car car : carRepository.findAll()){
//            if(car.getCategory().getCategoryId() == (category_id)){
//
//                car.setCategory(null);
//            }
//        }
//    }
}
