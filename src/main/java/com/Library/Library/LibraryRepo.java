package com.Library.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * LibraryRepo
 */
public interface LibraryRepo extends JpaRepository<Library, Integer> {

  Library findByReader(String reader);

  // @Query("DELETE FROM library where reader =:reader ")
  void deleteByReader(String reader);

  // @Modifying
  // @Query(nativeQuery = true, value = "UPDATE library set book = :lib.book where
  // reader = :reader")
  // void updateByReader(String reader, Library lib);

}
