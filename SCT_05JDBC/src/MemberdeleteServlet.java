

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
 * Servlet implementation class MemberdeleteServlet
 */
@WebServlet("/MemberdeleteServlet")
public class MemberdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberdeleteServlet() {
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
		try {
		    //װ������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT","root","14789gly");
			String sql="delete from student where sid= ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, sid);
			int i=pst.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.write("ɾ���ɹ����������Ӳ鿴<a href='simpleQueryServlet'><b>������Ϣ</b></a>");
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
