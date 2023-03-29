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


@WebServlet("/login15")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	DAOserverImpl server = new DAOserverImpl();
	server.connectionDB();
	
	boolean status = server.verifycreditals(email, password);
	if(status==true) {
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NewReg.jsp");
		rd.forward(request, response);
	}else {
		request.setAttribute("error", "Invalid username/password");
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
	}
	}

}
