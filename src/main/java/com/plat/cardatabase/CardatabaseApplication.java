package com.plat.cardatabase;

import com.plat.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;


@SpringBootApplication
@EnableJpaRepositories("com.plat.cardatabase.domain")
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;


	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));


		repository.save(new Car("Ford","Mustang","Red","ADF-1121",2021,59000,owner1));
		repository.save(new Car("Nissan","Leaf","White","SSJ-2002",2019,29000,owner2));
		repository.save(new Car("Toyota","Prius","Sliver","KKO-0212",2020,39000, owner2));



		for(Car car: repository.findAll()){
			logger.info(car.getBrand() + " " + car.getModel());
		}

		// Username: user, Password : user   .
		userRepository.save(new User("user","$2y$10$CUFvMmpMnzdH55fc7yeMN.xiLZbLGDxWMterOL9nV5XZbpQRbKwg.","USER"));

		// UserName: admin, password: admin
		userRepository.save(new User("admin", "$2y$10$kYIJGPvNuB5iexMifclaFuQEE2ZCf1WXlWUb6KWfVNxQJEpGpmVo6", "ADMIN"));

	}
}
