package mazeProduce;

public class MazeData {

	public static final char ROAD = ' ';
	public static final char WALL = '#';
	
	private int N,M;
	public char[][] maze;
	private int entranceX,entranceY;
	private int exitX,exitY;
	public boolean[][] visited;
	public int getN() {
		return N;
	}

	public int getM() {
		return M;
	}
	

	public int getEntranceX() {
		return entranceX;
	}

	public int getEntranceY() {
		return entranceY;
	}

	public int getExitX() {
		return exitX;
	}

	public int getExitY() {
		return exitY;
	}

	public MazeData(int N,int M) {
		if(N%2 == 0 || M%2 == 0)
			throw new IllegalArgumentException("Our Maze Generalization Algorihtm requires the width and height of the maze are odd numbers");
		
		this.N = N;
		this.M = M;
		maze = new char[N][M];
		visited = new boolean[N][M];
		this.entranceX = 1;
		this.entranceY = 0;
		this.exitX = N-2;
		this.exitY = M-1;
		//横纵坐标都为奇数时为路
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i%2 == 1 && j%2 == 1)
					maze[i][j] = ROAD;
				else
					maze[i][j] = WALL;
				visited[i][j] = false;
			}
		}
		maze[entranceX][entranceY] = ROAD;
		maze[exitX][exitY] = ROAD;
	}
	public char getMaze(int i,int j) {
		if(inArea(i,j) == false)
			throw new IllegalArgumentException("i or j is out of index in getMaze!");
		
		return maze[i][j];
	}
	
	//判断坐标是否在迷宫内
	public boolean inArea(int x,int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	
	
	public void print() {
		System.out.println(N+" "+M);
		for(int i=0;i<N;i++) {	
			for(int j=0;j<M;j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
}
