package mazeProduce;
import java.awt.EventQueue;

public class AlgoVisualizer {
	private static int blockSide = 5;
	private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	private MazeData data;
	private AlgoFrame frame;
	private static int DELAY = 3;
	int position;
	public AlgoVisualizer(int N,int M) {
		data = new MazeData(N,M);
		int sceneWidth = data.getM()*blockSide;
		int sceneHeight = data.getN()*blockSide;
		
		//初始化视图
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("random maze",sceneWidth,sceneHeight);
			
			new Thread(() -> {
				run();
			}).start();
		});
	}
	
	public void run() {
		go(1,1);
		setData(-1,-1);
	}
	
	private void go(int x,int y) {
		
		if(!data.inArea(x, y))
			throw new IllegalArgumentException("x and y are out of index in go function");

		data.visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int newX = x+d[i][0]*2;
			int newY = y+d[i][1]*2;
			if(data.inArea(newX, newY) && !data.visited[newX][newY]) {
				setData(x+d[i][0],y+d[i][1]);
				go(newX,newY);
			}
				
		}
	}
	//有时会在数据变动之后才会渲染，因此把渲染代码放在方法里方便调用
	private void setData(int x,int y) {
		if(data.inArea(x, y))
			data.maze[x][y] = MazeData.ROAD;
		frame.render(data);
		AlgoVisHelper.pause(DELAY);
	}

	public static void main(String[] args) {
		AlgoVisualizer algo = new AlgoVisualizer(101,101);
	}
}
