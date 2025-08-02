package com.myplacenow.MyPlaceNow.enums;

public enum UsuarioRoles {
	
	ADMIN("admin"),
	USER("usuario");
	
	private String role;
	
	UsuarioRoles(String role) {
		this.role=role;
	}

	public String getRole() {
		return role;
	}
}
