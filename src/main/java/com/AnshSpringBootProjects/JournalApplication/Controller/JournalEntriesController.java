package com.AnshSpringBootProjects.JournalApplication.Controller;

import com.AnshSpringBootProjects.JournalApplication.Entity.JournalEntries;
import com.AnshSpringBootProjects.JournalApplication.Services.JournalEntriesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntriesController {

    @Autowired
    private JournalEntriesService jes;

    private Long idCounter = 1L;

    @GetMapping
    public List<JournalEntries> getAll() {
        return jes.getAll();
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntries newEntry) {
        newEntry.setDate(LocalDateTime.now());
        jes.saveEntries(newEntry);
        return "New Entry Saved !";
    }

    @GetMapping("/id/{myId}")
    public JournalEntries getEntryById(@PathVariable ObjectId myId) {
        return jes.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntries deleteEntryById(@PathVariable ObjectId myId) {
        jes.deletionById(myId);
        return jes.findById(myId).orElse(null);
    }

    @PutMapping("/id/{id}")
    public JournalEntries updateEntryById(@PathVariable ObjectId id, @RequestBody JournalEntries newEntry) {
        JournalEntries old = jes.findById(id).orElse(null);
        if(old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }

        jes.saveEntries(newEntry);
        return jes.findById(id).orElse(null);
    }

}
