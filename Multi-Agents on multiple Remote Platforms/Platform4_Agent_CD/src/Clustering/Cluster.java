/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clustering;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;
 
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;



public class Cluster {
    
     public static int k;
     public static File f;
     
        public void KReceive(String s){
           
            System.out.println("Received value of K by Clustering Algo from Clustering Agent is:"+s);
             k = Integer.parseInt(s);
            System.out.println("Received int value :"+k); 
        }
        
        public void FileReceive(File c){
            f=c;
            System.out.println("Received file is"+f);
        }
 
	public static BufferedReader readDataFile(File filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}
 
	public static void main(String[] args) throws Exception {
		SimpleKMeans kmeans = new SimpleKMeans();
 
		kmeans.setSeed(10);
               
		//important parameter to set: preserver order, number of cluster.
		kmeans.setPreserveInstancesOrder(true);
	//	kmeans.setNumClusters(7);
                kmeans.setNumClusters(k);
		
        //      BufferedReader datafile = readDataFile("contact-lenses.arff");
                BufferedReader datafile = readDataFile(f); 
		Instances data = new Instances(datafile);
 
 
		kmeans.buildClusterer(data);
 
		// This array returns the cluster number (starting with 0) for each instance
		// The array has as many elements as the number of instances
		int[] assignments = kmeans.getAssignments();
 
		int i=0;
		for(int clusterNum : assignments) {
		    System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
		    i++;
		}
	}
}