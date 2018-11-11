package levels;

import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Queue;

import com.zalinius.physics.Point2D;

import java.awt.*;

import game.AssemblyLine;
import game.Conveyor;
import game.Input;
import game.Item;

public class Line0 extends AssemblyLine{

	static final int N = 100;
	
	public Line0() {
		super(fullLine());
	}

	private static Queue<Item> items(){
		Queue<Item> queue = new ArrayDeque<>();
		
		for(int i = 0; i != N; ++i) {
			queue.add(new Item(new Point2D(50, 550)) {
				
				@Override
				public void update(double delta) {

				}
				
				@Override
				public void render(Graphics2D g) {
					g.setColor(Color.BLUE);
					g.drawRect((int)getPosition().x, (int)getPosition().y - 12, 10, 10);
				}
			});
		}
		
		return queue;
	}
	
	private static Input fullLine() {
		Input start = new Input(items(), 0.3);		
		
		start.addOutgoingEdge(new Conveyor(new Point2D(50, 550), new Point2D(570, 550)));;
		
		return start;
	}
	
}
