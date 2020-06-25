package com.ssafy.patient.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.patient.dto.Patient;

@Repository
public class PatientRepoImpl implements PatientRepo{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Patient> findAllPatients() throws Exception {
		return sqlSession.selectList("p_hrm.findAllPatients");
	}

	@Override
	public Patient findPatientById(int id) throws Exception {
		return sqlSession.selectOne("p_hrm.findPatientById",id);
	}

	@Override
	public int addPatient(Patient p) throws Exception {
		return sqlSession.insert("p_hrm.addPatient",p);
	}

	@Override
	public boolean updatePatient(Patient p) throws Exception {
		sqlSession.update("p_hrm.updatePatient",p);
		 return true;
	}

	@Override
	public boolean deletePatient(int id) throws Exception {
		sqlSession.delete("p_hrm.deletePatient",id);
		return true;
	}

}
