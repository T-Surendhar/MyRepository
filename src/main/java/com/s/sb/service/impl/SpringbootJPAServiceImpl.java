package com.s.sb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s.sb.dao.SpringbootJPADao;
import com.s.sb.entity.Student;
import com.s.sb.service.SpringbootJPAService;
import com.s.sb.utility.Response;

@Service
public class SpringbootJPAServiceImpl implements SpringbootJPAService {
	@Autowired
	SpringbootJPADao springbootJPADao;

	@Override
	public Response getStudentDetails() {
		Response response = new Response();
		List<Student> list = springbootJPADao.findAll();
		if (null != list) {
			try {
				response.setStatusCode(200);
				response.setMessage("Successfully fetched Student details");
				response.setData(list);
			} catch (Exception e) {
				response.setStatusCode(-1);
				response.setMessage(e.getMessage());
				response.setData("");
			}
		} else {
			response.setStatusCode(100);
			response.setMessage("No data");
			response.setData("");
		}
		return response;
	}

	@Override
	public Response createStudent(Student student) {
		Response response = new Response();
		Student studentResult = springbootJPADao.saveAndFlush(student);
		if (null != studentResult) {
			try {
				response.setStatusCode(200);
				response.setMessage("Successfully created new Student");
				response.setData(studentResult);
			} catch (Exception e) {
				response.setStatusCode(-1);
				response.setMessage(e.getMessage());
				response.setData("");
			}
		} else {
			response.setStatusCode(100);
			response.setMessage("Failed to create new Student");
			response.setData("");
		}
		return response;
	}

	@Override
	public Response editStudentDetailsById(int id) {
		Response response = new Response();
		boolean flag = springbootJPADao.existsById(id);
		if (flag) {
			Student student = springbootJPADao.getOne(id);
			if (null != student) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setData(student);
			}
		} else {
			response.setStatusCode(100);
			response.setMessage("Student does not exists");
			response.setData("");
		}
		return response;
	}

	@Override
	public Response updateStudentDetailsById(Student student) {
		Response response = new Response();
		boolean flag = springbootJPADao.existsById(student.getSid());
		if (flag) {
			Student studentResult = springbootJPADao.save(student);
			if (null != studentResult) {
				try {
					response.setStatusCode(200);
					response.setMessage("Success");
					response.setData(studentResult);
				} catch (Exception e) {
					response.setStatusCode(-1);
					response.setMessage(e.getMessage());
					response.setData("");
				}
			}
		} else {
			response.setStatusCode(100);
			response.setMessage("Student does not exists");
			response.setData("");
		}
		return response;
	}

	@Override
	public Response deleteStudentById(int id) {
		Response response = new Response();
		boolean flag = springbootJPADao.existsById(id);
		if (flag) {
			springbootJPADao.deleteById(id);
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setData("");
		} else {
			response.setStatusCode(100);
			response.setMessage("No Student exists");
			response.setData("");
		}
		return response;
	}

}
