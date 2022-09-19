package gr.aueb.cf.doctorsapp.rest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gr.aueb.cf.doctorsapp.dao.DoctorDAOImpl;
import gr.aueb.cf.doctorsapp.dao.IDoctorDAO;
import gr.aueb.cf.doctorsapp.model.Doctor;
import gr.aueb.cf.doctorsapp.service.DoctorServiceImpl;
import gr.aueb.cf.doctorsapp.service.IDoctorService;

@WebServlet("/doctors")
public class DoctorRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IDoctorDAO doctorDAO = new DoctorDAOImpl();
	IDoctorService doctorServ = new DoctorServiceImpl(doctorDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		String lastname = request.getParameter("lastname").trim();
		
		List<Doctor> doctors = new ArrayList<>();
		String jsonString;
		Gson gson = new Gson();
		
		try {
			doctors = doctorServ.getDoctorByLastname(lastname);
			if (doctors != null) {
				jsonString = gson.toJson(doctors);
				
//				ObjectMapper mapper = new ObjectMapper();
//				jsonString = mapper.writeValueAsString(doctors);
				response.getWriter().write(jsonString);
				
			} else {
				response.getWriter().write("{}");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
