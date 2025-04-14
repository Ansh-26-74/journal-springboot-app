package com.AnshSpringBootProjects.JournalApplication.Services;

import com.AnshSpringBootProjects.JournalApplication.Entity.JournalEntries;
import com.AnshSpringBootProjects.JournalApplication.Repositories.JournalEntriesRepositories;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntriesService {

    @Autowired
    private JournalEntriesRepositories jer;

    public void saveEntries(JournalEntries journalEntries) {
        jer.save(journalEntries);
    }

    public List<JournalEntries> getAll() {
        return jer.findAll();
    }

    public Optional<JournalEntries> findById(ObjectId id) {
        return jer.findById(id);
    }

    public void deletionById(ObjectId id) {
        jer.deleteById(id);
    }

}
