/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform1_k;

/**
 *
 * @author piyush
 */
public class Platform1_K {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         String host = "localhost"; 
            String port = "7778"; 
            String argsv[] = {"-host", host,"-detect-main","false",port,"-port",port, "-gui", "UserAgent:platform1_k.UserAgent"};

        
            jade.Boot.main(argsv); 

      //  String[] args1 = {"-gui","UserAgent:platform1_k.UserAgent"};
     
     //   jade.Boot.main(args1);     
        
    }
    
}
