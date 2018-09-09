/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi.agent_clustering;

import Clustering.Cluster;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import multi.agent_GUI.SelectDataSet;
import multi.agent_GUI.UserAgentGUI;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author piyush
 */
public class CoordinatingAgent1 extends Agent{
     
    @Override
    protected void setup()
    {
        // Printout a welcome message
		System.out.println("Hallo! Co-ordinating-Agent-1 "+getAID().getName()+" is ready.");
                addBehaviour(new CyclicBehaviour(){
                    
                    @Override
                    public void action()
                    {
                            ACLMessage msg = receive();
        
        if(msg != null)
        {
        System.out.println("Received msg is "+msg.getContent());
      
     String fileName = msg.getUserDefinedParameter("file-name");
 File f = new File(fileName);
  byte[] fileContent = msg.getByteSequenceContent();
  // 
      //  byte[] bytes = ...;
Path path = Paths.get(f.getAbsolutePath());
                                try {
                                    Files.write(path, fileContent);
                                } catch (IOException ex) {
                                    Logger.getLogger(CoordinatingAgent1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                Cluster c = new Cluster();
        c.FileReceive(f);
       
        
        
         try {
             Cluster.main(null);
         } catch (Exception ex) {
             Logger.getLogger(SelectDataSet.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        
        else{
            block();
        }
                    }
                });
    }
    
      // Put agent clean-up operations here
	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Coordinating-agent-1 "+getAID().getName()+" terminating.");
	}
}
