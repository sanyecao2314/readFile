package com.novelbio.test.midle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MiddleFile {

	FileReader fileReader = null;
	public BufferedReader bufferedReader = null; 
	
	public MiddleFile(){
		try {
			fileReader = new FileReader("/home/novelbio/upload/testData/CYR32_2_1.blast.txt");
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getIdName(String idName) {
		String tempName = "";
		tempName = getIdName();
		while (tempName.equals(idName)) {
			tempName = getIdName();
		}
		return tempName;
	}
	
	private String getIdName(){
		String temp = "";
		try {
			temp = bufferedReader.readLine();
			if (temp == null || "".equals(temp)) {
				return "";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp.split("	")[0];
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
	
	public long realLineCount() throws IOException{
		long no = 0;
		String str =  bufferedReader.readLine();
		while (str != null && !"".equals(str)) {
			no++;
			str = bufferedReader.readLine();
		}
		return no;
	}
	
	
	public long lineCount() throws IOException{
		Set<String> setIdName = new HashSet<>();
		String str  = "";
		while (true) {
			str = getIdName();
			if (str == null || "".equals(str)) {
				break;
			}
			setIdName.add(str);
		}
		return setIdName.size() * 4;
	}
}
