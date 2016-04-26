package view;

import java.util.ArrayList;
import java.util.TimerTask;
import model.*;
import model.map.Map;
import model.mobs.Mobs;

public class moveTask extends TimerTask {
	private ArrayList<Mobs> mobsToMove;
	private Map map;
	
	public moveTask(Map serverMap){
		this.map = serverMap;
		mobsToMove = map.getMobsToAdd();
	}
	@Override
	public void run() {
		for(int i=0; i<mobsToMove.size(); i++){
			mobsToMove.get(i).move();
		}
	}
}