package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class Add2Numbers{
	
	public int add(int num1, int num2)
	{
		return num1+num2;
	}
}
