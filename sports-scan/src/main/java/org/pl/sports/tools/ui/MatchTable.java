package org.pl.sports.tools.ui;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.pl.sports.tools.ComponenttLifecycle;
import org.pl.sports.tools.entity.GlobalConfigFactory;

public class MatchTable extends JTable implements ComponenttLifecycle,Runnable {

	
	/**	
	 * 
	 */
	private static final long serialVersionUID = -3066126822598796507L;
	
	public MatchTable(TableModel dataModel){
		super(dataModel);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(Long.valueOf(GlobalConfigFactory.getInstance().getConfig().getIntervalTime()));
				//每隔1秒钟更新JTable
				this.validate();
				this.updateUI();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
