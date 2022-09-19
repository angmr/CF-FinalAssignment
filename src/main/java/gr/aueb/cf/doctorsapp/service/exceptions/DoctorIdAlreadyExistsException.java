package gr.aueb.cf.doctorsapp.service.exceptions;

import gr.aueb.cf.doctorsapp.model.Doctor;

public class DoctorIdAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DoctorIdAlreadyExistsException(Doctor doctor) {
		super("Doctor with id = " + doctor.getId() + " already exists");
	}
}
