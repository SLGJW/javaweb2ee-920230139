

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberQueryServlet
 */
@WebServlet("/MemberQueryServlet")
public class MemberQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String sid=request.getParameter("sid");
		try {
		    //װ������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT","root","14789gly");
			PreparedStatement pst=con.prepareStatement("SELECT * FROM student where sid=?");
			pst.setString(1, sid);
			
			ResultSet rs=pst.executeQuery();
			
			PrintWriter pw=response.getWriter();
			pw.write("<table>");
			pw.write("<tr>");
			pw.write("<th>sid</th>");
			pw.write("<th>sname</th>");
			pw.write("<th>sbirthday</th>");
			pw.write("<th>ssex</th>");
			pw.write("</tr>");
			while(rs.next()) {
				pw.write("<tr>");
				pw.write("<td>"+rs.getString("sid")+"</td>");
				pw.write("<td>"+rs.getString("sname")+"</td>");
				pw.write("<td>"+rs.getString("sbirthday")+"</td>");
				pw.write("<td>"+rs.getString("ssex")+"</td>");
				pw.write("</tr>");
			}
			pw.write("</table>");
			//�ر�����
			con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
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
