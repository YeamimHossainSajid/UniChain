package com.agiles.UniChain.auth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
//@SuperBuilder
//@SQLRestriction( "is_active = TRUE" )
//@SQLDelete( sql = "UPDATE role SET is_active = FALSE WHERE id = ?" )
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private String roleType = "USER";

    @ManyToMany(
            mappedBy = "roles",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }
    )
    private Set<User> users = new LinkedHashSet<>();

    public Role(String roleType ) {
        this.roleType = roleType;
    }
    public Role( ) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
