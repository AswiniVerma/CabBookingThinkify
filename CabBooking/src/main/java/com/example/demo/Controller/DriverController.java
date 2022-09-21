package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.FindRide;
import com.example.demo.Model.Driver;
import com.example.demo.Service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {
	@GetMapping("/alldrivers")
	public List<Driver> getAllDrivers(){
		return DriverService.getAllDrivers();
	}
	
	@PostMapping("/addDriver")
	public Driver addDriver(@RequestBody Driver driver) {
		return DriverService.addDriver(driver);
	}
	
	@PostMapping("/find_ride")
	public List<String> find_ride(@RequestBody FindRide findride) {
		return DriverService.find_ride(findride.getName(),findride.getS1(), findride.getS2());
	}
	
	@DeleteMapping("/find_ride/{driverName}")
	public String choose_ride(@PathVariable String driverName) {
		return DriverService.deleteByDriverName(driverName);
	}
	
	
	
}
