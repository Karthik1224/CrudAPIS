package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.demo.services.Add2Numbers;

@SpringBootTest
class SpringBootDemo1ApplicationTests {

	@Test
	void contextLoads() {
	}
    
	@Autowired
	private Add2Numbers add2Numbers;
	
	@Test
	public void testadd()
	{
		int result = add2Numbers.add(2, 3);
		assertEquals(5,result);
	}
	
}
