
package platformk;

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
                        AID r=new AID("CoordinatingAgent@192.168.0.5:1099/JADE",AID.ISGUID);
                        r.addAddresses("http://Chris:7778/acc");
		        msg.addReceiver(r);
		        //msg.addReceiver(new AID("CoordinatingAgent", AID.ISLOCALNAME));
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
        
        String[] args1 = {"-gui","UserAgent:platformk.UserAgent"};
        
                jade.Boot.main(args1);
    }
    
}
