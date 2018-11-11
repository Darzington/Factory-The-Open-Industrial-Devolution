package levels;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import com.zalinius.physics.Point2D;

import game.*;

public class Line1 extends AssemblyLine {

	public Line1() {
		super(fullLine());
	}

	static final int ITEM_FREQUENCY = 1;
	static final Point2D END = new Point2D(200, 600),
						 CEREAL_FILLER_BOT = new Point2D(400, 600),
						 PRIZE_FILLER_HOPPER = new Point2D(600, 300),
						 PRIZE_FILLER_TOP = new Point2D(600, 500),
						 PRIZE_FILLER_BOT = new Point2D(600, 600),
						 BOX_DROPPER_HOPPER = new Point2D(1000, 300),
						 BOX_DROPPER_TOP = new Point2D(1000, 500),
						 BOX_DROPPER_BOT = new Point2D(1000, 600),
						 START = new Point2D(200, 300);
	
	private static Queue<Item> items(){
		Queue<Item> queue = new ArrayDeque<>();
		for(int i = 0; i != Level1.N; ++i) {
			if (i < Level1.N/2){
				queue.add(new CerealBox());
			}
			else{
				queue.add(new Prize());
			}
		}
		return queue;
	}
	
	private static Input fullLine() {
		ShippingTruck truck = new ShippingTruck(END);
		Edge truckConveyor = new Conveyor(CEREAL_FILLER_BOT, END, truck);
		FillerMachine cerealFiller = new FillerMachine(truckConveyor, 1, CEREAL_FILLER_BOT, CerealBox.cerealFiller());
		Edge c1 = new Conveyor(PRIZE_FILLER_BOT, CEREAL_FILLER_BOT, cerealFiller);
		FillerMachine prizeFiller = new FillerMachine(c1, 1, PRIZE_FILLER_BOT, CerealBox.prizeFiller());
		Edge c2 = new Conveyor(BOX_DROPPER_BOT, PRIZE_FILLER_BOT, prizeFiller);
		
		
		MachineBaseNode boxBase = new MachineBaseNode(false, c2, 0, BOX_DROPPER_BOT);
		Node boxStorage = new StorageNode(boxBase, BOX_DROPPER_TOP, new CerealBox());
		Edge c3 = new Conveyor(BOX_DROPPER_HOPPER, BOX_DROPPER_TOP, boxStorage);
		Node upRightCorner = new Node(c3, BOX_DROPPER_HOPPER);
		upRightCorner.togglePoweredStatus();
		
		Edge c4 = new Conveyor(PRIZE_FILLER_HOPPER, BOX_DROPPER_HOPPER, upRightCorner);
		
		StorageNode prizeStorage = new StorageNode(prizeFiller, PRIZE_FILLER_TOP, new Prize());
		//prizeFiller.connectToStorageNode(prizeStorage);

		Edge c5 = new Conveyor(PRIZE_FILLER_HOPPER, PRIZE_FILLER_TOP, prizeStorage);

		ArrayList<Edge> prizeDistEdges = new ArrayList<>();
		prizeDistEdges.add(c4);	
		prizeDistEdges.add(c5);
		Node prizeDistributor = new DirectionalDistributor(PRIZE_FILLER_HOPPER, prizeDistEdges);
		prizeDistributor.togglePoweredStatus();
		
		Edge startConveyor = new Conveyor(START, PRIZE_FILLER_HOPPER, prizeDistributor);		
		Input start = new Input(items(), ITEM_FREQUENCY, START);		
		start.addOutgoingEdge(startConveyor);

		
		return start;
	}
	

}
