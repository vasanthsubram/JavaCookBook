package io.javaIOFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PrintDirectoryRecursively {

	static int TAB_COUNT = 0;

        static List<String> ignore= new ArrayList<String>();
	static {
	ignore.add(".svn");
	}
        
	public static void main(String args[]) {
		File root = new File("src/core");
		new PrintDirectoryRecursively().print(root);
	}

	private void print(File file) {
            if(ignore.contains(file.getName())){
			return;
		}
		if (file.isDirectory()) {
			TAB_COUNT++;
			printTabs(file.getName(), TAB_COUNT);

			//print files directly under this directory
			for (File a : file.listFiles()) {
				if (a.isFile()) {
					printTabs(a.getName(), TAB_COUNT + 1);
				}
			}
			//print recursively sub-directories under this directory
			for (File a : file.listFiles()) {
				if (a.isDirectory()) {
					print(a);
				}
			}
			TAB_COUNT--;
		} else {
			printTabs(file.getName(), TAB_COUNT + 1);
		}
	}

	private void printTabs(String s, int tabCount) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < tabCount; i++)
			buf.append("\t");
		buf.append(s);
		System.out.println(buf.toString());
	}
}
