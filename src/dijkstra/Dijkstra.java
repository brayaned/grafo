package dijkstra;

import java.util.Scanner;

public class Dijkstra {

    public int distance[] = new int[10];
    public int cost[][] = {{0,10,999,999,5,999,999,999,999,999,999,999,999,999,999,999},
                           {10,0,10,999,999,999,999,999,999,999,999,999,999,999,999,999},
                           {999,10,0,10,999,999,999,999,999,999,999,999,999,999,999,999},
                           {999,999,10,0,10,999,999,999,999,999,999,999,999,999,999,999},
                           {5,999,999,10,0,10,999,999,999,5,999,999,999,999,999,999},
                           {999,999,999,999,10,0,10,999,999,999,999,999,999,999,999,999},
                           {999,999,999,999,999,10,0,10,999,999,999,999,999,999,999,999},
                           {999,999,999,999,999,999,10,0,10,999,999,999,999,999,999,999},
                           {999,999,999,999,999,999,999,10,0,10,999,999,999,999,999,999},
                           {999,999,999,999,5,999,999,999,10,0,10,999,999,999,5,999},
                           {999,999,999,999,999,999,999,999,999,10,0,10,999,999,999,999},
                           {999,999,999,999,999,999,999,999,999,999,10,0,10,999,999,999},
                           {999,999,999,999,999,999,999,999,999,999,999,10,0,10,999,999},
                           {999,999,999,999,999,999,999,999,999,999,999,999,10,0,10,999},
                           {999,999,999,999,5,999,999,999,999,999,999,999,999,10,0,5},
                           {999,999,999,999,999,999,999,999,999,999,999,999,999,999,5,0}};

    public void calc(int n, int s) {
        int flag[] = new int[n + 1];
        int i, minpos = 1, k, c, minimum;

        for (i = 1; i <= n; i++) {
            flag[i] = 0;
            this.distance[i] = this.cost[s][i];
        }
        c = 2;
        while (c <= n) {
            minimum = 99;
            for (k = 1; k <= n; k++) {
                if (this.distance[k] < minimum && flag[k] != 1) {
                    minimum = this.distance[i];
                    minpos = k;
                }
            }
            flag[minpos] = 1;
            c++;
            for (k = 1; k <= n; k++) {
                if (this.distance[minpos] + this.cost[minpos][k] < this.distance[k] && flag[k] != 1) {
                    this.distance[k] = this.distance[minpos] + this.cost[minpos][k];
                }
            }
        }

    }

    public static void main(String[] args) {
        int nodes, source, i, j;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number of Nodes \n");
        
        Dijkstra d = new Dijkstra();
        nodes=d.cost.length;
        /*
        System.out.println("Enter the Cost Matrix Weights: \n");
        for (i = 1; i <= nodes; i++) {
            for (j = 1; j <= nodes; j++) {
                d.cost[i][j] = in.nextInt();
                if (d.cost[i][j] == 0) {
                    d.cost[i][j] = 999;
                }
            }
        }
        */
        for (i = 0; i < nodes; i++) {
            for (j = 0; j <nodes; j++) {
                System.out.print(d.cost[i][j]+" ");
            }
            System.out.println("\n");
        }
        System.out.println("Enter the Source Vertex :\n");
        source = in.nextInt();

        d.calc(nodes, source);
        System.out.println("The Shortest Path from Source \t" + source + "\t to all other vertices are : \n");
        for (i = 1; i <= nodes; i++) {
            if (i != source) {
                System.out.println("source :" + source + "\t destination :" + i + "\t MinCost is :" + d.distance[i] + "\t");
            }
        }
    }

}
