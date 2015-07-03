package com.novelbio.test.process;

import com.novelbio.test.data.DataFile;
import com.novelbio.test.midle.MiddleFile;
import com.novelbio.test.write.WriteFile;

public class Process {

	static WriteFile writeFile = new WriteFile();
	public static void main(String[] args) {
		MiddleFile middleFile = new MiddleFile();
		DataFile dataFile = new DataFile();
		Process process = new Process();
		String middleIdName = "";
		middleIdName = middleFile.getIdName(middleIdName);
		String dataLine = "";
		String dataIdName = "";
		while (true) {
			dataLine = dataFile.readLine();
			if (isnull(middleIdName) && isnull(dataLine)) {
				break;
			}
			dataIdName = dataLine.split("")[0].replaceAll("@", "");
			if (!middleIdName.equals(dataIdName)) {
				process.writeNewFile(dataLine);
			} else {
				middleIdName = middleFile.getIdName(null);
			}
		}
		
		middleFile.close();
		dataFile.close();
		writeFile.closeWrite();
	}

	private  void writeNewFile(String dataLine) {
		writeFile.write(dataLine);
	}

	private static boolean isnull(String str){
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
}
