package io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFileChannel {

	public static void main(String[] args) {
		String src = "output/channelSrc.txt", dest = "output/ChannelDest.txt";

		try {
			FileChannel srcChannel = new FileInputStream(src).getChannel();
			FileChannel destChannel = new FileOutputStream(dest).getChannel();
			destChannel.transferFrom(srcChannel, 0, srcChannel.size());
			srcChannel.close();
			destChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
