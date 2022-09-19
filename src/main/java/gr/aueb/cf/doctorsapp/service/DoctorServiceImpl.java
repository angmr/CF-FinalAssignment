package gr.aueb.cf.doctorsapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.doctorsapp.dao.IDoctorDAO;
import gr.aueb.cf.doctorsapp.dto.DoctorDTO;
import gr.aueb.cf.doctorsapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService{
	
	private final IDoctorDAO doctorDAO;
	
	public DoctorServiceImpl(IDoctorDAO doctorDAO) {
		this.doctorDAO = doctorDAO;
	}

	@Override
	public void insertDoctor(DoctorDTO doctorDTO) throws SQLException {
		
		// Extract dto and create model instance
		Doctor doctor = new Doctor();
		doctor.setSname(doctorDTO.getSname());
		doctor.setFname(doctorDTO.getFname());
		
		// Forward to DAO
		try {
			doctorDAO.insert(doctor); 
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void deleteDoctor(DoctorDTO doctorDTO) throws SQLException {
		
		// Extract dto and create model instance
		Doctor doctorToDelete = new Doctor();
		doctorToDelete.setId(doctorDTO.getId());
		
		// Forward to DAO
		try {
			doctorDAO.delete(doctorToDelete);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void updateDoctor(DoctorDTO oldDoctorDTO, DoctorDTO newDoctorDTO) throws SQLException {
		
		// extract DTO and create instances
		Doctor doctorToUpdate = new Doctor();
		doctorToUpdate.setId(oldDoctorDTO.getId());
		
		Doctor newDoctor = new Doctor();
		newDoctor.setSname(newDoctorDTO.getSname());
		newDoctor.setFname(newDoctorDTO.getFname());
		
		// Forward to DAO
		try {	
			doctorDAO.update(doctorToUpdate, newDoctor);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Doctor> getDoctorByLastname(String lastname) throws SQLException {
		try {
			return doctorDAO.getDoctorsByLastname(lastname);
		} catch (SQLException e) {
			throw e;
		}
	}	
}
