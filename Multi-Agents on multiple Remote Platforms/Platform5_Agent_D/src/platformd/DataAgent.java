/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformd;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author piyush
 */
public class DataAgent extends Agent{
    
    public static String p;
    public static String filename;
    
    protected void setup()
    {
        // Printout a welcome message
		System.out.println("Hallo! Data-Agent "+getAID().getName()+" is ready.");
                
                addBehaviour(new OneShotBehaviour(){
                    
                    @Override
                    public void action()
                    {

    //                    String fileName = "E:\\MY STUDY\\My project work\\Softwares\\weka-3-7-12\\data\\contact-lenses.arff";
/* byte[] fileContent =  read file content */
   //   Path path = Paths.get("E://MY STUDY/My project work/Softwares/weka-3-7-12/data/contact-lenses.arff");
Path path = Paths.get(p);
                        byte[] data = null;                         
                        try {
                            data = Files.readAllBytes(path);
                        } catch (IOException ex) {
                            Logger.getLogger(DataAgent.class.getName()).log(Level.SEVERE, null, ex);
                        }

/*
try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

    
			String sCurrentLine;
                        int count = 0;
                        
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
                               fileContent[] = sCurrentLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

*/
ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//msg.addReceiver(<receiver-aid>);
//msg.addReceiver(new AID("CoordinatingAgent1", AID.ISLOCALNAME));
   AID r=new AID("CoordinatingAgent1@192.168.0.20:1099/JADE",AID.ISGUID);
                        r.addAddresses("http://DESKTOP-7OUV8AN:7778/acc");
		        msg.addReceiver(r);


msg.setByteSequenceContent(data);
msg.addUserDefinedParameter("file-name", filename);
send(msg);
  System.out.println("Message sent"); 
                        
                        ////////////////////////////

 /*                       ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                        msg.setContent("Hi babes");
                        System.out.println("Inside Agent1 action");
                       			       				
		        msg.setSender(getAID());
		        msg.addReceiver(new AID("Agent2", AID.ISLOCALNAME));
                        send(msg);
  */      
                    }
                });
    }
    
      // Put agent clean-up operations here
	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Data-agent "+getAID().getName()+" terminating.");
	}
        
        public static void main(String args[])
        {
            System.out.println("Path received by Data-Agent is: "+args[0]);
            System.out.println("Received file name is: "+args[1]);
            
            p = args[0];
            filename = args[1];
            
            
           
             
             String[] args2 = {"-gui","DataAgent:platformd.DataAgent"};
        
                jade.Boot.main(args2);
        }
}
