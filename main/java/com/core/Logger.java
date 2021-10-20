package com.core;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;

/**
 * 로거 
 *
 */
public class Logger {
	
	private static String status; // dev - 개발중(콘솔), service - 서비스 중(파일)
	private static Writer writer; 
	private static String logDir; // 로그 디렉토리
	private static String logPath;// 디렉토리포함 로그 파일명(날짜)
	
	/**
	 * 설정 초기화 
	 * 
	 */
	public static void init(String status, String logDir) {
		Logger.status = status;
		Logger.logDir = logDir;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String logFileName = sdf.format(new Date()) + ".log";
		
		Logger.logPath = logDir + File.separator + logFileName;
	}
	
	public static void init(FilterConfig config) {
		init(
			config.getInitParameter("status"),
			config.getInitParameter("logDir")
		);
	}
	
	/**
	 * Writer(출력 스트림) 설정 
	 * 
	 * @param writer
	 */
	public static void setWriter(Writer writer) {
		Logger.writer = writer;
	}
	
	/**
	 * 바이트 단위 스트림을 Writer(문자단위)으로 설정
	 * 
	 * @param stream
	 */
	public static void setStream(OutputStream stream) {
		Logger.writer = new OutputStreamWriter(stream);
	}
	
	/**
	 * 로그 기록 
	 * 
	 * @param message
	 */
	public static void log(String message) {
		
		BufferedWriter bw = null;
		PrintWriter out  = null;
		try {
			System.out.println("Writer : " + writer);
			// 별도 설정 Writer가 없는 경우 FileWriter 또는 System.out 설정 
			if (writer == null) {
				if (status.equals("dev")) { // 콘솔 출력 
					setStream(System.out);
				} else { // 파일 출력 
					setWriter(new FileWriter(logPath, true));
				}
			}
			
			bw = new BufferedWriter(writer);
			out = new PrintWriter(bw);
			out.println(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) out.close();
				if (bw != null) bw.close();
				if (writer != null && !status.equals("dev")) {
					writer.close();
					writer = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
 		}
	}
}





