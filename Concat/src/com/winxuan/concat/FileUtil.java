package com.winxuan.concat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
	public static String readFile(String path) throws IOException {
		InputStreamReader read = null;
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder();
		try {
			read = new InputStreamReader(new FileInputStream(new File(path)), "UTF-8");
			in = new BufferedReader(read);
			String line = "";
			while ((line = in.readLine()) != null)
				sb.append(line + "\n");
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (read != null)
				try {
					read.close();
				} catch (IOException localIOException1) {
				}
			if (in != null)
				try {
					in.close();
				} catch (IOException localIOException2) {
				}
		}
		return sb.toString();
	}
}