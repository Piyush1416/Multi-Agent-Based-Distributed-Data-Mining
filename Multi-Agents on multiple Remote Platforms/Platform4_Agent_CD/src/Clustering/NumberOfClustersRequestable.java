
package Clustering;


public interface NumberOfClustersRequestable {
  
  /**
   * Set the number of clusters to generate
   *
   * @param numClusters the number of clusters to generate
   * @exception Exception if the requested number of 
   * clusters in inapropriate
   */
  void setNumClusters(int numClusters) throws Exception;

}
