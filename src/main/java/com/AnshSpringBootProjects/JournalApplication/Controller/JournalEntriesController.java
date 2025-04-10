package com.AnshSpringBootProjects.JournalApplication.Controller;

import com.AnshSpringBootProjects.JournalApplication.Entity.JournalEntries;
import com.AnshSpringBootProjects.JournalApplication.JournalApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntriesController {

    private Map<Long, JournalEntries> je = new HashMap<>();

    private Long idCounter = 1L;

    @GetMapping
    public List<JournalEntries> getAll() {
        return new ArrayList<>(je.values());
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntries newEntry) {
        newEntry.setId(idCounter++);
        je.put(newEntry.getId(), newEntry);
        return "New Entry Created with ID: " + newEntry.getId();
    }

    @GetMapping("/id/{myId}")
    public JournalEntries getEntryById(@PathVariable Long myId) {
        return je.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntries deleteEntryById(@PathVariable Long myId) {
        return je.remove(myId);
    }

    @PutMapping
    public JournalEntries updateEntryById(@RequestBody JournalEntries newEntry) {
        return je.put(newEntry.getId(), newEntry);
    }

}
