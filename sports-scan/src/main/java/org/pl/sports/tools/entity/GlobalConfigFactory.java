package org.pl.sports.tools.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;


public class GlobalConfigFactory {

	

	private static volatile  GlobalConfigFactory configFactory;
	
	private final static String prefix="global.setting";
	
	private Config config;
	
	private String filename;
	
	private HashMap<String, String> configValue=new HashMap<String, String>();
	
	private GlobalConfigFactory(String phone,int intervalTime,int syncSwitch){
		config=new Config(phone,intervalTime,syncSwitch);
	}
	
	public static GlobalConfigFactory getInstance(String phone,int intervalTime,int syncSwitch){
		if(configFactory==null){
			synchronized (GlobalConfigFactory.class) {
				if(configFactory==null){
					configFactory=new GlobalConfigFactory(phone,intervalTime,syncSwitch);
				}
			}
		}
		return configFactory;
	}
	public static GlobalConfigFactory getInstance(){
		return configFactory;
	}
	public  void put(String key,String value){
		configValue.put(prefix+"."+key, value);
		if("phone".equals(key)){
			config.phone=value;
		}else if("intervalTime".equals(key)){
			config.intervalTime=Integer.valueOf(value);
		}else if("syncSwitch".equals(key)){
			config.syncSwitch=Integer.valueOf(value);
		}
	}
	
	public  void store(){
		if(configValue.size()==0)return;
		FileInputStream in=null;
		FileOutputStream fos=null;
		try {
			String filepath = GlobalConfigFactory.class.getClassLoader().getResource(filename).getFile();
			Properties props = new Properties();
			in = new FileInputStream(filepath);  
			props.load(in);
			fos = new FileOutputStream(filepath); 
			for (String key : configValue.keySet()) {
				props.setProperty(key, configValue.get(key));
			}
			props.store(fos, null);   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(in!=null){
					in.close();
				}
				if(fos!=null){
					fos.close();// 关闭流 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	public Config getConfig() {
		return config;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	public class Config{
		
		private String phone;
		
		private int intervalTime;
		
		private int syncSwitch;
		
		public Config(String phone,int intervalTime,int syncSwitch){
			this.phone=phone;
			this.intervalTime=intervalTime;
			this.syncSwitch=syncSwitch;
		}
		
		public String getPhone() {
			return phone;
		}

		public int getIntervalTime() {
			return intervalTime;
		}
		public int getSyncSwitch() {
			return syncSwitch;
		}

	}
	
	
}
