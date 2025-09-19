package example;

public class Shouter {
    private String message;

    public Shouter(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void shout() {
        System.out.println(message.toUpperCase());
    }

    public String toString() {
        return "The message is: " + this.message;
    }

    public static void main(String[] args) {
        Shouter shouter = new Shouter("welcome to 2511");
        shouter.shout();

        shouter.setMessage("Did this change?");
        System.out.println(shouter.getMessage());

        System.out.println(shouter.toString());
    }
}
