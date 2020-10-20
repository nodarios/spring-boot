package pak.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // TODO substitute with db repo
        List<GrantedAuthority> authorities = Stream.of(new SimpleGrantedAuthority("PR_SUPER_ACCESS")).collect(Collectors.toList());
        return new User(
                "foo",
                new BCryptPasswordEncoder().encode("foo"),
                authorities
        );
    }

}
