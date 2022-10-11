package com.hotelapp.config;
import com.hotelapp.util.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //get the header with the name authorization from request
        String headerValue=request.getHeader("Authorization");
        String jwtToken=null;
        String username=null;

        //check if the header is not null and starts with bearer
        if(headerValue!=null && headerValue.startsWith("Bearer")){
//            Bearer ffga43t33456.dfgw43tareg.ertw34t3ata
            //get the jwttoken from the header
            jwtToken=headerValue.substring(7);
            //get the username from the token
            username= jwtTokenUtil.getUsernameFromToken(jwtToken);

        }else
            logger.warn("Invalid header");

        //ift he username is not null and the security context is not null
        //then specify the type of authentication
        if(username!=null && SecurityContextHolder.getContext()!=null){
            //check if the username is available in the database
            UserDetails details=userDetailsService.loadUserByUsername(username);
            List<GrantedAuthority> authorities= Arrays.asList(
                    new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER")
            );

            //configure the authentication type
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(details.getUsername(),null,authorities);
            //set the authentictaion type
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //set the authentication for the security context
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }



        //no header means move to the next filter and then to DS
        filterChain.doFilter(request,response);
    }
}
