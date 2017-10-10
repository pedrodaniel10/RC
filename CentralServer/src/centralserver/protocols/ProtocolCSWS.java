/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralserver.protocols;

import centralserver.processing.report.Report;
import centralserver.processing.request.RequestToWS;

/**
 *
 * @author duartegalvao
 */
public class ProtocolCSWS {
    private final String _nameAdress;
    private final String _iP;
    private final int _port;

    /**
    *
    * @param nameAdress
    * @param iP
    * @param port
    */
    public ProtocolCSWS(String nameAdress, String iP, int port) {
        _nameAdress = nameAdress;
        _iP = iP;
        _port = port;
    }

    public Report receive(String sentence) {
      //remove last char from sentence (it should be '\n' from protocol)
      sentence = sentence.substring(0, max(0,sentence.length()-1));

      //split sentence by space into array
      String[] splitedCommand = sentence.split(" ", 2);

      if (splitedCommand.length != 0) {
          return new ReportError(_nameAdress, _iP, _port, "ERR"));
      }
      switch (splitedCommand[0]) {
          case "ERR":
              return new ReportError(_nameAdress, _iP, _port, "ERR");
          case "REP":
              String[] commandArguments = splitedCommand[1].split(" ");
              switch(commandArguments[0]) {
                  case "EOF":
                      return new ReportError(_nameAdress, _iP, _port, "REP EOF");
                  case "ERR":
                      System.out.println("received rep err");
                      return new ReportError(_nameAdress, _iP, _port, "REP ERR");
                  case "F":
                  case "R":
                      if (commandArguments.length != 3) {
                          return new ReportError(_nameAdress, _iP, _port, "ERR");
                      }
                      else {
                          char type = commandArguments[0].charAt(0);
                          int size = Integer.parseInt(commandArguments[1]);
                          String file = commandArguments[2];
                          
                      }

                  default:
                      return new ReportError(_nameAdress, _iP, _port, "ERR");
              }
          default:
              return new ReportError(_nameAdress, _iP, _port, "ERR");

      }
    }

    /**
     *
     * @param request
     * @return
     */
    public String send(RequestToWS request) {
        int size = request.getFile().length();
        return "WRQ" + request.getpTC() + request.getFileName() + size + request.getFile() + "\n";
    }
}