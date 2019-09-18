package com.s.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.s.sb.entity.Student;
import com.s.sb.service.SpringbootJPAService;
import com.s.sb.utility.Response;

@RestController
public class SpringbootJPAController {
	@Autowired
	SpringbootJPAService springbootJPAService;
	
	@GetMapping(value = "/")
	public String homePage() {
		return "Welocme to home..!";
	}

	@GetMapping(value = "/getStudentDetails")
	public Response getStudentDetails() {
		Response response = new Response();
		response = springbootJPAService.getStudentDetails();
		return response;
	}
	
	@PostMapping(value = "/createStudent")
	public Response createStudent(@RequestBody Student student) {
		Response response = new Response();
		response = springbootJPAService.createStudent(student);
		return response;
	}

	@GetMapping(value = "/editStudentDeailsById/{id}")
	public Response editStudentDeailsById(@PathVariable("id") int id) {
		Response response = new Response();
		response = springbootJPAService.editStudentDetailsById(id);
		return response;
	}

	@PostMapping(value = "/updateStudentDeailsById")
	public Response updateStudentDeailsById(@RequestBody Student student) {
		Response response = new Response();
		response = springbootJPAService.updateStudentDetailsById(student);
		return response;
	}

	@PostMapping(value = "/deleteStudentById/{id}")
	public Response deleteStudentById(@PathVariable("id") int id) {
		Response response = new Response();
		response = springbootJPAService.deleteStudentById(id);
		return response;
	}
}
