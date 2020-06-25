package com.ssafy.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.patient.dao.PatientRepo;
import com.ssafy.patient.dto.Patient;

@Service
public class PatientServiceImpl implements PatientService{
	
    @Autowired
	private PatientRepo patientRepo;
    
	@Override
	public List<Patient> findAllPatients() throws Exception {
		return patientRepo.findAllPatients();
	}

	@Override
	public Patient findPatientById(int id) throws Exception {
		return patientRepo.findPatientById(id);
	}

	@Override
	public int addPatient(Patient p) throws Exception {
		return patientRepo.addPatient(p);
	}

	@Override
	public boolean updatePatient(Patient p) throws Exception {
		return patientRepo.updatePatient(p);
	}

	@Override
	public boolean deletePatient(int id) throws Exception {
		return patientRepo.deletePatient(id);
	}

}
