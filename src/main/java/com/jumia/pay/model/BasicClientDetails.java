package com.jumia.pay.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

@Document(collection="client_details")
@SuppressWarnings("serial")
public class BasicClientDetails implements ClientDetails {
	
	@Id
	private String clientId;
	private String clientSecret;
	private String authorizedGrantTypes;
	private String authorities;
	private String scope;
	private String resourceIds;
	private int accessTokenValiditySeconds;
	private int refreshTokenValiditySeconds; 
	
	public BasicClientDetails() {
		
	}

	public BasicClientDetails(String clientId, String clientSecret, String authorizedGrantTypes, String authorities,
			String scope, String resourceIds, int accessTokenValiditySeconds, int refreshTokenValiditySeconds) {

		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.authorities = authorities;
		this.scope = scope;
		this.resourceIds = resourceIds;
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
		Set<String> resourceIds = new HashSet<>();	
		if(this.resourceIds!=null) {
			resourceIds = StringUtils.commaDelimitedListToSet(this.resourceIds);
		}
		return resourceIds;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return clientSecret;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<String> getScope() {
		Set<String> scopes = new HashSet<>();	
		if(scope!=null) {
			scopes = StringUtils.commaDelimitedListToSet(scope);
		}
		return scopes;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		Set<String> auths = new HashSet<>();	
		if(authorizedGrantTypes!=null) {
			auths = StringUtils.commaDelimitedListToSet(authorizedGrantTypes);
		}
		return auths;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		Set<String> resourceIds = new HashSet<>();	
		if(this.resourceIds!=null) {
			resourceIds = StringUtils.commaDelimitedListToSet(this.resourceIds);
		}
		return resourceIds;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		Set<String> grantedAuthorities = StringUtils.commaDelimitedListToSet(authorities);
		for(String auth:grantedAuthorities) {
			auths.add(new SimpleGrantedAuthority(auth.toUpperCase()));
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
	
	
	
}
