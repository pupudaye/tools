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
    	// ����Excel���
    	HSSFWorkbook workBook = new HSSFWorkbook();
    	//�½�sheet
    	HSSFSheet sheet = workBook.createSheet();
    	//�����п������Ӧ��iΪ�е���ţ����㿪ʼ
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
