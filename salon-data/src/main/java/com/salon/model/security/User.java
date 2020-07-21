package com.salon.model.security;

import com.salon.model.IdEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User /*extends IdEntity*/ implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length = 50,unique = true)
    private String username;
    private String password;

    private String activateCode;
    private boolean active=false;

    private String userId;
    private Long personId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(nullable = false,unique = true)
    private String email;

    //@Builder.Default
    private Boolean accountNonExpired = true;

    //@Builder.Default
    private Boolean accountNonLocked = true;

    //@Builder.Default
    private Boolean credentialsNonExpired = true;

    //@Builder.Default
    private Boolean enabled = true;


    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Customer customer;

    @Transient
    public Set<GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(Role::getAuthorities)
                .flatMap(Set::stream)
                .map(authority -> {
                    return new SimpleGrantedAuthority(authority.getPermission());
                })
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }



//    @Override
//    public void eraseCredentials() {
//        this.password = null;
//    }


}
