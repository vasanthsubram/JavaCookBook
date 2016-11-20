package patterns.structural.facade;


/* Client */

public class FacadeDemo {

	public static void main(String[] args) {
		Computer facade = new Computer();
		facade.startComputer();
	}

}

class CPU {
	public void freeze() {
		System.out.println("CPU: Freeze ....");
	}

	public void jump(long position) {
		System.out.println("CPU: jump to new location ....");
	}

	public void execute() {
		System.out.println("CPU: execute");
	}
}
 

class Memory {
	public void load(long position, byte[] data) {
		System.out.println("Loading memory ....");
	}
}
 

class HardDrive {
	public byte[] read(long lba, int size) {
		return new byte[1];
	}
}
 
/* Facade */
class Computer {

	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void startComputer() {
		cpu.freeze();
		memory.load(100, hardDrive.read(1, 10));
		cpu.jump(200);
		cpu.execute();
	}

}
 


