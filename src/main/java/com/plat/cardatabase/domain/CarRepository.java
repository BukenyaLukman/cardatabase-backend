package com.plat.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
    // fetch cars by Brand
    List<Car> findByBrand(@Param("brand") String brand);

    // fetch cars by color
    List<Car> findByColor(@Param("brand") String color);

    // Fetch cars by year
    List<Car> findByYear(int year);

    // fetch cars by Brand and Model
    List<Car> findByBrandAndModel(String brand, String model);

    // fetch cars by brand and color
    List<Car> findByBrandOrColor(String brand, String color);

    // Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByYear(String brand);
}
