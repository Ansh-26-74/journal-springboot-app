package com.AnshSpringBootProjects.JournalApplication.Controller;

import com.AnshSpringBootProjects.JournalApplication.Entity.JournalEntries;
import com.AnshSpringBootProjects.JournalApplication.Entity.User;
import com.AnshSpringBootProjects.JournalApplication.Services.JournalEntriesService;
import com.AnshSpringBootProjects.JournalApplication.Services.UserService;
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

    @Autowired
    private UserService us;

    @GetMapping("/entries/{username}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String username) {
        User user = us.findByUsername(username);
        List<JournalEntries> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create/{username}")
    public ResponseEntity<String> createEntry(@RequestBody JournalEntries newEntry, @PathVariable String username) {
        try {
            jes.saveEntries(newEntry, username);
            return new ResponseEntity<>("New Entry Saved !", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
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

    @DeleteMapping("{username}/id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId, @PathVariable String username) {
        Optional<JournalEntries> avail = jes.findById(myId);
        if(avail.isPresent()) {
            jes.deletionById(myId, username);
            return new ResponseEntity<>("Entry Deleted !", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEntries() {
        jes.deleteAllEntries();
        return new ResponseEntity<>("All Entries Deleted", HttpStatus.OK);
    }

    @PutMapping("{username}/id/{id}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId id, @RequestBody JournalEntries newEntry, @PathVariable String username) {
        JournalEntries old = jes.updateEntryById(id, newEntry, username);
        if(old != null) {
            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
