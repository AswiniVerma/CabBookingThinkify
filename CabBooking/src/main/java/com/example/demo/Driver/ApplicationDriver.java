package com.example.demo.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.example.demo.Model.Driver;
import com.example.demo.Model.User;
import com.example.demo.Service.DriverService;
import com.example.demo.Service.UserService;

public class ApplicationDriver {
	
	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Map<Integer, User>  users = new HashMap<>();
			User user1 = new User(1,"Abhishek",23,"M");
			User user2 = new User(2,"Rahul",25,"M");
			User user3 = new User(2,"Nandini",25,"F");
			
			users.put(1, user1);
			users.put(2, user2);
			users.put(3, user3);
			// Showing already added users
			List<User> userlist = UserService.getAllUsers();
			for(User u : userlist) {
				System.out.print(u.getId()+"\t");
				System.out.print(u.getName()+"\t");
				System.out.print(u.getGender()+"\t");
				System.out.print(u.getAge()+"\t");
				System.out.println();
			}
			// Adding new User
			System.out.println("Create a new user");
			User newUser = new User();
			System.out.println("Enter the id ");
			int id = sc.nextInt();
			newUser.setId(id);
			
			System.out.println("Enter the name ");
			String name = reader.readLine();
			newUser.setName(name);
			
			System.out.println("Enter the age ");
			int age = sc.nextInt();
			newUser.setAge(age);
			
			System.out.println("Enter the gender ");
			String gender = reader.readLine();
			newUser.setGender(gender);
			
			UserService.addUser(newUser);
		
		//Showing user again
		List<User> userlist1 = UserService.getAllUsers();
		for(User u : userlist1) {
			System.out.print(u.getId()+"\t");
			System.out.print(u.getName()+"\t");
			System.out.print(u.getGender()+"\t");
			System.out.print(u.getAge()+"\t");
			System.out.println();
		}
		// Driver
		Map<Integer, Driver>  drivers = new HashMap<>();
		Map<Integer,Integer> m1 = new HashMap<>();
		m1.put(10,1);
		Driver driver1 = new Driver(1, "Driver1","M",22,"Swift","KA-01-12345",m1);
		Driver driver2 = new Driver(2, "Driver2","M",22,"Swift","KA-01-12345", m1);
		Driver driver3 = new Driver(3, "Driver3","M",22,"Swift","KA-01-12345", m1);

		
		drivers.put(1, driver1);
		drivers.put(2, driver2);
		drivers.put(3, driver3);
		//Showing List of Drivers
		System.out.println("================Drivers==============");
		List<Driver> driverlist = DriverService.getAllDrivers();
		for(Driver u : driverlist) {
			System.out.print(u.getId()+"\t");
			System.out.print(u.getName()+"\t");
			System.out.print(u.getGender()+"\t");
			System.out.print(u.getAge()+"\t");
			System.out.print(u.getId()+"\t");
			System.out.print(u.getVehicle()+"\t");
			System.out.print(u.getVehicle_no()+"\t");
			System.out.print(u.getCurrent_location()+"\t");
			System.out.println();
		}
		
		//Finding the ride
				System.out.println("===========Finding Ride===========");
				System.out.println("Enter the name");
				String cname = reader.readLine();
				
				System.out.println("Enter Starting Location");
				int sx = sc.nextInt();
				int sy = sc.nextInt();
				Map<Integer, Integer> newsm = new HashMap<>();
				newsm.put(sx,sy);
				
				System.out.println("Enter Ending Location");
				int ex = sc.nextInt();
				int ey = sc.nextInt();
				Map<Integer, Integer> newem = new HashMap<>();
				newem.put(ex,ey);
				
				
				List<String> driverAvail = DriverService.find_ride(cname, newsm, newem);
				
					System.out.print(driverAvail);
					System.out.println();
		
		//Adding new Driver
		
		System.out.println("Create a new driver");
		Driver newDriver = new Driver();
		System.out.println("Enter the id ");
		int Did = sc.nextInt();
		newDriver.setId(Did);
		
		System.out.println("Enter the name ");
		String Dname = reader.readLine();
		newDriver.setName(Dname);
		
		System.out.println("Enter the age ");
		int Dage = sc.nextInt();
		newDriver.setAge(Dage);
		
		System.out.println("Enter the gender ");
		String Dgender = reader.readLine();
		newDriver.setGender(Dgender);
		
		System.out.println("Enter the vehicle ");
		String Dvehicle = reader.readLine();
		newDriver.setVehicle(Dvehicle);
		
		System.out.println("Enter the vehicle_no ");
		String Dno = reader.readLine();
		newDriver.setVehicle_no(Dno);
		
		System.out.println("Enter the location");
		int x = sc.nextInt();
		int y = sc.nextInt();
		Map<Integer, Integer> newm = new HashMap<>();
		newm.put(x, y);
		newDriver.setCurrent_location(newm);
		DriverService.addDriver(newDriver);
		
		
		List<Driver> driverlist1 = DriverService.getAllDrivers();
		for(Driver u : driverlist1) {
			System.out.print(u.getId()+"\t");
			System.out.print(u.getName()+"\t");
			System.out.print(u.getGender()+"\t");
			System.out.print(u.getAge()+"\t");
			System.out.print(u.getId()+"\t");
			System.out.print(u.getVehicle()+"\t");
			System.out.print(u.getVehicle_no()+"\t");
			System.out.print(u.getCurrent_location()+"\t");
			System.out.println();
		}
		
		System.out.println("=============Book Ride============");
		System.out.println("Enter the driver u want to book");
		String bd_name = reader.readLine(); 
		String bookstr = DriverService.deleteByDriverName(bd_name);
		System.out.println(bookstr);
		
	}
		
	}	

}
