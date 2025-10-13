package com.Library.Library;

import java.lang.reflect.Constructor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * libraryService
 */

@Service
public class libraryService {

  LibraryRepo libRepo;

  @Autowired
  public libraryService(LibraryRepo libRepo) {
    this.libRepo = libRepo;
  }

  public byte[] getImageByReader(String reader) {
    Library l = libRepo.findByReader(reader);
    return l.getImage();
  }

  public List<Library> getAll() {

    return libRepo.findAll();
  }

  public Library getByReader(String reader) {

    return libRepo.findByReader(reader);
  }

  public boolean addReader(List<Library> libs) {

    libRepo.saveAll(libs);
    for (Library lib : libs) {
      if (!libRepo.existsById(lib.getId())) {
        return false;
      }
    }
    return true;
  }

  public boolean addOneReader(Library libs) {
    libRepo.save(libs);
    if (libRepo.existsById(libs.getId()))
      return true;

    return false;
  }

  public void Delete(String reader) {
    libRepo.deleteByReader(reader);
  }

  public void Update(Library lib) {
    libRepo.save(lib);
  }

}
