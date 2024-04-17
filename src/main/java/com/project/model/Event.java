package com.project.model;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "event")
@IdClass(EventIdentity.class)

public class Event {
	@Id
	@Column(name="eventname")
	String eventname;
	String oragnizer;
	@Id
	@Column(name="cno")
	int cno;
	String category;
	String level;
	String doe;
	String participation_status;
	String imagepath;
//	@Lob
//	@Column(length = 20971520)
//
//	byte[] image;

//	public int getcno() {
//		return cno;
//	}
//	public void setCno(int cno) {
//		this.cno = cno;
//	}
//	public String getEventname() {
//		return eventname;
//	}
//	public void setEventname(String eventname) {
//		this.eventname = eventname;
//	}
	public String getOragnizer() {
		return oragnizer;
	}
	public void setOragnizer(String oragnizer) {
		this.oragnizer = oragnizer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public String getDoe() {
		return doe;
	}
	public void setDoe(String doe) {
		this.doe = doe;
	}
	public String getParticipation_status() {
		return participation_status;
	}
	public void setParticipation_status(String participation_status) {
		this.participation_status = participation_status;
	}
	public String getImagepath() {
		return this.imagepath;
	}
	public void setImage(String image) {
		this.imagepath = image;
	}






}
