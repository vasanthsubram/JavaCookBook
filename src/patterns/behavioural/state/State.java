package patterns.behavioural.state;

public interface State {
	// The state interface and two implementations. The state method has a
	// reference to the context object and is able to change its state.
	public void writeName(StateContext stateContext, String name);
} 
 

