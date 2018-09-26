package org.pl.sports.tools.entity;

import javax.swing.table.AbstractTableModel;

import org.pl.sports.tools.ComponenttLifecycle;

public class MatchTableModel extends AbstractTableModel implements ComponenttLifecycle {

//	// 定义一维数据作为列标题
	private static Object[] columnTitle = { "姓名", "年龄", "性别" };
//	
//	// 定义二维数组作为表格数据
	private static Object[][] tableData = { new Object[] { "李清照", 29, "女" },
			new Object[] { "苏格拉底", 56, "男" },
			new Object[] { "李白", 35, "男" }, new Object[] { "弄玉", 18, "女" },
			new Object[] { "虎头", 2, "男" } };
	
	private Thread scanThread;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7100129465220186868L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnTitle.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return tableData.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return tableData[row][col]+String.valueOf(System.currentTimeMillis());
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		scanThread=new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// 扫描网站地址数据.....
				while (true) {
					try {
						Thread.sleep(Long.valueOf(GlobalConfigFactory.getInstance().getConfig().getIntervalTime()));
						
						//每隔1秒钟更新JTable
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		scanThread.start();
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void close() {
		// TODO Auto-generated method stub
		scanThread.stop();
	}

}
