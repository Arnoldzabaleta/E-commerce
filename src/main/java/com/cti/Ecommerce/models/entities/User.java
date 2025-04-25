package com.cti.Ecommerce.models.entities;

import com.cti.Ecommerce.models.enums.Gender;
import com.cti.Ecommerce.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 5)
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String country;

    @Column(unique = true)
    private String email;
    private String password;

    @Column(name = "isAccountLocked")
    private boolean isAccountLocked;
    @Column(name = "isEnabled")
    private boolean isEnabled;

    @Enumerated(EnumType.STRING)
    private Status accountStatus;

    @ManyToMany(fetch = FetchType.EAGER)// when I fetch the user, I want to eagerly fetch the list of roles
    private List<Role> roles ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public  String fullName(){
        return (firstname + " " + lastname);
    }

    public int getAge(){
        return Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Override
    public String getName() {
        return null;
    }
}
