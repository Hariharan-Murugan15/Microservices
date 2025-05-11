package com.cts.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.cts.service.CalculationService;

class CalculationServiceTest {
	CalculationService calculationService = new CalculationService();
	
	@BeforeAll
	static void before() {
		System.out.println("-------JUnit Testing--------");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("-------JUnit Testing kjwrhkrjw4jh,kuwr--------");
	}

	
	@Test
	void test() {
		assertEquals(4, calculationService.add(1, 3));
//		fail("Not yet implemented");
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,7,8,9})
	void testEven(int num) {
		assertTrue(calculationService.isEven(num));
	}
	
	
}
