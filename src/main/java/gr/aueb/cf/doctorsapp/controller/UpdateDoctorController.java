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
 * Servlet implementation class UpdateDoctorController
 */
@WebServlet("/update")
public class UpdateDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IDoctorDAO doctorDAO = new DoctorDAOImpl();
	IDoctorService doctorServ = new DoctorServiceImpl(doctorDAO);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get data
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("sname");
		
		// Construct DTOs
		DoctorDTO oldDoctorDTO = new DoctorDTO();
		oldDoctorDTO.setId(id);
		
		DoctorDTO newDoctorDTO = new DoctorDTO();
		newDoctorDTO.setFname(firstname);
		newDoctorDTO.setSname(lastname);
		
		// Call service
		try {
			doctorServ.updateDoctor(oldDoctorDTO, newDoctorDTO);
			request.setAttribute("doctor", newDoctorDTO);
			request.getRequestDispatcher("/jsps/doctorupdated.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
