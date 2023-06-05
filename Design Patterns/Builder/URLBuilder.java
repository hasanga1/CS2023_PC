package Builder;

public class URLBuilder {
    private String protocol;
    private String hostName;
    private String port = "";
    private String pathParam = "";
    private String queryParam = "";

    public URLBuilder(String protocol, String hostName) {
        this.protocol = protocol;
        this.hostName = hostName;
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

    public void setPort(String port) {
        this.port = port;
    }

    public String getPathParam() {
        return pathParam;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }
}
