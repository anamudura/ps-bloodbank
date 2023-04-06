package com.example.bloodbank.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Collection;
//
//@Component
public class CustomAuthenticationSuccessHandler  {
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//        SimpleUrlAuthenticationSuccessHandler donatorSuccessHandler =
//            new SimpleUrlAuthenticationSuccessHandler("/donator");
//    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
//            new SimpleUrlAuthenticationSuccessHandler("/admin");
//    SimpleUrlAuthenticationSuccessHandler doctorSuccessHandler =
//            new SimpleUrlAuthenticationSuccessHandler("/doctor");
//
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//
//        for (final GrantedAuthority grantedAuthority : authorities) {
//            String authorityName = grantedAuthority.getAuthority();
//            if (authorityName.equals("ROLE_ADMIN")) {
//                // if the user is an ADMIN delegate to the adminSuccessHandler
//                this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
//                return;
//            }else
//            if (authorityName.equals("ROLE_DOCTOR")) {
//                // if the user is an DOCTOR delegate to the adminSuccessHandler
//                this.doctorSuccessHandler.onAuthenticationSuccess(request, response, authentication);
//                return;
//            }
//            if (authorityName.equals("ROLE_DONATOR")) {
//                // if the user is an DOCTOR delegate to the adminSuccessHandler
//                this.donatorSuccessHandler.onAuthenticationSuccess(request, response, authentication);
//                return;
//            }
//        }
//    }
//
//
//
}