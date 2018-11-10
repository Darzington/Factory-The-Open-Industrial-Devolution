package levels;

import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Queue;

import java.awt.*;

import game.AssemblyLine;
import game.Input;
import game.Item;

public class Line0 extends AssemblyLine{

	static final int N = 20;
	
	public Line0() {
		super(fullLine());
	}

	private static Queue<Item> items(){
		Queue<Item> queue = new ArrayDeque<>();
		
		for(int i = 0; i != N; ++i) {
			queue.add(new Item() {
				
				@Override
				public void update(double delta) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void render(Graphics2D g) {
					g.setColor(Color.BLUE);
					g.drawRect((int)getPosition().x(), (int)getPosition().y(), 10, 10);
				}
			});
		}
		
		return queue;
	}
	
	private static Input fullLine() {
		Input start = new Input(items(), 1.0);		
		
		return start;
	}
	
}
