package be.bstorm.tf_java_2026_rcd_bend.entities;

import be.bstorm.tf_java_2026_rcd_bend.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false) @ToString
public class User implements UserDetails {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Getter @Setter
    @Column(nullable = false)
    private String password;

    @Getter @Setter
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
