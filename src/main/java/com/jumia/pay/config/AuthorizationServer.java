package com.jumia.pay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	AuthenticationManager authenticationManager;
	
	//@Autowired
	//ConnectionConfig dataSource;
	
	@Autowired
	private TokenStore tokenStore;
	
	
	@Autowired 
	private ClientDetailsService oAuthClientDetails;
	 
	@Autowired
	private PasswordEncoder encoder;
	/*
	 * @Autowired private Mongo dataSource;
	 */
	
		@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//clients.jdbc(dataSource.getPrConn());
		 clients.withClientDetails(oAuthClientDetails);
		/*clients.inMemory().withClient("client").secret("secret")
		.authorizedGrantTypes("client_credentials","password")
		.authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
		.scopes("read","write","trust")
		.resourceIds("oauth2-resource")
		.accessTokenValiditySeconds(5000);*/
	}
	
	/*
	 * public ClientDetailsService getCustomClientDetailsService() { return new
	 * ClientDetailsService() {
	 * 
	 * @Override public ClientDetails loadClientByClientId(String clientId) throws
	 * ClientRegistrationException { ClientDetails c = null; try { c =
	 * oAuthClientDetails.queryByClientId(clientId); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return c; } }; }
	 */

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()").passwordEncoder(encoder);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
					.tokenStore(tokenStore)
					.reuseRefreshTokens(false);
	}
}
