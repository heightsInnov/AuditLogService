package com.babatunde.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

@Document
public class CustomClient implements ClientDetails {

	private static final long serialVersionUID = 1L;

	@Id
	private String clientId = UUID.randomUUID().toString();
	private String secret;
	private String scope;
	private String grantTypes;
	private String authorities;
	private int accessTokenValiditySeconds;
	private int refreshTokenValiditySeconds;
	private String authorizedGrants;
	
	
	
	
	public CustomClient(String secret, String scope, String grantTypes, String authorities, int accessTokenValiditySeconds,
			int refreshTokenValiditySeconds) {
		this.secret = secret;
		this.scope = scope;
		this.grantTypes = grantTypes;
		this.authorities = authorities;
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		return new HashSet<>();
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return secret;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<String> getScope() {
		Set<String> scopes = new HashSet<>();
		if(scope!=null && !scope.equals("")) {
			scopes = StringUtils.commaDelimitedListToSet(scope);
		}
		return scopes;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		Set<String> authGrants = new HashSet<>();
		if(authorizedGrants!=null && !authorizedGrants.equals("")) {
			authGrants = StringUtils.commaDelimitedListToSet(authorizedGrants);
		}
		return authGrants;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return new HashSet<>();
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		if(authorities!=null && !authorities.equals("")) {
		 Set<String> gAuths = StringUtils.commaDelimitedListToSet(authorities);
		 for(String gAuth:gAuths)
			 auths.add(new SimpleGrantedAuthority(gAuth.toUpperCase()));
		}
		return auths;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return accessTokenValiditySeconds;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return refreshTokenValiditySeconds;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return new HashMap<>();
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getGrantTypes() {
		return grantTypes;
	}

	public void setGrantTypes(String grantTypes) {
		this.grantTypes = grantTypes;
	}

	public String getAuthorizedGrants() {
		return authorizedGrants;
	}

	public void setAuthorizedGrants(String authorizedGrants) {
		this.authorizedGrants = authorizedGrants;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}
	
	

}
