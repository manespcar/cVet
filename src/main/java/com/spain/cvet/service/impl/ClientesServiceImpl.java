package com.spain.cvet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spain.cvet.model.Clientes;
import com.spain.cvet.repositories.ClientesRepository;
import com.spain.cvet.service.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {
	
	@Autowired
	private ClientesRepository clientesRepository;

	@Override
	public Clientes getClienteById(Integer clienteId) {
		return clientesRepository.getById(clienteId);
	}

	@Override
	public Clientes saveCliente(Clientes cliente) {
		return clientesRepository.save(cliente);
	}
	
	

}
