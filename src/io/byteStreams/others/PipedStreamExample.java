package io.byteStreams.others;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * This program illustrates how two one thread can send data to another thread
 * using PipedInputStream and PipedOutputStream.
 * 
 * @author chq-vasanthakumars
 * 
 */
public class PipedStreamExample {
	public static void main(String[] args) throws IOException {
		final PipedInputStream inPipe = new PipedInputStream();
		final PipedOutputStream outPipe = new PipedOutputStream();
		// both streams must be connected
		inPipe.connect(outPipe);

		Thread inThread = new Thread() {
			public void run() {
				int byt;
				try {
					while ((byt = inPipe.read()) != -1) {
						System.out.println(byt);
						//System.out.flush();
					}
				} catch (IOException e) {
					getUncaughtExceptionHandler().uncaughtException(this, e);
				} finally {
					try {
						inPipe.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread outThread = new Thread() {
			public void run() {
				try {
					for (int i = 65; i < 70; i++) {
						outPipe.write(i);
					}

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						// closing it informs the reader that writing is done
						// and not to read anymore
						outPipe.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		inThread.start();
		outThread.start();
	}
}
