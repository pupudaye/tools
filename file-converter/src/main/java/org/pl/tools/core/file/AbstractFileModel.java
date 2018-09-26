package org.pl.tools.core.file;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFileModel<T> implements IFileAttribute {
	
	protected final static Logger logger = LoggerFactory.getLogger(AbstractFileModel.class);
	
	protected File sourceFile;
	
	
	public AbstractFileModel(){
		
	}
	
	public AbstractFileModel(File sourceFile){
		this.sourceFile=sourceFile;
	}
	
	public abstract  List<T> getData();

	
	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhysicalPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
