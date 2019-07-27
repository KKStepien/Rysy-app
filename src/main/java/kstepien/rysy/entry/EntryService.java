package kstepien.rysy.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntryService {

  @Autowired
  private EntryRepository entryRepository;

  public List<Entry> findAll() {
    return entryRepository.findAll();
  }

  @Transactional
  public void deleteEntry(Long id) {
    entryRepository.deleteByEntryId(id);
  }

  public Entry createdEntry(double longitude, double lattitude, String description) {
    Entry entry = new Entry();
    entry.setCreatedDate(LocalDateTime.now());
    entry.setLongitude(longitude);
    entry.setLatitude(lattitude);
    entry.setDescription(description);
    entry.setUserId(1L); //todo powinien być brany zalogownay użytkownik

    return entryRepository.save(entry);
  }

  public Entry findEntry(Long id) {
    return entryRepository.findByEntryId(id);
  }

}

