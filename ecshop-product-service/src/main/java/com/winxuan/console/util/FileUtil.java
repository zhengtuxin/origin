package com.winxuan.console.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 文件操作
 * 
 * @author ztx
 */
public class FileUtil {

	static final Logger LOG = Logger.getLogger(FileUtil.class);

	/**
	 * 写入到文件
	 * @param file
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static File writeFile(File file, InputStream is) throws Exception{
		FileOutputStream os = new FileOutputStream(file);
		byte[] bytes = new byte[1024];
		int index = -1;
		while(-1 != (index = is.read(bytes)))
			os.write(bytes, 0, index);
		is.close();
		os.close();
		return file;
	}
	
	/**
	 * 读取文件为list
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> readFileForList(File file) {

		if (file == null) {
			return null;
		}
		InputStreamReader read = null;
		BufferedReader in = null;
		List<String> list = new ArrayList<String>();
		try {
			read = new InputStreamReader(new FileInputStream(file), "UTF-8");
			in = new BufferedReader(read);
			String line = "";
			while ((line = in.readLine()) != null) {
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			LOG.error("file not found : " + file.getAbsolutePath(), e);
		} catch (IOException e) {
			LOG.error("read file error : " + file.getAbsolutePath(), e);
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
					LOG.error("close file error : " + file.getAbsolutePath(), e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					LOG.error("close file error : " + file.getAbsolutePath(), e);
				}
			}
		}
		return list;
	}
}
