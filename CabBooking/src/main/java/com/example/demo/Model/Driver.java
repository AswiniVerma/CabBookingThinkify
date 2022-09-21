package com.example.demo.Model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Driver {
	
	private int id;
	private String name;
	private String gender;
	private int age;
	private String vehicle;
	private String vehicle_no;
	private Map<Integer,Integer> current_location = new HashMap<>();
}

