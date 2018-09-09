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
public class CoordinatingAgentStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String[] args1 = {"-gui","CoordinatingAgent:platformcd.CoordinatingAgent"};
        
                jade.Boot.main(args1);
    }
    
}
