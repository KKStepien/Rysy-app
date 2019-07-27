package kstepien.rysy.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ObjectController {

  @Autowired
  private ObjectService objectService;

  @GetMapping("/api/objects")
  public List<ObjectDTO> getObject() {
    List<Object> objects = objectService.findAll();
    List<ObjectDTO> objectsDTO = new ArrayList<>();
    for (int i = 0; i < objects.size(); i++) {
      ObjectDTO object = new ObjectDTO();
      object.setName(objects.get(i).getName());
      object.setLatitude(objects.get(i).getLatitude());
      object.setLongitude(objects.get(i).getLongitude());
      objectsDTO.add(object);
    }
    return objectsDTO;
  }

  @DeleteMapping("/api/objects/{id}")
  public void deleteObject(@PathVariable Long id) {
    objectService.deleteObject(id);
  }

  @PutMapping("/api/objects")
  public ObjectDTO createObject(@RequestBody CreateObjectDTO createObject) {
    Object object = objectService.createObject(createObject.getLongitude(), createObject.getLatitude(), createObject.getName());
    ObjectDTO objectDTO = new ObjectDTO();
    objectDTO.setLatitude(object.getLatitude());
    objectDTO.setLongitude(object.getLongitude());
    objectDTO.setName(object.getName());
    return objectDTO;
  }
}
