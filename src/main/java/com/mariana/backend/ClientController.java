package com.mariana.backend;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientMapper clientMapper){
        this.clientMapper = clientMapper;
    }

    // Crear cliente
    @RequestMapping(method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity createClient(@RequestBody ClientDto clientDto){
        // Verificamos que el nombre no sea nulo o no este vacio
        if(clientDto.getFirstName() == null || "".equals(clientDto.getLastName().trim())){
            Map response = new HashMap();
            response.put("code", 10000);
            response.put("message", "El clinete no tiene nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        // Verificamos que el apellido no sea nulo o no este vacio
        if(clientDto.getLastName() == null || "".equals(clientDto.getLastName().trim())) {
            Map response = new HashMap();
            response.put("code", 10000);
            response.put("message", "El clinete no tiene nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        clientMapper.create(clientDto);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    // Listar clientes
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity createClient(){
        return new ResponseEntity<>(clientMapper.listAll(), HttpStatus.OK);
    }

    // Eliminar clientes
    /**
     * La ruta deberia ser /api/v1/clients/123
     * @return
     */
    @RequestMapping(
            path = "/{clientId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity removeClient(@PathVariable("clientId") Integer clientId){
        clientMapper.deleteClient(clientId);
        Map response = new HashMap();
        response.put("code", 0);
        response.put("message", "Eliminacion correcta");
        return new ResponseEntity<>("Eliminacion correcta", HttpStatus.OK);
    }

    // Actualizar clientes
    @RequestMapping(
            path = "/{clientId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity updateClient(@PathVariable("clientId") Integer clientId,
                                       @RequestBody ClientDto clientDto){
        // Verificamos que el nombre no sea nulo o no este vacio
        if(clientDto.getFirstName() == null || "".equals(clientDto.getLastName().trim())){
            Map response = new HashMap();
            response.put("code", 10000);
            response.put("message", "El clinete no tiene nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        // Verificamos que el apellido no sea nulo o no este vacio
        if(clientDto.getLastName() == null || "".equals(clientDto.getLastName().trim())) {
            Map response = new HashMap();
            response.put("code", 10000);
            response.put("message", "El clinete no tiene nombre");
            return new ResponseEntity<Map>(response, HttpStatus.BAD_REQUEST);
        }
        // Colocamos ID en el DTO (por que lo usa el Mapper) a partir del Path Variable
        clientDto.setClientId(clientId);
        // Invocamos a la base de datos para actualizar al cliente
        clientMapper.updateClient(clientDto);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

}
