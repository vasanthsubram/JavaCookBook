package database.flatfile;

import java.io.Serializable;

public class RecordInfo implements Serializable{
	private int num;
	private int start;
	private int length;
	private int deleted = 0;

	public RecordInfo(int num) {
		this.num = num;
	}

	public RecordInfo(int num, int start, int length) {
		this.num = num;
		this.start=start;
		this.length=length;
	}
	
	public RecordInfo(int num, int start, int length, int deleted) {
		this.num = num;
		this.start=start;
		this.length=length;
		this.setDeleted(deleted);
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isDeleted() {
		return deleted == 1;
	}

	public void setDeleted(boolean deleted) {
		if (deleted) {
			this.deleted = 1;
		} else {
			this.deleted = 0;
		}
	}
	
	private void setDeleted(int deleted){
		this.deleted = deleted;
	}
	
	public String toString() {
		return "Record Num = " + num + " Start = " + start + " Length = "
				+ length + " Deleted = " + deleted;
	}
	
	public int[] asArray(){
		return new int[]{num,start, length, deleted};
	}
	
	public static int recordMetaLength(){
		return 4;
	}
}

