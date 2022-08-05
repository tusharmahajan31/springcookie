package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getdata")
public class CookieSave extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String uname = request.getParameter("txtName");
		String choice = request.getParameter("radBike");
		String bike ="";
		System.out.println(uname +"  "+choice);
		switch(choice) {
		case "b":
			bike = "BMW";
			break;
		case "n":
			bike = "NINJA";
			break;
		case "h":
			bike = "HYABUSHA";
			break;
		}
		System.out.println(bike);
		Cookie cn = new Cookie("namecooky",uname);
		
		Cookie cs = new Cookie("bikecooky",bike);
		
		response.addCookie(cn);
		response.addCookie(cs);
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Cookie Demo</title>");
		pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div class=\"container\">");
		
		pw.println("<h1 style=color:blue> Cookies are save" +"Successfully</h1>");
		pw.println("<p>Click <a href=\"getcookie\"> here </a>"+" to see set cookie</p>");
		pw.println("</body>");
		pw.println("</html>");
	}


}
