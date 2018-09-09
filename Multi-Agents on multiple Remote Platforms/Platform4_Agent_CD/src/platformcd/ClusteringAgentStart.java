/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformcd;

/**
 *
 * @author piyush
 */
public class ClusteringAgentStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] args1 = {"-container","ClusteringAgent:platformcd.ClusteringAgent"};
        
                jade.Boot.main(args1);
    }
    
}
