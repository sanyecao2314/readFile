package com.novelbio.test.process;

import com.novelbio.test.data.DataFile;
import com.novelbio.test.midle.MiddleFile;
import com.novelbio.test.write.WriteFile;

public class Process {

	WriteFile writeFile = new WriteFile();
	MiddleFile middleFile = new MiddleFile();
	DataFile dataFile = new DataFile();
	public static void main(String[] args) {
		Process process = new Process();
		process.doProcess();
	}

	private  void doProcess() {
		String middleIdName = "";
		middleIdName = middleFile.getIdName(middleIdName);
		String dataLine = "";
		String dataIdName = "";
		try {
			while (true) {
				dataLine = dataFile.readLine();
				if (isnull(dataLine)) {
					break;
				}
				try {
					dataIdName = dataLine.split(" ")[0].replaceAll("@", "");
				} catch (Exception e) {
					System.out.println("dataLine = " + dataLine);
					System.out.println("middleIdName =" + middleIdName);
					e.printStackTrace();
					throw e;
				}
				if (!middleIdName.equals(dataIdName)) {
					writeNewFile(dataLine);
				} else {
					middleIdName = middleFile.getIdName(middleIdName);
					dataFile.readLine();
					dataFile.readLine();
					dataFile.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			middleFile.close();
			dataFile.close();
			writeFile.closeWrite();
		}
		
		System.out.println("over");
	}

	private  void writeNewFile(String dataLine) {
		writeFile.write(dataLine);
		writeFile.write(dataFile.readLine());
		writeFile.write(dataFile.readLine());
		writeFile.write(dataFile.readLine());
	}

	private static boolean isnull(String str){
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
}
