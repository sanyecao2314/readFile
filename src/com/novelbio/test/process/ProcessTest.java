package com.novelbio.test.process;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.novelbio.test.data.DataFile;
import com.novelbio.test.midle.MiddleFile;
import com.novelbio.test.write.WriteFileTest;

public class ProcessTest {

	@Test
	public void testMain() {
		//文件行数=新文件行数+中间文件行数
		DataFile dataFile = new DataFile();
		MiddleFile middleFile = new MiddleFile();
		WriteFileTest writeFile = new WriteFileTest();
		try {
			long dataLine = dataFile.lineCount();
			long middleLine = middleFile.lineCount();
			long writeLine = writeFile.lineCount();
			System.out.println(dataLine);
			System.out.println(middleLine);
			System.out.println(writeLine);
			assertTrue(dataLine == middleLine + writeLine);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			dataFile.close();
			middleFile.close();
		}
		
	}

}
