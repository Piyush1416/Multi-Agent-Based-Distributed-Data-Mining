/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi.agent_clustering;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author piyush
 */
public class UserAgent extends Agent {

    /**
     * @param args the command line arguments
     */
    public static String k;
    
       protected void setup()
    {
        // Printout a welcome message
		System.out.println("Hallo! User-Agent "+getAID().getName()+" is ready.");
                
                
                addBehaviour(new OneShotBehaviour(){
                    
                    @Override
                    public void action()
                    {
                        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                        msg.setContent(k);
                        System.out.println("Inside User-Agent action");
                       			       				
		        msg.setSender(getAID());
		        msg.addReceiver(new AID("CoordinatingAgent", AID.ISLOCALNAME));
                        send(msg);
                    }
                });
    }
    
      // Put agent clean-up operations here
	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("User-agent "+getAID().getName()+" terminating.");
	}
    
    public static void main(String[] args) {
        // TODO code application logic here
        k = args[0];
        System.out.println("Sent string via KJFrame is:"+k);
        
        String[] args1 = {"-container","UserAgent:multi.agent_clustering.UserAgent"};
        
                jade.Boot.main(args1);
    }
    
}
