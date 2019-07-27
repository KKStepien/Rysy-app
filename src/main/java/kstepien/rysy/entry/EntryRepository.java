package kstepien.rysy.entry;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface EntryRepository extends Repository<Entry, Long> {

  List<Entry> findAll();

  void deleteByEntryId(Long id);

  Entry save(Entry entry);

  Entry findByEntryId(Long id);
}

