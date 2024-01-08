package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmpEntity;
import com.example.demo.repositery.Emprepo;

@Service
public class EmpService 
{
	@Autowired
	private Emprepo repo;
	
	public void addEmp(EmpEntity e)
	{
		repo.save(e);
	}
	
	public List<EmpEntity>getallemp()
	{
		return repo.findAll();
	}
	
	public EmpEntity getempbyid(int id)
	{
		Optional<EmpEntity>e=repo.findById(id);
		return e.get();
    }
	
	public void deleteemp(int id)
	{
		repo.deleteById(id);
	}

}
