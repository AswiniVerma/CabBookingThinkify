package com.example.demo.DTO;

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
public class FindRide {
	private String name;
	private Map<Integer, Integer> s1 = new HashMap<>();
	private Map<Integer, Integer> s2 = new HashMap<>();
	
}
