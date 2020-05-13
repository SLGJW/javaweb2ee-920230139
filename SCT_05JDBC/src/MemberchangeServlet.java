

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberchangeServlet
 */
@WebServlet("/MemberchangeServlet")
public class MemberchangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberchangeServlet() {
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
		String sid=request.getParameter("sid");
		String newsname=request.getParameter("sname");
		String newsbirthday=request.getParameter("sbirthday");
		String newssex=request.getParameter("ssex");
		try {
		    //װ������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT","root","14789gly");
			String sql="update student set sname= ?, sbirthday=?,ssex=? where sid= ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, newsname);
			pst.setString(2, newsbirthday);
			pst.setString(3, newssex);
			pst.setString(4, sid);
			int i=pst.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.write("�û����޸ĳɹ����������Ӳ鿴<a href='simpleQueryServlet'><b>������Ϣ</b></a>");
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
