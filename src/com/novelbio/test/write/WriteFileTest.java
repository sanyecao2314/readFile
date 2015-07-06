package com.novelbio.test.write;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class WriteFileTest {

	private static FileReader fileReader = null;
	public BufferedReader bufferedReader = null; 
	public WriteFileTest(){
		try {
			fileReader = new FileReader("/home/novelbio/upload/testData/result");
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public long lineCount() throws IOException{
		long no = 0;
		String str =  bufferedReader.readLine();
		while (str != null && !"".equals(str)) {
			no++;
			str = bufferedReader.readLine();
		}
		return no;
	}
	
	public static void main(String[] args) {
		WriteFileTest writeFileTest = new WriteFileTest();
		try {
			long no = writeFileTest.lineCount();
			System.out.println(no);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
