	package yg;
	
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
	
	/**
	 * Servlet implementation class servlet1
	 */
	public class servlet1 extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public servlet1() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			 request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				String account=request.getParameter("account");
				String password=request.getParameter("password");
				if(account.equals("yangguang") && password.equals("1718064027")) {
					 Cookie ck = new Cookie("account", account);
					 Cookie ck1=new Cookie("password",password);
					 ck.setMaxAge(60*60*24);
					 ck1.setMaxAge(60*60*24);
					 response.addCookie(ck);
					 response.addCookie(ck1);
					 HttpSession session = request.getSession();
					 session.setAttribute("account", account);
					 response.sendRedirect("listEmp1.jsp");
				}else if(account.equals("liuna") && password.equals("1718064026")){
					 Cookie ck3 = new Cookie("account", account);
					 Cookie ck4=new Cookie("password",password);
					 ck3.setMaxAge(60*60*24);
					 ck4.setMaxAge(60*60*24);
					 response.addCookie(ck3);
					 response.addCookie(ck4);
					 HttpSession session = request.getSession();
					 session.setAttribute("account", account);
					 response.sendRedirect("listEmp2.jsp");
				}else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}