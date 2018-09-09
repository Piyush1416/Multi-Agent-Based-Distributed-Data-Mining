/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform2_c;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserAgent extends Agent {
    
    
    public void setup()
    {
        // Printout a welcome message
		System.out.println("Hallo! User-Agent "+getAID().getName()+" is ready.");
           

                 addBehaviour(new OneShotBehaviour(){
                    
                    @Override
                    public void action()
                    {
                        String  s=null;
                        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                       System.out.println("Enter value of k");
                        //  open up standard input, and buffer it
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                        try {
                        s = bufferedReader.readLine();
                        } catch (IOException ex) {
                            Logger.getLogger(UserAgent.class.getName()).log(Level.SEVERE, null, ex);
                        } 
        // 
                        msg.setContent(s);
                        System.out.println("Inside UserAgent action and content is:"+s);
                       			       				
		        msg.setSender(getAID());
                        AID r=new AID("CoordinatingAgent@192.168.0.20:1099/JADE",AID.ISGUID);
                        r.addAddresses("http://DESKTOP-7OUV8AN:7778/acc");
		        msg.addReceiver(r);
                        send(msg);
                   
                        
                     /*   AID r=new AID("agent-name@platform",AID.ISGUID);
                        r.addAddresses("http://192.168.1.1:7778/acc");
                        acl.addReceiver(r);
                        acl.setContent("Hello.!");
                        this.send(acl);
                        System.out.println("\nMessage Sent to "+r);
                        
                        
AID r=new AID("CoordinatingAgent@192.168.0.20:1099/JADE",AID.ISGUID);
r.addAddresses("http://DESKTOP-7OUV8AN:7778/acc");
msg.addReceiver(r);
msg.setContent("Hello.!");
send(msg);
System.out.println("\nMessage Sent to "+r);
                   */ 
                             }
                });
    }
    
     // Put agent clean-up operations here
    @Override
	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("User-agent "+getAID().getName()+" terminating.");
	}
    
   public static void main(String args[])
   {
        String[] args3 = {"-GUI","UserAgent:platform2_c.UserAgent"};
        
        jade.Boot.main(args3);     
   }
}
