package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.contact;
import model.contactModel;
import model.emailModel;
import model.phoneModel;
import entities.email;
import entities.phone;



/**
 * Servlet implementation class accountServlet
 */
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= request.getParameter("action");
		String message="";
		String page="";
		
		if(action.equalsIgnoreCase("upload"))
		{
			Part file=request.getPart("file");
			contactModel cm=new contactModel(file);
			String uploadRootPath= request.getServletContext().getRealPath("images");
			cm.uploadFile(uploadRootPath);
		}
		if(action.equalsIgnoreCase("insert"))
		{
			Part file=request.getPart("file");
			contactModel cm=new contactModel(file);
			String uploadRootPath= request.getServletContext().getRealPath("view/images");
			cm.uploadFile(uploadRootPath);
			
			int contactID=Integer.parseInt(request.getParameter("txtid"));
			String fullname=request.getParameter("txtname");
			String hinhmoi=cm.getFileName(file);
			String date=request.getParameter("txtdate");
			String sex=request.getParameter("txtsex");
			String address=request.getParameter("txtaddress");
			
			String phone=request.getParameter("txtphone");
			String email=request.getParameter("txtemail");
			
			contact cont=new contact(contactID, fullname, hinhmoi, date, sex, address);
			email em=new email(cont, email);
			phone ph=new  phone(cont, phone);
			
			contactModel contModel=new contactModel(cont);
			emailModel emModel=new emailModel(em);
			phoneModel phModel=new phoneModel(ph);
			
			int kq=contModel.insertContact();
			int kq1=emModel.insertEmail();
			int kq2=phModel.insertPhone();
			
			if(kq!=0)
			{
				if(kq1!=0)
				{
					if(kq2!=0)
					{
						System.out.println("Insert success");
						page="view/home.jsp";
					}
					else
					{
						message="Insert phone fail";
						page="view/Error.jsp";
					}
				}
				else
				{
					message="Insert Email fail";
					page="view/Error.jsp";
				}
			}
			else
			{
				message="Insert Contact fail";
				page="view/Error.jsp";
			}
			
			request.setAttribute("error", message);
			request.getRequestDispatcher(page).forward(request, response);
			
		}
	}

}
