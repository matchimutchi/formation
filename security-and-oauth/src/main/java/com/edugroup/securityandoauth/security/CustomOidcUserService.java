package com.edugroup.securityandoauth.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.edugroup.securityandoauth.metier.GoogleOAuth2UserInfo;
import com.edugroup.securityandoauth.metier.User;
import com.edugroup.securityandoauth.repositories.UserRepository;


@Service
public class CustomOidcUserService extends OidcUserService {
	
	@Autowired
	private UserRepository userRepository;

	
	
	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		OidcUser oidcUser =super.loadUser(userRequest);
		//je récupére les infos supplémentaires ( nom, email etc...)
		Map<String, Object> attributes = oidcUser.getAttributes();
		GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo();
		//recuperation de l'email
		userInfo.setEmail((String)attributes.get("email"));
		//récupération identifiant
		userInfo.setId((String)attributes.get("sub"));
		//récupération nom
		userInfo.setName((String)attributes.get("name"));
		//récupération adresse image
		userInfo.setImageUrl((String)attributes.get("picture"));
		//sauvegarde user
		updateUser(userInfo);
		return oidcUser;
	}
	
	
	private void updateUser(GoogleOAuth2UserInfo userInfo) {
		User u = userRepository.findByEmail(userInfo.getEmail());
		//si on ne connait pas déjà cet utilisateur ( via son email), en creer un nouveau
		if( u == null) {
			u = new User();
		}
		
		u.setEmail(userInfo.getEmail());
		u.setImageUrl(userInfo.getImageUrl());
		u.setName(userInfo.getName());
		u.setUserType("google");
		
		userRepository.save(u);
	}
	
	
}
