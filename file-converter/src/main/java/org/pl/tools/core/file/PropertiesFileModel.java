package org.pl.tools.core.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PropertiesFileModel extends AbstractFileModel<KeyValueModel> {

	public PropertiesFileModel(){
		
	}
	
	public PropertiesFileModel(File sourceFile){
		super(sourceFile);
	}
	
	@Override
	public List<KeyValueModel> getData() {
		// TODO Auto-generated method stub
		List<KeyValueModel> kvs=new ArrayList<KeyValueModel>();
		if(sourceFile==null){
			logger.error("must be setter sourceFile!");
		}
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(sourceFile), "GBK"); //»òGB2312,GB18030
			BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			while (line != null) {
				if(!line.contains("#")&&line.length()>0){
						String key=line.substring(0, line.indexOf("="));
						String value=line.substring(line.indexOf("=")+1,line.length());
						KeyValueModel kv=new KeyValueModel(key,value);
						kvs.add(kv);
				}else{
					logger.warn("Invalid characters found! Str="+line);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kvs;
	}
	
}
