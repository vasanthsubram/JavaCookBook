package patterns.behavioural.command;

public class Document {
    
	private String text;
	
    public Document(String text){
    	this.text=text;
    }

    public void boldSelection(){
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}