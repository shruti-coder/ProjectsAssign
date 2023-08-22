package com.nagarro.lms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LmsRestApiApplicationTests {

	@Test
	void contextLoads() {
		 Assertions.assertDoesNotThrow(this::doNotThrowException);
	}
	private void doNotThrowException(){
	    //This method will never throw exception
	}

}
