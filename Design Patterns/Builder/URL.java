package Builder;

public class URL {
    private String protocol, hostName, port, pathParam, queryParam;

    public URL(URLBuilder builder) {
        this.protocol = builder.getProtocol();
        this.hostName = builder.getHostName();
        this.port = builder.getPort();
        this.pathParam = builder.getPathParam();
        this.queryParam = builder.getQueryParam();
    }

    public void print() {
        System.out.println(protocol + hostName + port + pathParam + queryParam);
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHostName() {
        return hostName;
    }

    public String getPort() {
        return port;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getQueryParam() {
        return queryParam;
    }
}
