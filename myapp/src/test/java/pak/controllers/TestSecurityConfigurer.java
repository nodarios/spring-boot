//package pak.controllers;
//
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///** import this test security config into tests to override main security config */
//@TestConfiguration
//@Order(-101)
//@EnableWebSecurity
///*@ComponentScan(
//        basePackages = {
//                "com.cmp.component"
//        },
//        basePackageClasses = {
//                JobController.class
//        },
//        excludeFilters = {
//                @ComponentScan.Filter(
//                        type = FilterType.ASSIGNABLE_TYPE,
//                        classes = {
//                                ContainerController.class
//                        }
//                )
//        }
//)*/
//public class TestSecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder)
//                .withUser("spring")
//                .password(encoder.encode("secret"))
//                .roles("USER");
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and().httpBasic()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        ;
//        /*http
//                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        ;*/
//        /*http
//                .httpBasic()
//                .and()
//                .formLogin()
//                .disable();*/
//    }
//
//}
