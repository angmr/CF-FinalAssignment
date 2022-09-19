package gr.aueb.cf.doctorsapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.doctorsapp.dao.DoctorDAOImpl;
import gr.aueb.cf.doctorsapp.dao.IDoctorDAO;
import gr.aueb.cf.doctorsapp.dto.DoctorDTO;
import gr.aueb.cf.doctorsapp.service.DoctorServiceImpl;
import gr.aueb.cf.doctorsapp.service.IDoctorService;

/**
 * Servlet implementation class InsertDoctorController
 */
@WebServlet("/insert")
public class InsertDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IDoctorDAO doctorDAO = new DoctorDAOImpl();
	IDoctorService doctorServ = new DoctorServiceImpl(doctorDAO);
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		// Get data
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		// Construct DTO
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setFname(firstname);
		doctorDTO.setSname(lastname);
		
		// call the service and return feedback/view/data
		try {
			doctorServ.insertDoctor(doctorDTO);
			request.setAttribute("inserteddoctor", doctorDTO);
			request.getRequestDispatcher("/jsps/doctorinserted.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/doctorsmenu.jsp").forward(request, response);
		}
	}
}
