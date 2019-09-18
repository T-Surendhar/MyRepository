package com.s.sb.service;

import com.s.sb.entity.Student;
import com.s.sb.utility.Response;

public interface SpringbootJPAService {

	public Response getStudentDetails();

	public Response createStudent(Student student);

	public Response editStudentDetailsById(int id);

	public Response updateStudentDetailsById(Student student);

	public Response deleteStudentById(int id);

}
