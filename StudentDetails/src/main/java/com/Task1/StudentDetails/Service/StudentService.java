package com.Task1.StudentDetails.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task1.StudentDetails.Model.StudentDetails;
import com.Task1.StudentDetails.Repo.StudentRepo;


@Service
public class StudentService {
	@Autowired
	private StudentRepo sr;
	public StudentDetails createStudentInfo(StudentDetails s) {

		 return	sr.save(s);
		}
	public List<StudentDetails> getAllStudent() {
		// TODO Auto-generated method stub
		List<StudentDetails> s=sr.findAll();
		if(s.size()>0) {
			return s;
		}
		else {
			return new ArrayList<StudentDetails>();
		}
	}
	public void updateStudent(String id, StudentDetails s) {
		Optional<StudentDetails> optionalStudent=sr.findById(id);
				if(optionalStudent.isPresent()) {

					StudentDetails StudentToUpdate=optionalStudent.get();
					StudentToUpdate.setName(s.getName());
					StudentToUpdate.setAge(s.getAge());
					StudentToUpdate.setSalary(s.getSalary());
					sr.save(StudentToUpdate);
				}
			}
	public StudentDetails getSingleStudentDetails(String id){
		Optional<StudentDetails> optionalStudent=sr.findById(id);
		return optionalStudent.get();
	}
	public void deleteStudentById(String id) {
		// TODO Auto-generated method stub
		Optional<StudentDetails> optionalStudent=sr.findById(id);
			sr.deleteById(id);

	}

}
	

	