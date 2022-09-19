package gr.aueb.cf.doctorsapp.service.exceptions;

import gr.aueb.cf.doctorsapp.model.Doctor;

public class DoctorNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DoctorNotFoundException(Doctor doctor) {
		super("Doctor with id = " + doctor.getId() + " was not found");
	}
}
