package com.example.springResource.configuration;

import com.example.springResource.model.AccessTokenMapper;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

    @Override
    public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {
        jwtAccessTokenConverter.setAccessTokenConverter(this);

    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication auth=super.extractAuthentication(map);
        AccessTokenMapper details=new AccessTokenMapper();
        if(map.get("id") != null){
            details.setUserId((Integer) map.get("id"));
        }
        if(map.get("mail") !=null){
            details.setUserEmail((String) map.get("mail"));
        }

        auth.setDetails(details);

        return auth;

    }
}
