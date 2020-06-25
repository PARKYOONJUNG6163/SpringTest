package com.ssafy.patient.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.patient.dto.Patient;
import com.ssafy.patient.service.PatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController // 데이터 전용
@RequestMapping("/api")
@Api(value="SSAFY")
public class PatientRestController {
public static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService; 

    @ApiOperation(value = "모든 사원의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/patient/all", method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> findAllPatients() throws Exception {
		logger.info("1-------------findAllPatients-----------------------------"+new Date());
		List<Patient> emps = patientService.findAllPatients();
		if (emps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Patient>>(emps, HttpStatus.OK);
	}
    
    @ApiOperation(value = " 새로운 사원을 정보를 입력한다. 그리고 그 사원의 사원번호를 반환한다.", response = String.class)
   	@RequestMapping(value = "/patient", method = RequestMethod.POST)
   	public ResponseEntity<String> addPatient(@RequestBody Patient dto) throws Exception {
   		logger.info("5-------------addPatient-----------------------------"+new Date());
   		logger.info("5-------------addPatient-----------------------------"+dto);
   		int t = patientService.addPatient(dto);
   		if(t==1) return new ResponseEntity<String>("success", HttpStatus.OK);
   		else return new ResponseEntity<String>("fail", HttpStatus.OK); 
   	}
    
    @ApiOperation(value = " 사원의 정보를 수정한다 만약 사원의 부서와 업무가 변경되면 잡히스토리에  자동(trigger)으로 추가된다. 원래 put이다.", response = String.class)
   	@RequestMapping(value = "/patient", method = RequestMethod.PUT)
   	public ResponseEntity<String> updatePatient(@RequestBody Patient dto) throws Exception {
   		logger.info("1-------------updatePatient-----------------------------"+new Date());
   		logger.info("1-------------updatePatient-----------------------------"+dto);
   		boolean total = patientService.updatePatient(dto);

   		if (!total) {
   			return new ResponseEntity<String>("fail",HttpStatus.NO_CONTENT);
   		}
   		return new ResponseEntity<String>("success", HttpStatus.OK);
   	}
    
    @ApiOperation(value = "조회", response = String.class)
 	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
 	public ResponseEntity<String> getPatient(@PathVariable int patientId) throws Exception {
 		logger.info("1-------------getPatient-----------------------------"+new Date());
 		logger.info("1-------------getPatient-----------------------------"+patientId);
 		
 		Patient total = patientService.findPatientById(patientId);
 		
 		if (total == null) {
 			return new ResponseEntity<String>("fail",HttpStatus.NO_CONTENT);
 		}
 		return new ResponseEntity<String>("success", HttpStatus.OK);
 	}
    
    
    @ApiOperation(value = " 해당사원의 정보를 삭제한다. 사원의 정보를 삭제하기전, 정산하고 , 잡히스토리 수정등 여러 작업을 해야한다. 여기서는 히스토리를 모두 지우고(수정한 적이 없다면 바로 삭제가능) 삭제할 수 있다 . 원래 delete다", response = String.class)
	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePatient(@PathVariable int patientId) throws Exception {
		logger.info("1-------------deletePatient-----------------------------"+new Date());
		logger.info("1-------------deletePatient-----------------------------"+patientId);
		
		boolean total = patientService.deletePatient(patientId);
		
		if (!total) {
			return new ResponseEntity<String>("fail",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
