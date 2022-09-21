package com.example.demo.Service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.DTO.FindRide;
import com.example.demo.Model.Driver;



public class DriverService {
	
	private static Map<Integer, Driver>  drivers = new HashMap<>();
	private static int index = 3;
	static {
		Map<Integer,Integer> m1 = new HashMap<>();
		m1.put(10,1);
		Driver driver1 = new Driver(1, "Driver1","M",22,"Swift","KA-01-12345",m1);
		Driver driver2 = new Driver(2, "Driver2","M",22,"Swift","KA-01-12345", m1);
		Driver driver3 = new Driver(3, "Driver3","M",22,"Swift","KA-01-12345", m1);

		
		drivers.put(1, driver1);
		drivers.put(2, driver2);
		drivers.put(3, driver3);
	}
	
	
	FindRide find_ride = new FindRide();
	
	public static List<Driver> getAllDrivers(){
		return new ArrayList<>(drivers.values());
	}
	
	public static Driver addDriver(Driver driver) {
		index +=1 ;
		driver.setId(index);
		drivers.put(index, driver);
		return driver;
	}
	
	public static List<String> find_ride( String name , Map<Integer,Integer>s1,  Map<Integer,Integer>s2){
		
		int Start_location = 0 ;
		int driver_location=0;
		for(Map.Entry<Integer, Integer> m : s1.entrySet())
			Start_location = m.getKey()+m.getValue();
		
				
		List<String> avail = new ArrayList<>();		
				for(Driver dr : drivers.values() ) {
				Map<Integer,Integer> newMap = dr.getCurrent_location();
					for(Map.Entry<Integer, Integer> m1 : newMap.entrySet()) {
						driver_location  = m1.getKey()+m1.getValue();
					}
					if( Math.abs(Start_location - driver_location)<=5) {
					avail.add(dr.getName()+" is available");
				}
				if(avail.size()==0) {
					String msg = "No drivers available";
					avail.add(msg);
				}

		}
		
		return avail;
		
	}	
	
	public static String deleteByDriverName(String driverName)  
	{  
		
		for(Map.Entry<Integer, Driver> m1 : drivers.entrySet()) {
			Driver d=m1.getValue();
			if(d.getName().equals(driverName)) {
				drivers.remove(m1.getKey());
				return "Driver Booked";
			}
			
		}
		return "No driver Found";
		
	} 
	
	

}
