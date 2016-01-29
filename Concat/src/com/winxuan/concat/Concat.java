package com.winxuan.concat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/*" })
public class Concat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String cms_template;

	/**
	 * 初始化
	 */
	public void init(ServletConfig config) throws ServletException {
		String configPath = config.getServletContext().getRealPath("\\") + "WEB-INF/classes/config.properties";
		try {
			FileInputStream fis = new FileInputStream(new File(configPath));
			Properties prop = new Properties();
			prop.load(fis);
			cms_template = prop.getProperty("cms_template");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("init cms_template config error");
		}
		File file = new File(cms_template);
		if (!file.exists()) {
			throw new ServletException(cms_template + "not exists");
		}
		if (file.isFile()) {
			throw new ServletException(cms_template + "is a file");
		}

		System.out.println("init cms_template : " + cms_template);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (request.getQueryString() != null) {
			uri = uri + "?" + request.getQueryString();
		}
		uri = uri.replace("//", "/");
		String context = request.getContextPath();
		uri = uri.substring(context.length());

		if (uri.startsWith("/??")) {
			uri = uri.substring(3);
		}
		if (uri.startsWith("??")) {
			uri = uri.substring(2);
		}
		if (uri.startsWith("/")) {
			uri = uri.substring(1);
		}
		if (uri.startsWith("?")) {
			uri = uri.substring(1);
		}
		if (uri.contains("?")) {
			uri = uri.substring(0, uri.lastIndexOf("?"));
		}
		String[] fileArray = uri.split(",");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fileArray.length; i++) {
			sb.append(FileUtil.readFile(cms_template + fileArray[i]));
		}
		response.setContentType("application/x-javascript;charset=UTF-8");
		response.getWriter().append(sb);
	}
}