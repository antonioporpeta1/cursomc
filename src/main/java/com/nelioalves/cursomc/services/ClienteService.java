package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		if (!obj.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id + " Tipo: " + Cliente.class.getName());
		}
		
		return obj.orElse(null);
    }	
		
}
