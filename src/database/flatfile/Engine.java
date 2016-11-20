package database.flatfile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.apache.kahadb.util.ByteArrayInputStream;

public class Engine {

	private RandomAccessFile store, metaStore;
	List<RecordInfo> recordInfos;
	private String storeFileName = "output/fileDB-store.txt";
	private String metaStoreFileName = "output/fileDB-meta-store.txt";

	public Engine() {
		try {
			store = new RandomAccessFile(storeFileName, "rw");
			metaStore = new RandomAccessFile(metaStoreFileName, "rw");
			recordInfos = new ArrayList<RecordInfo>();
			readRecordInfo();

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private int getNextRecNum() {
		if (recordInfos.size() == 0) {
			return 1;
		}
		RecordInfo recInfo = recordInfos.get(recordInfos.size() - 1);
		return recInfo.getNum() + 1;
	}

	private byte[] asByteArray(Object obj) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteStream);
		out.writeObject(obj);
		return byteStream.toByteArray();
	}

	public void insert(Object obj) {
		int recNum = getNextRecNum();

		try {
			byte[] objArray = asByteArray(obj);
			RecordInfo recordInfo = new RecordInfo(recNum,
					(int) store.length(), objArray.length);
			recordInfos.add(recordInfo);
			store.seek(recordInfo.getStart());
			store.write(objArray, 0, objArray.length);

			metaStore.seek((int) store.length());
			for (int var : recordInfo.asArray()) {
				metaStore.writeInt(var);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Object query(int recNum) {
		RecordInfo recInfo = null;
		for (RecordInfo info : recordInfos) {
			if (info.getNum() == recNum) {
				recInfo = info;
				break;
			}
		}
		try {
			store.seek(recInfo.getStart());
			byte[] b = new byte[recInfo.getLength()];
			store.read(b, 0, recInfo.getLength());

			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(b));
			return in.readObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void close() throws IOException {
		store.close();
		metaStore.close();
	}

	private void readRecordInfo() throws IOException {
		RecordInfo r = null;
		ObjectInputStream in = null;
		File f = new File(metaStoreFileName);
		if (f.length() == 0) {
			return;
		}
//		if(f.length()% 16 !=0){
//			throw new RuntimeException("Corruption in meta store");
//		}
		metaStore.seek(0);
		for (int i = 0; i < f.length()/16; i++) {
			r = new RecordInfo(metaStore.readInt(), metaStore.readInt(),
					metaStore.readInt(), metaStore.readInt());
			recordInfos.add(r);
			System.out.println(r);
		}
		metaStore.seek(0);
		/*
		try {
			in = new ObjectInputStream(new FileInputStream(f));
			while ((r = (RecordInfo) in.readObject()) != null) {
				recordInfos.add(r);
				System.out.println(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		*/
	}
}
