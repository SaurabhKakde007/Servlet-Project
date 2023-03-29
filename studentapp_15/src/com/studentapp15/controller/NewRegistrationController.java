package com.studentapp15.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp15.model.DAOserverImpl;


@WebServlet("/NewReg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewRegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NewReg.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			
		
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	
	DAOserverImpl server = new DAOserverImpl();
	server.connectionDB();
	
	server.NewReg(name,city,email,mobile);
	
	request.setAttribute("msg", "Data is saved!!");
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NewReg.jsp");
	rd.forward(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

}
