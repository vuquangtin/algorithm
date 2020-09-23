package thuattoan.btvedp;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class AllPairsShortestPath {

	// This algo implementation calculates shortest path all pair of vertices
	// Dijkstra algo can also be used for the same.
	// Time complexity O(n^3)
	public static void getAllPairsShortestPath(int[][] graph, int vertices) {

		// for intermediate matrices
		for (int k = 0; k < vertices; k++) {

			// for matrix
			for (int i = 0; i < vertices; i++) {
				for (int j = 0; j < vertices; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}

			System.out.println("For K = " + k);
			for (int i = 0; i < vertices; i++) {
				System.out.println();
				for (int j = 0; j < vertices; j++) {
					System.out.print(" \t" + graph[i][j]);
				}
			}
			System.out.println();
			System.out.println();
		}
	}

	public static void main(String... args) {

		// 100 = infinity
		int graph[][] = new int[4][4];
		graph[0][0] = 0;
		graph[0][1] = 3;
		graph[0][2] = 100;
		graph[0][3] = 7;
		graph[1][0] = 8;
		graph[1][1] = 0;
		graph[1][2] = 2;
		graph[1][3] = 100;
		graph[2][0] = 5;
		graph[2][1] = 100;
		graph[2][2] = 0;
		graph[2][3] = 1;
		graph[3][0] = 2;
		graph[3][1] = 100;
		graph[3][2] = 100;
		graph[3][3] = 0;

		getAllPairsShortestPath(graph, 4);
	}
}
