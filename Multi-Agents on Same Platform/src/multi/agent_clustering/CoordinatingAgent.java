/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi.agent_clustering;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author piyush
 */
public class CoordinatingAgent extends Agent{
    
    @Override
    protected void setup(){
                // Printout a welcome message
		System.out.println("Hallo! Co0rdinating-Agent "+getAID().getName()+" is ready.");
                addBehaviour(new CyclicBehaviour(){
                    
                    @Override
                    public void action()
                    {
                            ACLMessage msg = receive();
        
        if(msg != null)
        {
        System.out.println("Received msg by Co-ordinating Agent is "+msg.getContent());
        String t = msg.getContent();
        addBehaviour(new OneShotBehaviour(){
                    
                    @Override
                    public void action()
                    {
                        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                        msg.setContent(t);
                        System.out.println("Coordinating Agent sending to Clustering Agent");
                       			       				
		        msg.setSender(getAID());
		        msg.addReceiver(new AID("ClusteringAgent", AID.ISLOCALNAME));
                        send(msg);
                    }
                });
        }
        
        else{
            block();
        }
                    }
                });
                
                
    }
    
      // Put agent clean-up operations here
    @Override
	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Coordinating-agent "+getAID().getName()+" terminating.");
	}
}
