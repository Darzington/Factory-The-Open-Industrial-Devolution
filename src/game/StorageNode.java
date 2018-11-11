package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayDeque;
import java.util.Queue;

import com.zalinius.architecture.input.Clickable;
import com.zalinius.physics.Point2D;

public class StorageNode extends Node {
	
	Item storageItemType;
	Queue<Item> storage;

	public StorageNode(MachineBaseNode base, Point2D center)
	{
		super(new Edge(1, new Point2D(0,0), new Point2D(1,1), base), center);
		storage = new ArrayDeque<>();
	}
	
	@Override
	public boolean inputItem(Item item)
	{
		if (storageItemType.isSameItem(item))
		{
			storage.add(item);
			return true;
		}
		else
		{
			storage.clear();
			//outputItem(new Garbage());
			return false;
		}
	}
	
	@Override
	public boolean isFull() {
		return !storage.isEmpty();
	}

	public Clickable getControls()
	{
		return new Clickable() {
			
			@Override
			public void mouseReleased() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked() {
				if (isFull())
				{
					outputItem(storage.remove());
				}				
			}
			
			@Override
			public int mouseButtonCode() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Shape clickArea() {
				return getClickArea();
			}
		};
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(Color.RED);
		drawRectangle(g);
	}

}
