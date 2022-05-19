package org.akshay.techie.messenger.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class MessageClass {

	private long id;
	private String messageBody;
	private Date created;
	private String author;

	private List<Link> links=new ArrayList<>();
	
	public MessageClass() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public MessageClass(long id, String messageBody, String author) {
		this.id = id;
		this.messageBody = messageBody;
		this.created = new Date();
		this.author = author;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url,String rel) {
		Link link=new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

	
}
