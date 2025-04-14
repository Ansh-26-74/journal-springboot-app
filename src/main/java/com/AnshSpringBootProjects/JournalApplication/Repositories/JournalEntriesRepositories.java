package com.AnshSpringBootProjects.JournalApplication.Repositories;

import com.AnshSpringBootProjects.JournalApplication.Entity.JournalEntries;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntriesRepositories extends MongoRepository<JournalEntries, ObjectId> {
}
