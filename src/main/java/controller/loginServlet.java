package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection cn;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("txtusername");
		String password=request.getParameter("txtpassword");
		
		String message="";
		String page="";
		cn=new myConnect().getcn();
		if(cn==null)
		{
			System.out.println("mySQL connection is fail");
			message="Connection is fail";
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		try
		{
			String sql="select * from login where username like ?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(2).equals(password))
				{
					page="view/home.jsp";
				}
				else
				{
					page="view/login.jsp";
					message="Password is incorrect";
				}
			}
			else
			{
				message="Username is not correct";
				page="view/login.jsp";
			}
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
