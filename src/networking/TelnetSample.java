package networking;

import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

public class TelnetSample {
	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private char prompt = '$';

	public static void main(String[] args) {
		try {
			String target = "6745427647042872751";
			String logFileName = "central_server.log";
			String serverNames[] = { "dpdev-central1.chq.ei","dpdev-central2.chq.ei" };
			String workers[] = {"00", "02"};
			String pwd = "startup1";
			for (String s : serverNames) {
				grepLog(s,pwd , workers, target, logFileName);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void grepLog(String server, String pwd, String workers[], String target, String file) {
		String cmd = "grep " + target + " " + file;
		TelnetSample telnet = new TelnetSample(server, "distper", pwd);
		for (String w : workers) {
			telnet.sendCommand("cd /prod/app/distper/dpworker" + w
					+ "/current/logs", false);
			telnet.sendCommand(cmd, true);
		}
		telnet.disconnect();
	}
			
	public TelnetSample(String server, String user, String password) {
		try {
			// Connect to the specified server
			telnet.connect(server, 23);

			// Get input and output stream references
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());

			// Log the user on
			readUntil("login: ", false);
			write(user);
			readUntil("Password: ", false);
			write(password);

			// Advance to a prompt
			readUntil(prompt + " ", false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readUntil(String pattern, boolean print) {
		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			StringBuffer sb = new StringBuffer();
			boolean found = false;
			char ch = (char) in.read();
			while (true) {
				if (print) {
					System.out.print(ch);
				}
				sb.append(ch);
				if (ch == lastChar) {
					if (sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
				}
				ch = (char) in.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void write(String value) {
		try {
			out.println(value);
			out.flush();
			// System.out.println( value );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String sendCommand(String command, boolean print) {
		System.out.println();
		try {
			write(command);
			return readUntil(prompt + " ", print);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void disconnect() {
		try {
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
