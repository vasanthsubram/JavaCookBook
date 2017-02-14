package components.producer_consumer_nonBlocking;

public class Message {

    private int id;
    private String message;

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{ id:" + id + ",message: " + message + "}";
    }
}

