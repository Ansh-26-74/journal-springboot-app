package com.AnshSpringBootProjects.JournalApplication.Entity;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "Journal_Entries")
@Getter
@Setter
public class JournalEntries {

    @Id
    private ObjectId id;

    private String title;

    private String content;

    private LocalDateTime date;

}
