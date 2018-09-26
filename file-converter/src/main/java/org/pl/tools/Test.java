package org.pl.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String words_cn="d://words_cn.txt";
		String words_en="d://words_en.txt";
		
		InputStreamReader is_cn = new InputStreamReader(new FileInputStream(words_cn), "GBK"); //或GB2312,GB18030
        BufferedReader read_cn = new BufferedReader(is_cn);
        InputStreamReader is_en = new InputStreamReader(new FileInputStream(words_en), "GBK"); //或GB2312,GB18030
        BufferedReader read_en = new BufferedReader(is_en);
        
        int count_cn=0;
        int count_en=0;
        
        int epcount=0;
		String line_cn = read_cn.readLine();
		String line_en = read_en.readLine();
		
		while (line_cn != null&&line_en!=null) {
			if(!line_cn.contains("#")&&!line_en.contains("#")&&line_cn.length()>0&&line_en.length()>0){
//					System.out.println(line_cn);
//					System.out.println(line_en);
					String key_cn=line_cn.substring(0, line_cn.indexOf("="));
					String key_en=line_en.substring(0, line_en.indexOf("="));
					String cn=line_cn.substring(line_cn.indexOf("=")+1,line_cn.length());
					String en=line_en.substring(line_en.indexOf("=")+1,line_en.length());
					if(key_cn.equals(key_en)){
						epcount++;
						System.out.println(key_cn+"	"+cn+"	"+en);
					}else{
						throw new Exception(key_cn+"=="+key_en);
					}
			}else{
				System.out.println(line_cn+"	"+line_en+"	"+line_en);
//				System.out.println(line_cn);
//				System.out.println(line_en);
			}
			count_cn++;
			count_en++;
			line_cn = read_cn.readLine();
			line_en = read_en.readLine();
			
		}
		read_cn.close();
		read_en.close();
		System.out.println("epcount:"+epcount);
		System.out.println("count_cn:"+count_cn+",count_en:"+count_en);
	}
	

	
}
