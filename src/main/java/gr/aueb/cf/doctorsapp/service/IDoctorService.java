package gr.aueb.cf.doctorsapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.doctorsapp.dto.DoctorDTO;
import gr.aueb.cf.doctorsapp.model.Doctor;

public interface IDoctorService {
	/**
	 * Inserts a {@link Doctor} based on the data carried by the {@link DoctorDTO}.
	 * 
	 * @param doctorDTO
	 * 			DTO object that contains the data
	 *
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertDoctor(DoctorDTO doctorDTO) throws SQLException;
	
	/**
	 * Removes a {@link Doctor} based on the data carried by the {@link DoctorDTO}.
	 *  
	 * @param doctorDTO
	 * 			DTO object that contains the data (mainly the id)
	 * 
	 * @throws SQLException
	 * 			if any error happens during SQL delete 
	 */
	void deleteDoctor(DoctorDTO doctorDTO) 
			throws SQLException;
	
	/**
	 * Updates a {@link Doctor} based on the data carried by the {@link DoctorDTO}.
	 * 
	 * @param oldDoctorDTO
	 * 			DTO object hat contains the data -mainly the id- of the doctor
	 * 			that will be updated.
	 * @param newDoctorDTO
	 * 			DTO object that contains the data of the new doctor.
	 * @throws SQLException
	 * 			if any error happens during SQL update 
	 */			
	void updateDoctor(DoctorDTO oldDoctorDTO, DoctorDTO newDoctorDTO) 
			throws SQLException;
	
	
	/**
	 * Gets back to the caller a list of the {@link Doctor} objects identified
	 * by their last name or last name's initial characters
	 * 
	 * @param lastname
	 * 			a string object that contains the last name or the initial letters
	 * 			that last name starts with. 
	 * @return
	 * 			a list that contains the results of the search, or null if no
	 * 			results are found
	 * @throws SQLException
	 * 			if any error happens during SQL search 
	 */
	List<Doctor> getDoctorByLastname(String lastname) throws SQLException;
}
