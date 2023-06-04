package Facad;

public class Server {
    private String ipAddress;

    public void connect() {
        System.out.println("Connected.");
    }

    public void send(Message message, String target) {
        System.out.println("Sending message..");
    }

    public void disconnect() {
        System.out.println("Disconnected.");
    }

    public AuthToken getToken(String ipAddress) {
        return new AuthToken(ipAddress);
    }
}
