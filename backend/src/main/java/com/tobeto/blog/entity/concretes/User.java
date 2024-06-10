package com.tobeto.blog.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.blog.entity.abstracts.BaseEntity;
import com.tobeto.blog.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity implements UserDetails {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> postList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> commentList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Admin> admins;

    @Column(name="roles")
    @Enumerated(EnumType.STRING)
    private List<UserRole> authorities;

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.getAuthorities();
    }*/

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
