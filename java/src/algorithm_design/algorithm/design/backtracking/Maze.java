package algorithm.design.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Maze {

	/**
	 * 表示迷宫地图上的坐标
	 * 
	 * @author Administrator
	 */
	public class Point {
		public int x;
		public int y;
	}

	public Point getPoint(int x, int y) {
		Point tmp = new Point();
		tmp.x = x;
		tmp.y = y;
		return tmp;
	}

	int N = 10;// 迷宫大小
	int ENTRY_X = 0, ENTRY_Y = 0;// 入口位置设为(0,0)
	int EXIT_X = N - 1, EXIT_Y = N - 1;// 出口位置设为(N-1,N-1)

	int[][] maze = new int[N][N];// 定义一个迷宫
	int pathCount = 0;// 路径的数量
	List<Point> Path = new ArrayList<>();// 路径，由坐标点集表示（有序）
	List<Point> BestPath = new ArrayList<>();// 最短路径

	boolean isFirst = true;// 当前路径是否为第一条路径

	/**
	 * 初始化迷宫地图
	 */
	public void initMaze() {
		// 定义迷宫地图
		int tmp[][] = { { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, // 0
				{ 1, 0, 0, 1, 1, 0, 0, 1, 0, 1 }, // 1
				{ 1, 0, 0, 1, 0, 0, 0, 1, 0, 1 }, // 2
				{ 1, 0, 0, 0, 0, 1, 1, 0, 0, 1 }, // 3
				{ 1, 0, 1, 1, 1, 0, 0, 0, 0, 1 }, // 4
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, // 5
				{ 1, 0, 1, 0, 0, 0, 1, 0, 0, 1 }, // 6
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 }, // 7
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 } // 9
		// 0 1 2 3 4 5 6 7 8 9
		};
		// 复制
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				maze[i][j] = tmp[i][j];
			}
		}
	}

	/**
	 * 参数为当前坐标点，初始位置是(0,0)
	 * 
	 * @param curr
	 */
	public void mazeBackTracking(Point curr) {
		// 先将当前点加入path，并将该店设置为已走过
		Path.add(curr);
		maze[curr.x][curr.y] = 1;
		System.out.println("Current point is: " + curr.x + ", " + curr.y);

		// 如果当前点是出口。。。
		if (curr.x == EXIT_X && curr.y == EXIT_Y) {
			pathCount++;// 路径数量加一
			// 可以打印一下路径
			Iterator<Point> pointIt = Path.iterator();
			while (pointIt.hasNext()) {
				Point tmp = pointIt.next();
				System.out.println("(" + tmp.x + "," + tmp.y + ")");
			}
			// 判断是否更加优化
			if (isFirst) {// 如果是第一条路径就是最优的
				BestPath.addAll(Path);
			} else {// 如果不是第一条
				if (Path.size() < BestPath.size()) {
					BestPath.clear();
					BestPath.addAll(Path);
				}
			}
		}

		// 不是出口的话，判断该位置的上下左右是否：（1）存在，不越界（2）可走，不是障碍物
		// 上：(x-1, y)
		if ((curr.x - 1) >= 0 && maze[curr.x - 1][curr.y] == 0) {
			// 递归判断
			Point next = new Point();
			next.x = curr.x - 1;
			next.y = curr.y;
			mazeBackTracking(next);
		}
		// 下：(x+1, y)
		if ((curr.x + 1) < N && maze[curr.x + 1][curr.y] == 0) {
			// 递归判断
			Point next = new Point();
			next.x = curr.x + 1;
			next.y = curr.y;
			mazeBackTracking(next);
		}
		// 左：(x,y-1)
		if ((curr.y - 1) >= 0 && maze[curr.x][curr.y - 1] == 0) {
			// 递归判断
			Point next = new Point();
			next.x = curr.x;
			next.y = curr.y - 1;
			mazeBackTracking(next);
		}
		// 右：(x,y+1)
		if ((curr.y + 1) < N && maze[curr.x][curr.y + 1] == 0) {
			// 递归判断
			Point next = new Point();
			next.x = curr.x;
			next.y = curr.y + 1;
			mazeBackTracking(next);
		}

		// 都不满足就返回上一个step
		Path.remove(curr);
		maze[curr.x][curr.y] = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maze mazeTest = new Maze();
		mazeTest.initMaze();
		Point currentPoint = mazeTest.getPoint(mazeTest.ENTRY_X,
				mazeTest.ENTRY_Y);
		mazeTest.mazeBackTracking(currentPoint);
		System.out.println("Path number is: " + mazeTest.pathCount);
		Iterator<Point> pointsIt = mazeTest.BestPath.iterator();
		while (pointsIt.hasNext()) {
			Point tmp = pointsIt.next();
			System.out.println("(" + tmp.x + "," + tmp.y + ")");
		}
	}

}