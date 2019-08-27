package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.util.FileuploadUtil;

/*
 * maxRequestSize : 요청 최대 크기
 * maxFileSize : 파일당 최대 크기
 * 
 * 파일 최대 사이즈 5메가, 요청당 최대 5개 파일(25메가)
*/
@WebServlet("/fileupload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileuploadServlet.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileupload.jsp").forward(request, response);
	}

	// form submit 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String file = request.getParameter("file");
		
		Part part = request.getPart("file");
		part.getName();			// 업로드 파일명(input의 name 속성)
		part.getContentType();	// 
		part.getSize();			// 업로드 사이즈
		
		logger.debug("userId : {}", userId);
		logger.debug("file : {}", file);
		
		logger.debug("part.getName() : {}", part.getName());
		logger.debug("part.getContentType() : {}", part.getContentType());
		logger.debug("part.getHeader(\"Content-Disposition\") : {}", part.getHeader("Content-Disposition"));
		logger.debug("part.getSize() : {}", part.getSize());

		// 어떤 파일을 업로드해도 파일명이 brownupload.png으로 고정됨 --> 실제 업로드한 파일명으로 수정
//		part.write("e:\\upload\\" + FileuploadUtil.getFilename(part.getHeader("Content-Disposition")));
//		part.write("e:\\upload\\" + UUID.randomUUID().toString());
		
		String path = FileuploadUtil.getPath();
		
		// d:\\upload\\ 폴더 하나에 모든 파일을 저장하고 있던 것을
		// 파일 업로드 날짜의 년월 폴터를 체크하여 우러 단위로 파일을 관리
		// path ex : d:\\upload\\2019\\08\\
		String extension = FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition"));
		part.write(path + UUID.randomUUID().toString() + extension);
		
		// 최초 view로 이동
		doGet(request, response);
	}

}
