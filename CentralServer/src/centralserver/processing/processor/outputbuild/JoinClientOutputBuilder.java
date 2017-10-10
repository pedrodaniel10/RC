/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralserver.processing.processor.outputbuild;

import centralserver.processing.report.ReportOk;


public class JoinClientOutputBuilder extends ClientOutputBuilder {

    public JoinClientOutputBuilder(String fileName, ReportOk[] reports) {
        super(fileName, reports);
    }

    @Override
    public void build() {
        String outFile = "";
        for (int i = 0; i < getReports().length; i++) {
            if (i > 0)
                outFile += '\n';
            outFile += getReports()[i].getFile();
        }
        
        setFile(outFile);
    }
    
}
