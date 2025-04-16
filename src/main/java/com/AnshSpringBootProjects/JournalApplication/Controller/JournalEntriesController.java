package com.AnshSpringBootProjects.JournalApplication.Controller;

import com.AnshSpringBootProjects.JournalApplication.Entity.JournalEntries;
import com.AnshSpringBootProjects.JournalApplication.Services.JournalEntriesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntriesController {

    @Autowired
    private JournalEntriesService jes;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<JournalEntries> all = jes.getAll();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createEntry(@RequestBody JournalEntries newEntry) {
        try {
            newEntry.setDate(LocalDateTime.now());
            jes.saveEntries(newEntry);
            return new ResponseEntity<>("New Entry Saved !", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntries> getEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntries> je = jes.findById(myId);
        if(je.isPresent()){
            return new ResponseEntity<>(je.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntries> avail = jes.findById(myId);
        if(avail.isPresent()) {
            jes.deletionById(myId);
            return new ResponseEntity<>("Entry Deleted !", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId id, @RequestBody JournalEntries newEntry) {
        JournalEntries old = jes.findById(id).orElse(null);
        if(old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            jes.saveEntries(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public class UserController {



    }
}
