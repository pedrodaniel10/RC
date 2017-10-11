/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralserver.protocols;

import centralserver.processing.processor.ClientRequestErrorProcessor;
import centralserver.processing.processor.ClientRequestProcessor;
import centralserver.processing.report.Report;
import centralserver.processing.report.ReportError;
import centralserver.processing.report.ReportOk;
import centralserver.processing.request.Request;
import centralserver.processing.request.RequestError;
import centralserver.processing.request.RequestOk;
import static java.lang.Integer.max;

/**
 * Protocol beteween CS-Client, creates de messages to be sent and
 * confirms the protocol.
 * @author Pedro Daniel
 */
public class ProtocolCSClient {
    //Client RequestOk identifier
    private final String _nameAdress;
    private final String _iP;
    private final int _port;

    /**
     *
     * @param nameAdress
     * @param iP
     * @param port
     */
    public ProtocolCSClient(String nameAdress, String iP, int port) {
        _nameAdress = nameAdress;
        _iP = iP;
        _port = port;
    }
    

    
    /**
     * Receive the string from the connection 
     * @param sentence
     * @return RequestOk
     */
    public Request receive(String sentence){
        //remove last char from sentence (it should be '\n' from protocol)
        sentence = sentence.substring(0, max(0,sentence.length()-1));
        //split sentence by space into array
        String[] splitedCommand = sentence.split(" ",2);

        if(splitedCommand.length == 0){
            return new RequestError(_nameAdress, _iP, _port, "ERR", new ClientRequestErrorProcessor());
        }
        else if(splitedCommand[0].equals("LST")){
            if( splitedCommand.length == 1)
                return new RequestOk(_nameAdress, _iP, _port, "LST", new ClientRequestProcessor());
            else{
                return new RequestError(_nameAdress, _iP, _port, "FPT ERR", new ClientRequestErrorProcessor());
            }
        }
        else if("REQ".equals(splitedCommand[0]) && splitedCommand.length == 2){
            String[] commandArguments = splitedCommand[1].split(" ", 3);
            
            if(commandArguments.length != 3){
                //different lenght
                System.out.println("Length arguments different of 3.");
                return new RequestError(_nameAdress, _iP, _port, "REP ERR", new ClientRequestErrorProcessor());
            }
            else{
                int size = Integer.parseInt(commandArguments[1]);
                String file = commandArguments[2];
                
                if(size == file.length())
                    return new RequestOk(_nameAdress, _iP, _port,
                                         "REQ",
                                         commandArguments[0], 
                                         size,                 
                                         file,
                                         new ClientRequestProcessor());
                else{
                    //file doesnt have size bytes
                    System.out.print("File doesnt have all bytes. File length: " + file.length() + "\n" + file);
                    return new RequestError(_nameAdress, _iP, _port, "REP ERR", new ClientRequestErrorProcessor());
                }
            }
        }
        else{
            return new RequestError(_nameAdress, _iP, _port, "ERR", new ClientRequestErrorProcessor());
        }
    }
    
    /**
     *
     * @param report
     * @return
     */
    public String send(Report report){
        if(report instanceof ReportError){
            ReportError reportError = (ReportError) report;
     
            if (reportError.getError().equals("FPT EOF"))
                return "FPT EOF\n";
            else if (reportError.getError().equals("FPT ERR"))
                return "FPT ERR\n";
            else if (reportError.getError().equals("REP EOF"))
                return "REP EOF\n";
            else if (reportError.getError().equals("REP ERR"))
                return "REP ERR\n";
            else if (reportError.getError().equals("ERR"))
                return "ERR\n";
            // else should not happen
        }
        else if(report instanceof ReportOk){
            ReportOk reportOk = (ReportOk) report;
            
            if (reportOk.getCommand().equals("LST")) {
                String messageReturn = "FPT ";
                
                String[] pTCs = reportOk.getpTCs();
                int numberPTC = pTCs.length;
                
                messageReturn += numberPTC;
                    
                for(int i=0; i < numberPTC; i++)
                    messageReturn += " " + pTCs[i];
                    
                return messageReturn += "\n";
            }
            else if (reportOk.getCommand().equals("REQ")) {
                return "REP " + reportOk.getRT() + " " + 
                           reportOk.getSize() + " " + 
                           reportOk.getFile() + "\n";
            }
        }
        return "";
    }    
}
