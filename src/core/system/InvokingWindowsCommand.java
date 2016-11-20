package core.system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InvokingWindowsCommand {
	
	public static void main(String args[]){
		try {
			String cmd[] = new String[3];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "dir";

			//This is equivalent of executing in Windows
			//Start -> Run -> cmd.exe /c dir
			Process proc = Runtime.getRuntime().exec(cmd);

			InputStream stdin = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(stdin);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			System.out.println("<OUTPUT>");
			while ((line = br.readLine()) != null)
				System.out.println(line);
			System.out.println("</OUTPUT>");
			int exitVal = proc.waitFor();
			System.out.println("Process exitValue: " + exitVal);

		} catch (Throwable t) {
			t.printStackTrace();
		}

	
	}
}
