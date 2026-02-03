package com.salesianostriana.prueba.model;

public enum Role {

    USER,ADMIN;

    public String getAuthority(){
        return "ROLE_" + this.name();
    }

    public String getRoleName(){
        return this.name();
    }
}
