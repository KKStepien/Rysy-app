package kstepien.rysy.object;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.time.LocalDateTime;
    import java.util.List;

@Service
public class ObjectService {

  @Autowired
  private ObjectRepository objectRepository;

  public List<Object> findAll(){
    return objectRepository.findAll();
  }

  @Transactional
  public void deleteObject(Long id){
    objectRepository.deleteByObjectId(id);
  }

  public Object createObject(double longitude, double lattitude, String name){
    Object object = new Object();
    object.setName(name);
    object.setLatitude(lattitude);
    object.setLongitude(longitude);
    object.setCreatedDate(LocalDateTime.now());
    object.setUserId(2L); //todo powinien być brany zalogownay użytkownik

    return objectRepository.save(object);
  }

  public Object findByObjectId(Long id){
    return objectRepository.findByObjectId(id);
  }
}
