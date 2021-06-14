package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Class for Show - Part of SR's API response.
 *
 * Find documentation of API at https://sverigesradio.se/api/documentation/v2/metoder/program.html
 * The properties was generated at https://www.site24x7.com/tools/json-to-java.html
 * using the response from https://api.sr.se/api/v2/programs/index?format=json&pagination=false
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {
	private String description;
	private String broadcastinfo;
	private String email;
	private String phone;
	private String programurl;
	private String programslug;
	private String programimage;
	private String programimagetemplate;
	private String programimagewide;
	private String programimagetemplatewide;
	private String socialimage;
	private String socialimagetemplate;
	ArrayList<Object> socialmediaplatforms = new ArrayList<Object>();
	Channel ChannelObject;
	private boolean archived;
	private boolean hasondemand;
	private boolean haspod;
	private String responsibleeditor;
	private float id;
	private String name;


	// Getter Methods 

	public String getDescription() {
		return description;
	}

	public String getBroadcastInfo() {
		return broadcastinfo;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getProgramurl() {
		return programurl;
	}

	public String getProgramslug() {
		return programslug;
	}

	public String getProgramimage() {
		return programimage;
	}

	public String getProgramimagetemplate() {
		return programimagetemplate;
	}

	public String getProgramimagewide() {
		return programimagewide;
	}

	public String getProgramimagetemplatewide() {
		return programimagetemplatewide;
	}

	public String getSocialimage() {
		return socialimage;
	}

	public String getSocialimagetemplate() {
		return socialimagetemplate;
	}

	public Channel getChannel() {
		return ChannelObject;
	}

	public boolean getArchived() {
		return archived;
	}

	public boolean getHasondemand() {
		return hasondemand;
	}

	public boolean getHaspod() {
		return haspod;
	}

	public String getResponsibleeditor() {
		return responsibleeditor;
	}

	public float getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Setter Methods 

	public void setDescription( String description ) {
		this.description = description;
	}

	public void setBroadcastInfo( String broadcastinfo ) {
		this.broadcastinfo = broadcastinfo;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public void setPhone( String phone ) {
		this.phone = phone;
	}

	public void setProgramurl( String programurl ) {
		this.programurl = programurl;
	}

	public void setProgramslug( String programslug ) {
		this.programslug = programslug;
	}

	public void setProgramimage( String programimage ) {
		this.programimage = programimage;
	}

	public void setProgramimagetemplate( String programimagetemplate ) {
		this.programimagetemplate = programimagetemplate;
	}

	public void setProgramimagewide( String programimagewide ) {
		this.programimagewide = programimagewide;
	}

	public void setProgramimagetemplatewide( String programimagetemplatewide ) {
		this.programimagetemplatewide = programimagetemplatewide;
	}

	public void setSocialimage( String socialimage ) {
		this.socialimage = socialimage;
	}

	public void setSocialimagetemplate( String socialimagetemplate ) {
		this.socialimagetemplate = socialimagetemplate;
	}

	public void setChannel( Channel channelObject ) {
		this.ChannelObject = channelObject;
	}

	public void setArchived( boolean archived ) {
		this.archived = archived;
	}

	public void setHasondemand( boolean hasondemand ) {
		this.hasondemand = hasondemand;
	}

	public void setHaspod( boolean haspod ) {
		this.haspod = haspod;
	}

	public void setResponsibleeditor( String responsibleeditor ) {
		this.responsibleeditor = responsibleeditor;
	}

	public void setId( float id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}
}
