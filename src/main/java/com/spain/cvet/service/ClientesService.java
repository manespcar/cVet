package com.spain.cvet.service;

import com.spain.cvet.model.Clientes;

public interface ClientesService {
	
	public Clientes getClienteById(Integer clienteId);
	
	public Clientes saveCliente(Clientes cliente);

}
