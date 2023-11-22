package com.Task1.StudentDetails.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
import com.Task1.StudentDetails.Model.StudentDetails;
 
@Repository
public interface StudentRepo extends MongoRepository<StudentDetails, String> {
	}