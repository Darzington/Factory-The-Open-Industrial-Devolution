package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.Queue;

import com.zalinius.architecture.GameStage;
import com.zalinius.architecture.input.Clickable;
import com.zalinius.physics.Point2D;
import com.zalinius.utilities.ZMath;

public class StorageNode extends Node {
	
	Item storageItemType;
	Queue<Item> storage;
	private Node base;

	public StorageNode(MachineBaseNode base, Point2D center, Item storageItemType)
	{
		super(new Edge(center, base.getCenter(), base), center);
		storage = new ArrayDeque<>();
		this.storageItemType = storageItemType;
		GameStage.addInput(getControls());
		this.base = base;
	}
	
	public Node getBase() {
		return base;
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
			outputItem(new Garbage(storageItemType.getHeight(), storageItemType.getColor()));
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
				return MouseEvent.BUTTON1;
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
		drawFillLevel(g);
	}

	public void drawFillLevel(Graphics2D g) {
		//outer contour
		g.setColor(Color.WHITE);
		g.fillRect((int)center.x - 17, (int)center.y - 7, 34, 14);
		
		//Inner background
		g.setColor(Color.BLACK);
		g.fillRect((int)center.x - 15, (int)center.y - 5, 30, 10);
		
		//Fill Level
		int fill = ZMath.clamp(storage.size(), 0, 5);
		g.setColor(Color.GREEN);
		g.fillRect((int)center.x - 15, (int)center.y - 5, 6 * fill , 10);
	}
}
