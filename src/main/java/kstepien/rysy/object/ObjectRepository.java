package kstepien.rysy.object;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface ObjectRepository extends Repository<Object, Long> {

  List<Object> findAll();

  void deleteByObjectId(Long id);

  Object save(Object object);

  Object findByObjectId(Long id);
}
