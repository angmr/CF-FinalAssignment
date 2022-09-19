package gr.aueb.cf.doctorsapp.dao;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.cf.doctorsapp.model.Doctor;

/**
 * @author angmi
 */
public interface IDoctorDAO {
	void insert(Doctor doctor) throws SQLException;
	void delete(Doctor doctor) throws SQLException;
	void update(Doctor oldDoctor, Doctor newDoctor) throws SQLException;
	List<Doctor> getDoctorsByLastname(String lastname) throws SQLException;
	Doctor getDoctorById(int id) throws SQLException;
}