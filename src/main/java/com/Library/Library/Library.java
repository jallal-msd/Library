package com.Library.Library;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "library")
public class Library {

  public Library() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String reader;
  private String book;
  private String image_type;
  @Column(columnDefinition = "LONGBLOB")
  private byte[] image;
  private String image_name;

  public String getImage_type() {
    return image_type;
  }

  public void setImage_type(String image_type) {
    this.image_type = image_type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImage_name() {
    return image_name;
  }

  public void setImage_name(String image_name) {
    this.image_name = image_name;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public String getReader() {
    return reader;
  }

  public void setReader(String reader) {
    this.reader = reader;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "reader :" + this.book + "ad reader is " + this.reader;
  }

}
