package com.AnshSpringBootProjects.JournalApplication.Services;

import com.AnshSpringBootProjects.JournalApplication.Entity.JournalEntries;
import com.AnshSpringBootProjects.JournalApplication.Entity.User;
import com.AnshSpringBootProjects.JournalApplication.Repositories.JournalEntriesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntriesService {

    @Autowired
    private JournalEntriesRepository jer;

    @Autowired
    private UserService us;

    public void saveEntries(JournalEntries newEntry, String username) {
        newEntry.setDate(LocalDateTime.now());
        User user = us.findByUsername(username);
        JournalEntries saved = jer.save(newEntry);
        user.getJournalEntries().add(saved);
        us.createUser(user);
    }

    public void saveEntries(JournalEntries newEntry) {
        jer.save(newEntry);
    }

    public List<JournalEntries> getAll() {
        return jer.findAll();
    }

    public Optional<JournalEntries> findById(ObjectId id) {
        return jer.findById(id);
    }

    public JournalEntries updateEntryById(ObjectId id, JournalEntries newEntry, String username) {
        JournalEntries old = findById(id).orElse(null);
        if(old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            saveEntries(old);
        }
        return old;
    }

    public void deleteAllEntries(){
        jer.deleteAll();
    }

    public void deletionById(ObjectId id, String username) {
        User user = us.findByUsername(username);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        us.createUser(user);
        jer.deleteById(id);
    }

}
