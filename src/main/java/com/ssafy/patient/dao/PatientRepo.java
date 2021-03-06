package com.ssafy.patient.dao;

import java.util.List;

import com.ssafy.patient.dto.Patient;

public interface PatientRepo {
	public List<Patient> findAllPatients() throws Exception;
	public Patient findPatientById(int id) throws Exception;
	public int addPatient(Patient p) throws Exception;
	public boolean updatePatient(Patient p) throws Exception;
	public boolean deletePatient(int id) throws Exception;
}
