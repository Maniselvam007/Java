// Online Java Compiler
import java.util.Scanner;

class NeuralNetwork {
    private int numLayers; //initializing the layers in the class
    private int[] numNodes; //initializing the nodes in the class
    private double[][][] weights; //initializing  the weights 3D inside the class 

    public NeuralNetwork(int numLayers, int[] numNodes) { //constructor 
        this.numLayers = numLayers; //set the values in the class using the constructor
        this.numNodes = numNodes;
        this.weights = new double[numLayers - 1][][];
        for (int i = 0; i < numLayers - 1; i++) {
            weights[i] = new double[numNodes[i]][numNodes[i + 1]];// set the weights
        }
    }

    public void setWeight(int layer, int nodeFrom, int nodeTo, double weight) { //setters and getters respectively ...
        weights[layer - 1][nodeFrom - 1][nodeTo - 1] = weight;
    }

    public double getWeight(int layer, int nodeFrom, int nodeTo) {
        return weights[layer - 1][nodeFrom - 1][nodeTo - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    //Scanner to get input

        System.out.print("Enter the number of layers: ");
        int numLayers = scanner.nextInt();

        int[] numNodes = new int[numLayers];   // getting inputs from the user
        for (int i = 0; i < numLayers; i++) {
            System.out.print("Enter the number of nodes in layer " + (i + 1) + ": ");
            numNodes[i] = scanner.nextInt();
        }

        NeuralNetwork network = new NeuralNetwork(numLayers, numNodes); //creating a object from the class using constructor to set the layes and nodes 

        for (int i = 1; i < numLayers; i++) {   // set weight values for each nodes in the layers
            for (int j = 1; j <= numNodes[i - 1]; j++) {
                for (int k = 1; k <= numNodes[i]; k++) {
                    System.out.print("Enter the weight for edge from node " + j + " in layer " + i + " to node " + k + " in layer " + (i + 1) + ": ");
                    double weight = scanner.nextDouble();
                    network.setWeight(i, j, k, weight);   // set weight function call 
                }
            }
        }

        System.out.println("Weights set successfully!");

        System.out.print("Enter the layer number: "); // to get the weight of the respective node from the object
        int layer = scanner.nextInt();
        System.out.print("Enter the node number: ");
        int nodeFrom = scanner.nextInt();
        System.out.print("Enter the destination node number: ");
        int nodeTo = scanner.nextInt();

        double weight = network.getWeight(layer, nodeFrom, nodeTo);
        System.out.println("Weight of edge from node " + nodeFrom + " to node " + nodeTo + " in layer " + layer + " is " + weight);
    }
}
