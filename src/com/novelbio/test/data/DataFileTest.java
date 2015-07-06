package com.novelbio.test.data;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DataFileTest {

	@Test
	public void testLineCount() {
		DataFile dataFile = new DataFile();
		long lineNo = 0;
		try {
			lineNo = dataFile.lineCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(lineNo == 19129879l);
	}

}
