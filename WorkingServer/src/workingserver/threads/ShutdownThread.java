package workingserver.threads;

import java.net.InetAddress;
import java.net.UnknownHostException;
import workingserver.connection.ConnectionUDP;
import workingserver.exceptions.ConnectionException;

/**
 * Thread that is executed when the program is shutdown
 * It performs the unregist of the WS
 */
public class ShutdownThread extends Thread {

    private ConnectionUDP _connection;
    private Integer _wsPort;

    /**
     *
     * @param connection
     * @param wsPort
     */
    public ShutdownThread(ConnectionUDP connection, Integer wsPort) {
        _wsPort = wsPort;
        _connection = connection;
    }

    @Override
    public void run() {
        String unregMessage = "UNR ";
        try {
            unregMessage = unregMessage + InetAddress.getLocalHost().getHostAddress() + " " + _wsPort + "\n";
        } catch (UnknownHostException e) {
            System.out.println("Error: Unknown host.\n");
        }
                int counter = 0;
                while(counter < 3){
                    try{
                        _connection.send(unregMessage);
                        String received = _connection.receive();
                        if(received.equals("UAK OK\n"))
                            break;
                        counter++;
                    }
                    catch(ConnectionException e) {
                        counter++;
                         if(counter < 3){                    
                             System.err.println(e.getErrorDescription());
                         }
                         else{
                            System.err.println(e.getErrorDescription());
                            System.out.println("Couldn't connect to CS: " + _connection.getNameToSend() + " " + _connection.getPortToSend());
                            _connection.close();
                            System.out.println("Server unregistered unsuccesfully in CS: " + _connection.getNameToSend() + " " + _connection.getPortToSend());
                            System.exit(0);
                         }                
                    }
                }
                System.out.println("Server unregistered succesfully in CS: " + _connection.getNameToSend() + " " + _connection.getPortToSend());
            }

}
