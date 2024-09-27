package kr.ac.kku.cs.wp.ju;

import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.Map;
import User.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kku.cs.wp.ju.data.UserData;

@WebServlet(
		urlPatterns = {"/login","/logout"}
		)

public class LoginControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String context =req.getServletContext().getContextPath();
		String uriStr =req.getRequestURI().replaceAll(context, "");
		
		log("in service:"+uriStr);
		
		if(uriStr.equals("/login")) {
			req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String context =req.getServletContext().getContextPath();
		String uriStr =req.getRequestURI().replaceAll(context, "");
		
		log("in post"+uriStr);
		
		if(uriStr.equals("/login")) {
			Map<String, User> users=UserData.getInstance().getData();
			String id = req.getParameter("username");
			String password = req.getParameter("password");
			User user =users.get(id);
			
			if(user==null) {
				req.setAttribute("error", "login_fail");
				req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req,resp);
			}else {
				log(password);
				log(user.getPassword());
				if(!password.equals(user.getPassword())) {
					req.setAttribute("error", "login_fail");
					req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
					
					
				}else {
					HttpSession session = req.getSession();
					Account ac=new Account();
					ac.setId(id);
					ac.setUsername(password)
				}
			}
			
			
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

}
