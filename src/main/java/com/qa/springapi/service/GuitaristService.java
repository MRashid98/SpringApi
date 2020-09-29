package com.qa.springapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springapi.dto.GuitaristDTO;
import com.qa.springapi.exception.GuitaristNotFoundException;
import com.qa.springapi.persistance.domain.Guitarist;
import com.qa.springapi.persistance.repo.GuitaristRepo;
import com.qa.springapi.utils.SpringBeanUtils;

@Service
public class GuitaristService {

	private GuitaristRepo repo;
	private ModelMapper mapper;

	@Autowired
	public GuitaristService(GuitaristRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private GuitaristDTO mapToDTO(Guitarist guitarist) {
		return this.mapper.map(guitarist, GuitaristDTO.class);
	}

	private Guitarist mapFromDTO(GuitaristDTO guitaristDto) {
		return this.mapper.map(guitaristDto, Guitarist.class);
	}

	// create
	public GuitaristDTO create(GuitaristDTO guitaristDto) {
		Guitarist toSave = this.mapFromDTO(guitaristDto);
		Guitarist saved = this.repo.save(toSave);
		return this.mapToDTO(saved);
	}

	// read
	public List<GuitaristDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// read {id}
	public GuitaristDTO read(Long id) {
		Guitarist found = this.repo.findById(id).orElseThrow(GuitaristNotFoundException::new);
		return this.mapToDTO(found);
	}

	// update {id}
	public GuitaristDTO update(GuitaristDTO guitaristDto, Long id) {
		Guitarist toUpdate = this.repo.findById(id).orElseThrow(GuitaristNotFoundException::new);
		SpringBeanUtils.mergerObjects(guitaristDto, toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}

	// delete {id}
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
