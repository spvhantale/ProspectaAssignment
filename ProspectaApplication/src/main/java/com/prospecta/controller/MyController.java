package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.exception.CategoryException;
import com.prospecta.model.Entry;
import com.prospecta.model.ResultDTO;
import com.prospecta.service.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService mService;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<ResultDTO>> getTitle(@PathVariable String category) throws CategoryException{
		
		List<ResultDTO> rlist=mService.getTitle(category);
		
		return new ResponseEntity<List<ResultDTO>>(rlist, HttpStatus.OK);
	}
	@PostMapping("/entries")
	public ResponseEntity<List<Entry>> saveEntry(@RequestBody Entry entry){
		
		List<Entry> elist=mService.saveEntry(entry);
		
		return new ResponseEntity<List<Entry>>(elist, HttpStatus.OK);
	}
	
}
