package com.organization.applicationname.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.applicationname.entities.SampleEntity;
import com.organization.applicationname.repositories.SampleEntityRepository;
import com.organization.applicationname.services.SampleService;

@Service
public class SampleServiceImpl implements SampleService {
	@Autowired
	SampleEntityRepository sampleEntityRepository;

	@Override
	public void sampleSave() {
		SampleEntity sampleEntity = new SampleEntity();
		sampleEntity.setId((new Random()).nextInt(10000));
		sampleEntity.setName("" + (new Random()).nextInt(10000));
		sampleEntityRepository.save(sampleEntity);
	}

	@Override
	public List<SampleEntity> getAllSampleEntities() {
		return sampleEntityRepository.findAll();
	}
}
