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
	
	/** 로그 레벨 상수 */
	private static final int DEBUG = 0;
	private static final int INFO = 1;
	private static final int NOTICE = 2;
	private static final int WARNING = 3;
	private static final int ERROR = 4;
	private static final int CRITICAL = 5;
	private static final int ALERT = 6;
	private static final int EMERGENCY = 7;
	private static final String[] errorLevels = {"debug", "info", "notice", "warning", "error", "critical", "alert", "emergency" };

	
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
	 * @param level 로그 레벨(0~7) - 1 - info
	 */
	public static void log(String message, int level) {
		
		if (level < 0 || level > 7) level = 1; // info가 기본값
		
		BufferedWriter bw = null;
		PrintWriter out  = null;
		try {
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
			
			StringBuilder sb = new StringBuilder();
			// 로그 레벨 표기 
			sb.append("[%s]");
			
			// 로그 작성 시간 표기 
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String time = sdf.format(new Date());
			sb.append("[%s]");
			
			// 메세지 표기 
			sb.append("%s%n");
			
			out.printf(sb.toString(), errorLevels[level], time, message);
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!status.equals("dev")) {
				try {
					if (out != null) out.close();
					if (bw != null) bw.close();
					if (writer != null) {
						writer.close();
						writer = null;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
 		}
	}
	
	/**
	 * 로그 기록, level - INFO로 고정 
	 * 
	 * @param message
	 */
	public static void log(String message) {
		log(message, Logger.INFO);
	}
	
}





