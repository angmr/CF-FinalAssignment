package gr.aueb.cf.doctorsapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.doctorsapp.dao.DoctorDAOImpl;
import gr.aueb.cf.doctorsapp.dao.IDoctorDAO;
import gr.aueb.cf.doctorsapp.dto.DoctorDTO;
import gr.aueb.cf.doctorsapp.model.Doctor;
import gr.aueb.cf.doctorsapp.service.DoctorServiceImpl;
import gr.aueb.cf.doctorsapp.service.IDoctorService;

/**
 * Servlet implementation class SearchDoctorController
 */
@WebServlet("/search")
public class SearchDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IDoctorDAO doctorDAO = new DoctorDAOImpl();
	IDoctorService doctorServ = new DoctorServiceImpl(doctorDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		// Get data
		String lastname = request.getParameter("lastname");
		
		// Construct DTO
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setSname(lastname);
		
		// Call service and return response
		try {
			List<Doctor> doctors = doctorServ.getDoctorByLastname(lastname);
			if (doctors != null) {
				request.setAttribute("doctors", doctors);
				request.getRequestDispatcher("/jsps/doctors.jsp").forward(request, response);
			} else {
				request.setAttribute("doctorsNotFound", true);
				request.getRequestDispatcher("/jsps/doctorsmenu.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
