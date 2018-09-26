package org.pl.tools.core.file;

import java.io.File;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;




public class ExcelFileConvert   implements IFileConvert<KeyValueModel> {


	@Override
	public File toFile(AbstractFileModel<KeyValueModel> sourceModel) {
		// TODO Auto-generated method stub
    	List<KeyValueModel> kvs=sourceModel.getData();
    	// 生成Excel表格
    	HSSFWorkbook workBook = new HSSFWorkbook();
    	//新建sheet
    	HSSFSheet sheet = workBook.createSheet();
    	//设置列宽度自适应，i为列的序号，从零开始
    	for (int i = 0; i < 2; i++) {
    	    sheet.autoSizeColumn(i, true);
    	}
    	
		return null;
	}

	@Override
	public File toFile(List<AbstractFileModel<KeyValueModel>> sourceModel) {
		// TODO Auto-generated method stub
		return null;
	}










}
