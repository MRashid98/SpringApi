package com.qa.springapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springapi.dto.GuitaristDTO;
import com.qa.springapi.service.GuitaristService;

// localhost:9001/guitarist/<whatever path>

@RestController
@RequestMapping("/guitarist")
public class GuitaristController {

	private GuitaristService service;

	@Autowired
	public GuitaristController(GuitaristService service) {
		super();
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<GuitaristDTO> create(@RequestBody GuitaristDTO guitaristDto) {
		GuitaristDTO created = this.service.create(guitaristDto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	// read
	@GetMapping("/readall")
	public ResponseEntity<List<GuitaristDTO>> readAll() {
		return ResponseEntity.ok(this.service.read());
	}

	// read{id}
	@GetMapping("/read/{id}")
	public ResponseEntity<GuitaristDTO> readById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.read(id));
	}

	// update
	@PutMapping("/update/{id}")
	public ResponseEntity<GuitaristDTO> update(@PathVariable Long id, @RequestBody GuitaristDTO guitaristDto) {
		return new ResponseEntity<>(this.service.update(guitaristDto, id), HttpStatus.ACCEPTED);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GuitaristDTO> deleteById(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
