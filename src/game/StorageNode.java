package game;

import java.awt.Event;
import java.util.ArrayDeque;
import java.util.Queue;

import com.zalinius.architecture.input.Inputtable;

public class StorageNode extends Node {
	
	Edge outputEdge;
	Item storageItemType;
	Queue<Item> storage;

	public StorageNode(Edge outputEdge)
	{
		super();
		this.outputEdge = outputEdge;
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
	protected Edge selectOutgoingEdge() {
		return outputEdge;
	}
	
	@Override
	public boolean isFull() {
		return !storage.isEmpty();
	}

	public Inputtable getControls()
	{
		return new Inputtable() {
			
			@Override
			public void released() {
				if (isFull())
				{
					outputItem(storage.remove());
				}
			}
			
			@Override
			public void pressed() {
				
			}
			
			@Override
			public int keyCode() {
				return Event.MOUSE_DOWN;
			}
		};
	}

}
