package pak.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pak.helper.JwtTokenHelper;
import pak.model.AuthenticationRequest;
import pak.model.AuthenticationResponse;
import pak.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {

    private final UserService userService;
    private final JwtTokenHelper jwtTokenHelper;
    private final AuthenticationManager authenticationManager;

    @GetMapping(path = {"/welcome"})
    public String welcome() {
        return "welcome";
    }

    @GetMapping(path = {"/guarded"})
    public String guarded(@AuthenticationPrincipal String username) {
        log.info("username {}", username);
        return "guarded";
    }

    @GetMapping(path = {"/superGuarded"})
    public String superGuarded(@AuthenticationPrincipal String username) {
        log.info("username {}", username);
        return "superGuarded";
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage(), e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenHelper.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
