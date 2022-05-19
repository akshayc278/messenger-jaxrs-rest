package org.akshay.techie.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.akshay.techie.messenger.database.DatabaseConfig;
import org.akshay.techie.messenger.exception.DataNotfoundException;
import org.akshay.techie.messenger.model.MessageClass;
import org.akshay.techie.messenger.resources.ProfileResource;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

public class MessageService {

	private Map<Long, MessageClass> messages = DatabaseConfig.getMessages();

	public MessageService() {
		MessageClass m1 = new MessageClass(1L, "message1", "akshay");
		MessageClass m2 = new MessageClass(2L, "message2", "kshitija");
		messages.put(1L, m1);
		messages.put(2L, m2);
	}

	public List<MessageClass> getMessages() {
		return new ArrayList<MessageClass>(messages.values());

	}

	public List<MessageClass> getMessagesForYear(int year) {
		List<MessageClass> list = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (MessageClass msg : messages.values()) {
			cal.setTime(msg.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				list.add(msg);
			}
		}
		return list;
	}

	public List<MessageClass> getAllMessagesPaginated(int start, int size) {
		ArrayList<MessageClass> list = new ArrayList<>(messages.values());
		if (start + size > list.size())
			return new ArrayList<MessageClass>();
		return list.subList(start, start + size);
	}

	public MessageClass getMessage(long id) {
		MessageClass mc = messages.get(id);
		if (mc == null) {
			throw new DataNotfoundException("message id with " + id + " not found");// one way to handle exception
		}
		return mc;
	}

	public MessageClass addMessage(MessageClass messageClass) {
		messageClass.setId(messages.size() + 1);
		messages.put(messageClass.getId(), messageClass);
		return messageClass;
	}

	public MessageClass updateMessage(MessageClass messageClass) {
		if (messageClass.getId() <= 0) {
			return null;
		} else {
			messages.put(messageClass.getId(), messageClass);
			return messageClass;
		}
	}

	public MessageClass removeMessage(long id) {
		return messages.remove(id);
	}
}
