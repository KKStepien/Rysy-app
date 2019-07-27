package kstepien.rysy.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EntryController {

  @Autowired
  private EntryService entryService;

  @GetMapping("/api/entries")
  public List<EntryDTO> getEntry() {
    List<Entry> entries = entryService.findAll();
    List<EntryDTO> entriesDTO = new ArrayList<>();

    for (int i = 0; i < entries.size(); i++) {
      EntryDTO entryDTO = new EntryDTO();
      entryDTO.setId(entries.get(i).getEntryId());
      entryDTO.setDescription(entries.get(i).getDescription());
      entryDTO.setLatitude(entries.get(i).getLatitude());
      entryDTO.setLongitude(entries.get(i).getLongitude());
      entriesDTO.add(entryDTO);
    }
    return entriesDTO;
  }

  @DeleteMapping("/api/entry/{id}")
  public void deleteEntry(@PathVariable Long id) {
    entryService.deleteEntry(id);
  }

  @PutMapping("/api/entry")
  public EntryDTO createEntry(@RequestBody CreateEntryDTO createEntryDTO) {
    Entry entry = entryService.createdEntry(createEntryDTO.getLongitude(), createEntryDTO.getLatitude(), createEntryDTO.getDescription());
    EntryDTO entryDTO = new EntryDTO();
    entryDTO.setId(entry.getEntryId());
    entryDTO.setDescription(entry.getDescription());
    entryDTO.setLatitude(entry.getLatitude());
    entryDTO.setLongitude(entry.getLongitude());
    return entryDTO;
  }

}
