package levels;

import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Queue;

import com.zalinius.physics.Point2D;

import java.awt.*;

import game.AssemblyLine;
import game.CerealBox;
import game.Conveyor;
import game.Edge;
import game.FillerMachine;
import game.Input;
import game.Item;
import game.MachineBaseNode;
import game.Prize;
import game.ShippingTruck;
import game.StorageNode;

public class Line0 extends AssemblyLine{

	static final int N = 10, ITEM_FREQUENCY = 3;
	static final Point2D END = new Point2D(570, 550),
			STORAGE_NODE_TOP = new Point2D(300, 550),
			STORAGE_NODE_BOTTOM = new Point2D(300, 550),
			START = new Point2D(50, 550);
	
	public Line0() {
		super(fullLine());
	}

	private static Queue<Item> items(){
		Queue<Item> queue = new ArrayDeque<>();
		
		for(int i = 0; i != N; ++i) {
			if (Math.random() < 0.5)
			{
				queue.add(new CerealBox());
			}
			else
			{
				queue.add(new Prize());
			}
		}
		
		return queue;
	}
	
	private static Input fullLine() {
		ShippingTruck truck = new ShippingTruck(END);
		Edge truckConveyor = new Conveyor(STORAGE_NODE_BOTTOM, END, truck);
		
		FillerMachine fillerNode = new FillerMachine(truckConveyor, 1, STORAGE_NODE_BOTTOM, FillerMachine.Filler.CEREAL);
		//StorageNode storageNode = new StorageNode(fillerNode, STORAGE_NODE_TOP, new CerealBox());
		//fillerNode.connectToStorageNode(storageNode);
		
		Edge startConveyor = new Conveyor(START, STORAGE_NODE_BOTTOM, fillerNode);
		
		Input start = new Input(items(), ITEM_FREQUENCY, START);		
		start.addOutgoingEdge(startConveyor);

		
		return start;
	}
	
}
