/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workingserver;

import java.util.ArrayList;
import workingserver.connection.ConnectionTCP;
import workingserver.connection.ServerTCP;
import workingserver.exceptions.ConnectionException;
import workingserver.tasks.ConvertTextToLowerCaseTask;
import workingserver.tasks.ConvertTextToUpperCaseTask;
import workingserver.tasks.FindLongestWordTask;
import workingserver.tasks.Task;
import workingserver.tasks.WordCountTask;
import workingserver.threads.ServerTCPConnectionThread;

/**
 *
 * @author Pedro Daniel
 */
public class WorkingServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer wSPort = null;
        String cSName = null;
        Integer cSPort = null;
        ArrayList<Task> tasks = new ArrayList<Task>();

        Task[] allTasks = new Task[]{
            new WordCountTask(),
            new FindLongestWordTask(),
            new ConvertTextToUpperCaseTask(),
            new ConvertTextToLowerCaseTask()
        };

        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-p")) {
                    i++;
                    wSPort = Integer.parseInt(args[i]);
                }
                else if (args[i].equals("-n")) {
                    i++;
                    cSName = args[i];
                }
                else if (args[i].equals("-e")) {
                    i++;
                    cSPort = Integer.parseInt(args[i]);
                }
                else {
                    for (Task task : allTasks) {
                        if (task.isPTC(args[i])) {
                            tasks.add(task);
                            break;
                        }
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Erro de parâmetros.\n");
            return;
        }

        ConnectionUDP connectionUDP = new ConnectionUDP(csName, csPort);
        String creationMessage = "REG ";
        n_tasks = tasks.length;


        while (true) {
            try {
                ServerTCP server = new ServerTCP(wSPort);
                ConnectionTCP connectionTCP = server.acceptSocket();
                ServerTCPConnectionThread connectionThread = new ServerTCPConnectionThread(connectionTCP);
                connectionThread.start();
            }
            catch (ConnectionException e) {
                System.err.println(e.getErrorDescription());
            }
        }

    }

}
