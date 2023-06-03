package com.example.demo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UsersRoles {

	@EmbeddedId
	private UsersRolesPK pk;

	@ManyToOne
	@JoinColumn(name = "users", insertable = false, updatable = false)
	private Users users;

	@ManyToOne
	@JoinColumn(name = "roles", insertable = false, updatable = false)
	private Roles roles;

	public UsersRoles() {
		super();
	}

	public UsersRolesPK getPk() {
		return pk;
	}

	public void setPk(UsersRolesPK pk) {
		this.pk = pk;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}
