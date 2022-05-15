/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DTO.UserDTO;
import Entity.Users;
import Facades.UsersFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author mjura
 */
@Stateless
public class UserService {
    
    public List<UserDTO> listaEntityADTO (List<Users> lista){
        return lista.stream().map(u -> u.toDTO()).collect(Collectors.toList());
    }
    
    @EJB UsersFacade uf;
    public UserDTO comprobarCredenciales (String email, String pass){
        Users usuario = this.uf.comprobarUsuario(email, pass);
        return usuario.toDTO();
    }
    
    public void crearVendedor(String username, String email, String password, 
            String nombre, String apellidos, String genero, String calle, 
            Integer numero, String ciudad, Integer cpostal, String region){
        Users vendedor = new Users();
        // Relleno los datos
        vendedor.setRol("Vendedor");
        vendedor.setUsername(username);
        vendedor.setEmail(email);
        vendedor.setPassword(password);
        vendedor.setName(nombre);
        vendedor.setSurname(apellidos);
        vendedor.setGender(genero);
        vendedor.setStreet(calle);
        vendedor.setNumber(numero);
        vendedor.setCity(ciudad);
        vendedor.setRegion(region);
        vendedor.setPostalCode(cpostal);
        this.uf.create(vendedor);
    }
    
    public void crearComprador(String nombreUsuario, String correo, String contrasena, 
            String nombre, String apellidos, String sexo, String calle, 
            Integer numero, String ciudad, Integer codigoPostal, String region){
        Users comprador = new Users();
        // Relleno los datos
        comprador.setRol("Comprador");
        comprador.setUsername(nombreUsuario);
        comprador.setPassword(contrasena);
        comprador.setEmail(correo);
        comprador.setName(nombre);
        comprador.setSurname(apellidos);
        comprador.setGender(sexo);
        comprador.setStreet(calle);
        comprador.setNumber(numero);
        comprador.setCity(ciudad);
        comprador.setRegion(region);
        comprador.setPostalCode(codigoPostal);
        this.uf.create(comprador);
    }
    
    public List<UserDTO> listarUsuarios(){
        List<Users> users = null;

        users = this.uf.findAll();
    
        return this.listaEntityADTO(users);
    }
    
    public UserDTO buscarUsuario(Integer usuarioId) {
        return this.uf.find(usuarioId).toDTO();
    }
    
    public Users findUser(Integer usuarioId) {
        return this.uf.find(usuarioId);
    }
}
