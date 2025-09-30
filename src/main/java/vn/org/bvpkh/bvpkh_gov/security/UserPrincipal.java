package vn.org.bvpkh.bvpkh_gov.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {
        String roleName = user.getUsername();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (Optional.ofNullable(roleName).isPresent()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
            grantedAuthorities.add(grantedAuthority);
        }
        return new UserPrincipal(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
