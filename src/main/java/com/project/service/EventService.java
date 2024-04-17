package com.project.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.project.model.Event;
import com.project.model.ImageUtils;
import com.project.model.Student;
import com.project.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository repository;
	
	public List<Event> getEvents(){
        return (List<Event>) repository.findAll();
    }
	public List<Event> getStudentEvents(int cno){
        return (List<Event>) repository.findByCno(cno);
    }
	public Event createEvent(Event event) {
		return repository.save(event);
		
	}
	public Event getEventForImage(int cno,String eventname) {
		return repository.findByCnoAndEventname(cno, eventname);
		
	}
//	public boolean uploadImage(int cno,MultipartFile file) throws IOException {
//		Event e = repository.findByIdCno(cno);
//		e.setImage(file.getBytes());
//		if (e.getImage()!=null) {
//			repository.save(e);
//			return true;
//		}
//		else
//			return false;
//		
//	}
//	public byte[] downloadImage(int cno){
//		Event e = repository.findByIdCno(cno);
//		if(e.getImage()!=null) {
//			System.out.println("Image properly stored!");
//		}
//        //byte[] images=ImageUtils.decompressImage(e.getImage());
//        return e.getImage();
//    }
//	
}
