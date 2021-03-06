package centralserver;

import java.util.Objects;

/**
 * Connect Address IP and port together
 */
public class ConnectAddress {
    private final String _ip;
    private final int _port;

    /**
     *
     * @param _ip
     * @param port
     */
    public ConnectAddress(String _ip, int port) {
        this._ip = _ip;
        this._port = port;
    }

    /**
     *
     * @return
     */
    public String getIp() {
        return _ip;
    }

    /**
     *
     * @return
     */
    public int getPort() {
        return _port;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof ConnectAddress){
            ConnectAddress connectAddress = (ConnectAddress) o;
            return connectAddress.getIp().equals(_ip) && connectAddress.getPort() == _port;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this._ip);
        hash = 41 * hash + this._port;
        return hash;
    }
    
}
