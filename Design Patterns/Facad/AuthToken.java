package Facad;

public class AuthToken {
    private String ipAddress;

    public AuthToken(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
