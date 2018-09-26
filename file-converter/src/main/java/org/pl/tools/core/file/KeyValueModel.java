package org.pl.tools.core.file;

public class KeyValueModel extends AbstractDataModel {

	public String key;
	public String value;
	
	public KeyValueModel(String key,String value){
		this.key=key;
		this.value=value;
	}
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	
	
}
