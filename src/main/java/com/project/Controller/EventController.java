package com.project.Controller;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.Event;
import com.project.model.Student;
import com.project.service.EventService;

@RestController
@CrossOrigin("https://localhost:4200/")

public class EventController {
	
    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/upload/";

	private EventService eventService;

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	@CrossOrigin("https://localhost:4200/")

	@PostMapping("/addevent")
	public Event createStudent(@RequestBody Event event) {
		return eventService.createEvent(event);

	}
	
	// build get all students REST API
	@GetMapping("/events")
	public List<Event> getAllevents(){
		return eventService.getEvents();
	}
	@CrossOrigin("https://localhost:4200/")

	@GetMapping("/events/student")
	public List<Event> getStudentevents(int cno){
		return eventService.getStudentEvents(cno);
	}
	@PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("file")MultipartFile multipartFile,@RequestParam("cno")int cno,@RequestParam("eventname")String eventname) throws IOException {
        //List<String> filenames = new ArrayList<>();
       // for(MultipartFile file : multipartFiles) {
		
            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            Files.createDirectories(Paths.get(DIRECTORY,String.valueOf(cno)));
            String path = DIRECTORY+"/"+String.valueOf(cno)+"/";
            Path fileStorage = get(path, filename).toAbsolutePath().normalize();
            copy(multipartFile.getInputStream(), fileStorage, REPLACE_EXISTING);
            Event e = this.eventService.getEventForImage(cno, eventname);
            e.setImagepath(filename);
            this.eventService.createEvent(e);
            
       // }
        return ResponseEntity.ok().body(filename);
    }
	@GetMapping("download")
	    public ResponseEntity<Resource> downloadFiles(@RequestParam("cno")int cno,@RequestParam("eventname")String eventname) throws IOException {
			Event e = this.eventService.getEventForImage(cno, eventname);
	        String filename =  e.getImagepath();
		    Path filePath = get(DIRECTORY,String.valueOf(cno)).toAbsolutePath().normalize().resolve( filename);
	        if(!Files.exists(filePath)) {
	            throw new FileNotFoundException(filename + " was not found on the server");
	        }
	        Resource resource = new UrlResource(filePath.toUri());
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.add("File-Name", filename);
	        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
	        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath))).headers(httpHeaders).body(resource);
	    }

//	@PostMapping("/uploadimage")
//	public boolean uploadImage(@RequestParam("cno")int cno,@RequestParam("eventname")String eventname,@RequestParam("image")MultipartFile file) throws IOException {
//		return eventService.uploadImage(cno, file);
//	}
//	@GetMapping(value="/downloadimage",produces = MediaType.IMAGE_PNG_VALUE)
//	public byte[] downloadImage(@RequestParam("cno")int cno) throws IOException {
//		return eventService.downloadImage(cno);
//	}

}
