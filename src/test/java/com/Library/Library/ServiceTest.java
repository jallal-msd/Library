package com.Library.Library;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
  @Mock
  LibraryRepo repo;
  @InjectMocks
  libraryService service;

  @Test
  public void testService() {
    System.out.println("service test");
    Library lib = new Library();
    service.addOneReader(lib);

  }

  @Test
  public void GetLibrary() {

    System.out.println("service get test");
    List<Library> lib = service.getAll();
  }
}
