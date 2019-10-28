package com.jumia.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.jumia.pay.model.BasicClientDetails;
import com.jumia.pay.repository.ClientDetailsRepository;

@Primary
@Service
public class BasicClientDetailsService implements ClientDetailsService{
	
	@Autowired
	private ClientDetailsRepository clientRepo;

	/*
	 * public ClientDetails queryByClientId(String clientId) throws SQLException{ //
	 * TODO Auto-generated method stub Connection conn = null; CallableStatement pst
	 * = null; BasicClientDetails user = null; ResultSet userdetails = null; try {
	 * conn = Utility.getConn(); pst = conn.
	 * prepareCall("{? = call mgmportal.MEMBERGETMEMBERSERVICE_PKG.FINDBYCLIENTID(?)}"
	 * ); pst.registerOutParameter(1, OracleTypes.CURSOR); pst.setString(2,
	 * clientId);
	 * 
	 * if (pst.executeUpdate() != Statement.EXECUTE_FAILED) { userdetails =
	 * (ResultSet) pst.getObject(1); while (userdetails.next()) { user = new
	 * BasicClientDetails(); user.setClientId(userdetails.getString("CLIENT_ID"));
	 * user.setClientSecret(userdetails.getString("CLIENT_SECRET"));
	 * user.setAccessTokenValiditySeconds(Integer.valueOf(userdetails.getString(
	 * "ACCESS_TOKEN_VALIDITY")));
	 * user.setAuthorizedGrantTypes(convertRecordToSet(userdetails.getString(
	 * "AUTHORIZED_GRANT_TYPES")));
	 * user.setResourceIds(convertRecordToSet(userdetails.getString("RESOURCE_IDS"))
	 * ); user.setScopes(convertRecordToSet(userdetails.getString("SCOPE")));
	 * user.setAuthorities(converToCollection(userdetails.getString("AUTHORITIES")))
	 * ; } } } catch (Exception e) { // TODO: handle exception e.printStackTrace();
	 * }finally { if (userdetails != null) { userdetails.close(); } if (pst != null)
	 * { pst.close(); } if (conn != null) { conn.close(); } } return user; }
	 * 
	 * public Set<String> convertRecordToSet(String data){ Set<String> resultSet =
	 * new HashSet<String>(); if(data != null) { if(data.contains(",")){ String[]
	 * part = data.split(","); int length = part.length; for(int i = 0; i<length;
	 * i++) { resultSet.add(part[i]); } } else { resultSet.add(data); } } return
	 * resultSet; }
	 * 
	 * public Set<GrantedAuthority> converToCollection(String data){
	 * Set<GrantedAuthority> resultSet = new HashSet<>(); if(data != null) {
	 * if(data.contains(",")){ String[] part = data.split(","); int length =
	 * part.length; for(int i = 0; i<length; i++) { resultSet.add(new
	 * SimpleGrantedAuthority(part[i])); } } else { resultSet.add(new
	 * SimpleGrantedAuthority(data)); } } return resultSet; }
	 */

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		BasicClientDetails clientDetails = clientRepo.findByClientId(clientId);
		if(clientDetails!=null) 
			return clientDetails;
			else
				throw new ClientRegistrationException("The client details is wrong");
	}
	
}
