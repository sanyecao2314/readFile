package com.novelbio.test.midle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MiddleFile {

	FileReader fileReader = null;
	public BufferedReader bufferedReader = null; 
	
	public MiddleFile(){
		try {
			fileReader = new FileReader("");
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
		return temp.split("")[0];
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
	
}
