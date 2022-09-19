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
 * Servlet implementation class DeleteDoctorController
 */
@WebServlet("/delete")
public class DeleteDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IDoctorDAO doctorDAO = new DoctorDAOImpl();
	IDoctorService doctorServ = new DoctorServiceImpl(doctorDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		// Get data
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("sname");
		
		// Construct DTO
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(id);
		doctorDTO.setFname(firstname);
		doctorDTO.setSname(lastname);
		
		// Call the service
		try {
			doctorServ.deleteDoctor(doctorDTO);
			request.setAttribute("doctor", doctorDTO);
			request.getRequestDispatcher("/jsps/doctordeleted.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/doctors.jsp").forward(request, response);	
		}
	}
}
