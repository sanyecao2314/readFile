package com.novelbio.test.write;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {	

		private static File file = null;
		private static FileWriter writeFile = null;
	
		
		public WriteFile(){
			try {
				file = new File("/home/novelbio/upload/testData/result");
				writeFile = new FileWriter(file);
				if (!file.isFile()) {
					file.createNewFile();
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void write(String str){
			try {
				writeFile.write(str + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void closeWrite(){
			if (writeFile != null) {
				try {
					writeFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	
}
