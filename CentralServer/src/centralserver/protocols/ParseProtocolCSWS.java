/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralserver.protocols;

import centralserver.connection.ConnectionTCP;
import centralserver.exceptions.ConnectionException;


public class ParseProtocolCSWS {
    ConnectionTCP _connection;

    public ParseProtocolCSWS(ConnectionTCP connection) {
        _connection = connection;
    }

    public String parse() throws ConnectionException {
        String received = "";
        String line;
        int size, sizeCount;

        line = _connection.receiveLine();
        String[] lineSplit = line.split(" ", 4);

        if (lineSplit[0].equals("REP")) {
            if(lineSplit.length != 4)
                return line;

            try {
                size = Integer.parseInt(lineSplit[2]);

                received = line;

                sizeCount = lineSplit[3].length();
                while(sizeCount <= size){
                    line = _connection.receiveLine();
                    received+= line;
                    sizeCount+= line.length();
                }
                return received;
            }
            catch(NumberFormatException e){
                return line;
            }
        }
        else
          return line;
    }
}
