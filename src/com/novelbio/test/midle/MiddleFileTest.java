package com.novelbio.test.midle;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class MiddleFileTest {

	@Test
	public void testGetIdName() {
		MiddleFile middleFile = new MiddleFile();
		String idName = middleFile.getIdName(null);
		middleFile.close();
		assertTrue("HWI-D00552:106:C6DDEANXX:1:1101:2653:2105".equals(idName));
	}

	@Test
	public void testGetMutiIdName() {
		MiddleFile middleFile = new MiddleFile();
		String idName = "";
		for (int i = 0; i < 6; i++) {
			idName = middleFile.getIdName(idName);
		}
		middleFile.close();
		assertTrue(!"HWI-D00552:106:C6DDEANXX:1:1101:5191:2121".equals(idName));
	}
	
	@Test
	public void testRealLineCount(){
		MiddleFile middleFile = new MiddleFile();
		try {
			long lineCount = middleFile.realLineCount();
			assertTrue(1470771l == lineCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLineCount(){
		MiddleFile middleFile = new MiddleFile();
		try {
			long lineCount = middleFile.lineCount();
			System.out.println(lineCount);
			assertTrue(3460580 == lineCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
