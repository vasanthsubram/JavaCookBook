package patterns.behavioural.command.lights;

import java.util.List;
import java.util.ArrayList;

/* The Command interface */
interface Command {
	void execute();
}

/* The Invoker class */
class Switch {
	private List<Command> history = new ArrayList<Command>();

	public void storeAndExecute(Command cmd) {
		this.history.add(cmd); // optional
		cmd.execute();
	}
	
	public void rewind(){
		if(!history.isEmpty()){
			int size = history.size();
			
			for(int i=size-1;i>=0;i--){
				history.get(i).execute();
			}
		}
	}
}

/* The Receiver class */
class Light {

	public void turnOn() {
		System.out.println("The light is on");
	}

	public void turnOff() {
		System.out.println("The light is off");
	}
}

/* The Command for turning on the light - ConcreteCommand #1 */
class TurnOnCommand implements Command {
	private Light theLight;

	public TurnOnCommand(Light light) {
		this.theLight = light;
	}

	public void execute() {
		theLight.turnOn();
	}
}

/* The Command for turning off the light - ConcreteCommand #2 */
class TurnOffCommand implements Command {
	private Light theLight;

	public TurnOffCommand(Light light) {
		this.theLight = light;
	}

	public void execute() {
		theLight.turnOff();
	}
}

/* The test class or client */
public class CommandPatternWithLights {
	public static void main(String[] args) {
		Light lamp = new Light();
		Command switchUp = new TurnOnCommand(lamp);
		Command switchDown = new TurnOffCommand(lamp);

		Switch mySwitch = new Switch();

		mySwitch.storeAndExecute(switchUp);
		mySwitch.storeAndExecute(switchDown);
		mySwitch.storeAndExecute(switchUp);
		mySwitch.storeAndExecute(switchDown);
		mySwitch.rewind();
	}
}