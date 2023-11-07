package com.makers.makersbnb.repository;

import com.makers.makersbnb.model.Space;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// SpaceRepository inherits from CrudRepository
// The type parameters 'Space' and 'Long' relate to the Model and id
// We're saying - this repository should create instances of Space
// and the ids of those spaces should be of type Long
public interface SpaceRepository extends CrudRepository<Space, Long> {
    public List<Space> findSpaceByName(String name); // This is a derived method and follows the naming conventions
}

//      Below is a list of the SpaceRepository methods we will be using!
//      ================================================================
//
//    SpaceRepository spaceRepository = new SpaceRepository();
//
//       // create a new record:
//
//          Space treehouseSpace = new Space("treehouse");
//          spaceRespository.save(treehouseSpace)
//
//      // retrieve all records from the spaces table:
//
//          spaceRespository.findAll()
//
//      // find a record by its primary key (id):
//
//          spaceRepository.findById(id);
//
//      // delete a record (space is an instance of Space):
//
//          spaceRepository.delete(space)