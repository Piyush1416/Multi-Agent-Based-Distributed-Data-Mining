/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform2_c;

//import Clustering.Cluster;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class ClusteringAgent extends Agent {
    
    protected void setup(){
        System.out.println("Hallo! Clustering-Agent "+getAID().getName()+" is ready.");
           //UserAgent.main(null);
           
           
        addBehaviour(new CyclicBehaviour(){
                    
                    @Override
                    public void action()
                    {
                            ACLMessage msg = receive();
                          
        if(msg != null)
        {
        System.out.println("Received msg by clustering Agent is "+msg.getContent());
        System.out.println("Sending data to Clustering Algorithm");
     
        
        
        }
        
        else{
            block();
        }
                    }
                });
    }
    
    @Override
    protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Clustering-agent "+getAID().getName()+" terminating.");
	}
}
