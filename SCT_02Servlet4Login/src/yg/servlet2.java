package yg;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=utf-8");
	        response.setCharacterEncoding("utf-8");
	        PrintWriter out = response.getWriter();
	        Cookie ck[] = request.getCookies();
	        Cookie ck1[] = request.getCookies();
	        if ((ck != null)&&(ck1!=null)) {
	            String name = ck[0].getValue();
	            String password = ck1[0].getValue();
	            if (!name.equals("") || password.equals("")) {
	                out.println("<h1 align=\"center\">��¼����ҳ��</h1>");
	                out.println("<p align=\"center\">��ӭadmin���ʱ�ϵͳ</p>");
	                out.println("<div align=\"center\">");
	                out.println("<a href=\"servlet3\">ע��</a>");
	                out.println("</div>");
	            }
	        } else {
	    		out.println("<div align=\"center\">");
				out.println("<h1>��¼��ʧЧ,������<a href=\"index1.html\">��¼</a></h1>");
				out.println("</div>");
	        }
	        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
