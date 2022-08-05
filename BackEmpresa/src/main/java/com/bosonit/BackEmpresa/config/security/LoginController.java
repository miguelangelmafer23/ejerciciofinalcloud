package com.bosonit.BackEmpresa.config.security;

import com.bosonit.BackEmpresa.Client.application.port.GetClientPort;

import com.bosonit.BackEmpresa.Client.domain.Client;
import com.bosonit.BackEmpresa.Client.infraestructure.DTOs.OutputClientDTO;
import com.bosonit.BackEmpresa.exceptions.NotFoundException;
import com.bosonit.BackEmpresa.exceptions.UnprocesableException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    @Autowired
    GetClientPort getClientPort;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/login")
//comprobar nombre variable
    public ResponseEntity<String> login(@RequestParam("username") String username,@RequestParam("password") String pwd)
        throws NotFoundException, UnprocesableException
    {
        List<OutputClientDTO> outputClientDTOS = getClientPort.getClientsByName(username);
        if (outputClientDTOS.size() == 0) throw new NotFoundException("Usuario " + username + " no encontrado");
        if (outputClientDTOS.size() > 1) throw new NotFoundException("Existe más de un usuario con el mismo username");
        Client client = modelMapper.map(outputClientDTOS.get(0),Client.class);
        String password = client.getPassword();
        if(!pwd.equals(password)) throw new UnprocesableException("Password incorrecta");
        String rol =(client.getAdmin()) ? "ROLE_ADMIN": "ROLE_USER";
        return new ResponseEntity<>(getJWTToken(username,rol), HttpStatus.OK);
    }


    private String getJWTToken(String username,String rol) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
