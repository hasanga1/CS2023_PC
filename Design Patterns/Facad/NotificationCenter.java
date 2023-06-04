package Facad;

public class NotificationCenter {
    private String ipAddress;

    public NotificationCenter(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void sendMessage(String message, String target) {
        Server server = new Server();
        server.connect();
        server.getToken(ipAddress);
        server.send(new Message(message), target);
        server.disconnect();
    }
 }
