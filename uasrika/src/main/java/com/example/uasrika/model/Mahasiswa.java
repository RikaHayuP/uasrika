package com.example.uasrika.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_mahasiswa")

public class Mahasiswa {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "mahasiswa_nim", length = 10)
  private String nim;

  @Column(nullable = false, name = "mahasiswa_name")
  private String name;

  @ManyToMany
  private Matakuliah matakuliah;
    
}
