package org.pl.tools.core.file;

import java.io.File;
import java.util.List;


public interface IFileConvert<T> {
	
	public  File toFile(AbstractFileModel<T> sourceModel);
	
	public  File toFile(List<AbstractFileModel<T>> sourceModel);
	
	
	
}
