package com.studentapp15.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp15.model.DAOserverImpl;


@WebServlet("/GetAll")
public class GetAllRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetAllRegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		
	DAOserverImpl server = new DAOserverImpl();
	server.connectionDB();
	
	ResultSet result = server.Allregistration();
	
	request.setAttribute("result",result);
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Allreg.jsp");
	rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
