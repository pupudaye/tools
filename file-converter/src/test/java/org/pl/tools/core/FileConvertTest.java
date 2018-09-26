package org.pl.tools.core;

import java.io.File;
import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.pl.tools.core.file.AbstractFileModel;
import org.pl.tools.core.file.ExcelFileConvert;
import org.pl.tools.core.file.ExcelFileModel;
import org.pl.tools.core.file.IFileConvert;
import org.pl.tools.core.file.PropertiesFileModel;

/**
 * Unit test for simple App.
 */
public class FileConvertTest 
    extends TestCase
{
	private ClassLoader classLoader = getClass().getClassLoader();
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FileConvertTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FileConvertTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testExcelConvertData()
    {
    	ExcelFileConvert excelFileConvert =new ExcelFileConvert();
    	URL url = classLoader.getResource("words_cn.txt");
    	File sourceFile=new File(url.getFile());
    	PropertiesFileModel sourceModel=new PropertiesFileModel(sourceFile);
    	File targetFile= excelFileConvert.toFile(sourceModel);
        assertNotNull(targetFile);
    }
}
