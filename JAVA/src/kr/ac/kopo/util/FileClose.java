package kr.ac.kopo.util;

import java.io.InputStream;
import java.io.OutputStream;

public class FileClose {

	public static void close(InputStream is) {
		if(is !=null) {
			try {
				is.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(OutputStream os) {
		if(os != null) {
			try {
				os.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(InputStream bis ,InputStream is) {
		close(bis);
		close(is);
		
	}
	public static void close(OutputStream bos ,OutputStream os) {
		close(bos);
		close(os);
	}
}
