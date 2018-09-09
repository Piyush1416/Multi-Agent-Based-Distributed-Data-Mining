# Multi-Agent-Based-Distributed-Data-Mining
Java Jade based Intelligent agent which exhibited property of independent and autonomous communication with each other and carried out various Machine Learning operations.

In this implementation we have created two scenario:- 

1] Multi-agents implemented on same platform. 

2] Multi-agent on multiple remote platforms. 

As per research paper “Multi-Agent Distributed Data Mining by Ontologies” 

We will be creating 4 agents as follows:- 1] User agent, 2] Coordinating Agent, 3] Data Agent  and 4] Clustering Agent. 

Each agent will communicate with partner agent using ACL messaging service of jade.

In single platform system where each agent is been implemented in different container on same system, communication is made easy using just the receiving agents local name, whereas in multiplatform system we need to use Global unique platform address which is been available as MTP(Message Transfer Protocol) address for carrying out inter-agent communication.

Each agent is been designed to work on its specific role. The work of User Agent is to get user input for value of K which decides number of Clusters. Data Agent is just like User Agent it relies on user input but for dataset which will be used for carrying out clustering. Coordinating Agent works as a management agent coordinating input messages and delivering them to respective agents. Clustering agent works as final agent who receives value of K and dataset from coordinating agent and finally calls up the clustering algorithm.

Finally we have weka based K-means Clustering Algorithm which takes input of K and dataset and performs clustering and gives out result of dataset instances by grouping them in cluster’s.
