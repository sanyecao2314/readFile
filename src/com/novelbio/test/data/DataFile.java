package com.novelbio.test.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataFile {

	FileReader fileReader = null;
	public BufferedReader bufferedReader = null; 
	
	public DataFile(){
		try {
			fileReader = new FileReader("/home/novelbio/upload/testData/CYR32_2_filtered_1.fq");
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String readLine(){
		String tempName = "";
		try {
			tempName = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempName;
	}
	
	public void close(){
		if (fileReader != null) {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (bufferedReader != null) {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
}
