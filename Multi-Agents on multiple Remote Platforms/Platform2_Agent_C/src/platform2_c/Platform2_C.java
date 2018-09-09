/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform2_c;

/**
 *
 * @author piyush
 */
public class Platform2_C {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] args1 = {"-gui","CoordinatingAgent:platform2_c.CoordinatingAgent;"};
             jade.Boot.main(args1);
             
            String[] args2 = {"-container","ClusteringAgent:platform2_c.ClusteringAgent"};
              jade.Boot.main(args2);
    }
    
}
