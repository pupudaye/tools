package org.pl.sports.tools.ui;

import org.pl.sports.tools.ComponenttLifecycle;
import org.pl.sports.tools.entity.MatchTableModel;

public class ScanManager implements ComponenttLifecycle {

	private Thread scanThread;
	
	private MatchTable matchTable;
	
	private MatchTableModel tableModel;
	public ScanManager(MatchTable matchTable){
		this.matchTable=matchTable;
		tableModel=(MatchTableModel) matchTable.getModel();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		scanThread=new Thread(matchTable);
		scanThread.start();
		tableModel.init();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void close() {
		// TODO Auto-generated method stub
		if(scanThread.isAlive()){
			scanThread.stop();
			tableModel.close();
		}
	}

}
