package com.actividad6.backend.apirest.controllers;

import com.actividad6.backend.apirest.models.entity.Cliente;
import com.actividad6.backend.apirest.models.services.IClienteService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteRestControllerTest extends TestCase {

    @Autowired
    private IClienteService clienteService;

    Cliente clienteResponse = new Cliente();

    @Test
    public void testCreate() {
        Cliente cliente = new Cliente();
        cliente.setEmail("name test");
        cliente.setApellido("last name");
        cliente.setCreateAt(new Date());
        cliente.setEmail("test@gmail.com");

        clienteResponse = clienteService.save(cliente);

        Assert.assertEquals("test@gmail.com", clienteResponse.getEmail());
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testIndex() {
        List<Cliente> listClient = new ArrayList<>();

        listClient = clienteService.findAll();

        Assert.assertEquals("Andrés",listClient.get(0).getNombre());
    }

    public void testShow() {
        Cliente cliente = new Cliente();

        Long id = Long.valueOf(2);

        cliente = clienteService.findById(id);

        Assert.assertEquals("Mr. John", cliente.getNombre());
    }

    public void testUpdate() {
        Long id = Long.valueOf(2);
        Cliente clienteActual = clienteService.findById(id);
        Cliente clienteUpdated = new Cliente();
        clienteUpdated.setEmail("name test");
        clienteUpdated.setApellido("last name");
        clienteUpdated.setCreateAt(new Date());
        clienteUpdated.setEmail("test@gmail.com");

        clienteActual = clienteUpdated;

        Assert.assertEquals("name test", clienteActual.getNombre());
    }

    @After
    public void tearDown() throws Exception {
    }
}