package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/userModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserModifyController.class);
	
    private IUserService userService;
    
    @Override
    public void init() throws ServletException {
    	userService = new UserService();
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = userService.getUser(userId);
		logger.debug("user {}", user);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		
		String userId = request.getParameter("userId");
		User origin = userService.getUser(userId);
		
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String reg_dt = request.getParameter("reg_dt");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		Date reg_dt_date = null;
		
		Part picture = request.getPart("picture");
		
		String filename = "";
		String path = "";
		
		// 사용자가 파일을 업로드한 경우
		if (picture.getSize() > 0) {
			String contentDisposition = picture.getHeader("Content-Disposition");
			
			filename = FileuploadUtil.getFilename(contentDisposition); // 사용자가 업로드한 파일명
			String realFilename = UUID.randomUUID().toString();
			String extension = FileuploadUtil.getFileExtension(contentDisposition);
			
			path = FileuploadUtil.getPath() + realFilename + extension;
			
			picture.write(path);
			
			if (origin != null) {
				String originFile = origin.getRealfilename();
				new File(originFile).delete();
			}
		} else {
			filename = origin.getFilename();
			path = origin.getRealfilename();
		}
		
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		userService.updateUser(new User(userId, userNm, alias, reg_dt_date, addr1, addr2, zipcode, pass, filename, path));
		request.getRequestDispatcher("/user?userId=" + userId).forward(request, response);
	}

}
