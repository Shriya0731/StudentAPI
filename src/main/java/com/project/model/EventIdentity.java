package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
 
//class contain more than 1 primary key columns.
 
//lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//spring jpa annotation
@Embeddable
public class EventIdentity implements Serializable {
 
    @Column(name = "cno",nullable = false)
    int cno;
    @Column(name = "eventname", nullable = false)
    String eventname;
}