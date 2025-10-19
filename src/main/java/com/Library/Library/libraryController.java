package com.Library.Library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

/**
 * libraryController
 */
@RestController
public class libraryController {

  LibraryRepo libRepo;

  @Autowired
  libraryService libService;

  @Autowired
  libraryController(LibraryRepo libRepo) {
    this.libRepo = libRepo;
  }

  // @GetMapping("/api")
  // public String getHome() {
  // return "Home";
  // }

  @GetMapping("/api/img/{reader}")
  public byte[] getReaderImage(@PathVariable(name = "reader") String reader) {
    return libService.getImageByReader(reader);

  }

  @GetMapping("/api/{reader}")
  public ResponseEntity<Library> getReader(@PathVariable(name = "reader") String reader) {
    Library l = libService.getByReader(reader);
    if (l != null) {
      return new ResponseEntity<Library>(l, HttpStatus.OK);
    }
    return new ResponseEntity<Library>(l, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/api/all")
  public List<Library> getReader() {
    return libService.getAll();
  }

  @GetMapping("/api/book/{id}")
  public ResponseEntity<Library> getById(@PathVariable(name = "id") int id) {
    try {

      return new ResponseEntity<>(libService.getBook(id), HttpStatus.OK);
    } catch (Exception e) {
      // TODO: handle exception

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @Transactional
  @PutMapping("/update")
  public void updateLibrary(@RequestBody Library lib) {
    libService.Update(lib);

  }

  @PostMapping("/add/books")
  public ResponseEntity<String> addBooks(@RequestBody List<Library> lib) {
    if (libService.addReader(lib)) {
      return new ResponseEntity<String>("ADDED ", HttpStatus.OK);
    }
    return new ResponseEntity<String>("SomeThing Went Wrong", HttpStatus.BAD_REQUEST);
  }

  //
  @Transactional
  @DeleteMapping("/book/delete/{reader}")
  public void removeBook(@PathVariable(name = "reader") String reader) {
    libService.Delete(reader);

  }

  @Transactional
  @PostMapping("/add")
  public void addBook(@RequestBody Library lib) {
    libService.addOneReader(lib);
  }
}
