/**
 * rappresenta un router della rete
 */
public class Router {

    private String hostname;
    private String ip;

    public Router(String hostname, String ip) {
        this.hostname = hostname;
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Router{" +
                "hostname='" + hostname + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
