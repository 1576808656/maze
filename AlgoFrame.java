package mazeProduce;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgoFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private class AlgoCanvas extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public AlgoCanvas() {
			//打开双缓存
			super(true);
		}
		
		//具体的绘制
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			
			//抗锯齿
			RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
											RenderingHints.VALUE_ANTIALIAS_ON);
			int w = canvasWidth/data.getM();
			int h = canvasHeight/data.getN();
			for(int i=0;i<data.getN();i++) {
				for(int j=0;j<data.getM();j++) {
					if(data.getMaze(i, j) == MazeData.WALL)
						AlgoVisHelper.setColor(g2d, Color.BLUE);
					else
						AlgoVisHelper.setColor(g2d, Color.white);
//					if(data.path[i][j])
//						AlgoVisHelper.setColor(g2d, Color.yellow);
					AlgoVisHelper.strokeFillRectangle(g2d, j*w, i*h, w, h);
//					if(data.result[i][j]) {
//						AlgoVisHelper.setColor(g2d, Color.red);
//						AlgoVisHelper.strokeFillRectangle(g2d, j*w, i*h, w-1, h-2);
//					}
				}
			}
		}
		
		//自动调用该方法进行画布大小设置
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
		}
	}
	
	private MazeData data;
	public void render(MazeData data) {
		this.data = data;
		repaint();
	}

	private int canvasWidth;
	private int canvasHeight;
	
	public int getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	public AlgoFrame(String title,int canvasWidth,int canvasHeight) {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		AlgoCanvas canvas = new AlgoCanvas();
		//设置画布大小
		canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
		setContentPane(canvas);
		//根据画布大小调整窗口大小
		pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public AlgoFrame(String title) {
		super(title);
		AlgoCanvas canvas = new AlgoCanvas();
		//设置画布大小
		canvas.setPreferredSize(new Dimension(1024,768));
		setContentPane(canvas);
		//根据画布大小调整窗口大小
		pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
