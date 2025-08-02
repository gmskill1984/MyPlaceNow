package com.myplacenow.MyPlaceNow.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myplacenow.MyPlaceNow.enums.UsuarioRoles;

@Entity
@Table(name = "mp2_usuario")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mp2_id_usuario")
    private Long idUsuario;

    @Column(name = "mp2_nome_usuario")
    private String nomeUsuario;

    @Email
    @Column(name = "mp2_email_usuario")
    private String emailUsuario;

    @Column(name = "mp2_senha_usuario")
    private String senhaUsuario;

    @Column(name = "mp2_ativo_usuario")
    private String ativoUsuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "mp2_roles_usuario")
    private UsuarioRoles usuarioRoles;

    @OneToOne(mappedBy = "usuario")
    @JsonManagedReference
    private LatitudeLongitudeModel latitudeLongitude;

    // Getters e setters (pode usar Lombok para facilitar)

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getAtivoUsuario() {
        return ativoUsuario;
    }

    public void setAtivoUsuario(String ativoUsuario) {
        this.ativoUsuario = ativoUsuario;
    }

    public UsuarioRoles getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(UsuarioRoles usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public LatitudeLongitudeModel getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public void setLatitudeLongitude(LatitudeLongitudeModel latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
    }
}
