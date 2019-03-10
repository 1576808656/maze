package mazeProduce;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class AlgoVisHelper {
	private AlgoVisHelper() {}
	
	public static void setColor(Graphics2D g2d,Color color) {
		g2d.setColor(color);
	}
	
	//设置笔画宽度
	public static void setStrokeWidth(Graphics2D g2d, int w) {
		int strokeWidth = w;
		g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}
	//绘制空心圆
	public static void strokeCircle(Graphics2D g2d,int x,int y,int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
		g2d.draw(circle);
	}
	//绘制实心圆
	public static void strokeFillCircle(Graphics2D g2d,int x,int y,int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
		g2d.fill(circle);
	}
	//绘制矩形
	public static void strokeRectangle(Graphics2D g2d,int x,int y,int w,int h) {
		Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
		g2d.draw(rectangle);
	}
	
	public static void strokeFillRectangle(Graphics2D g2d,int x,int y,int w,int h) {
		Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
		g2d.fill(rectangle);
	}
	
	//两次方法执行间隔多少毫秒
	public static void pause(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
