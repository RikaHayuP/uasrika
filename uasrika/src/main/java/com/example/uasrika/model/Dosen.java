
package com.example.uasrika.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_dosen")
public class Dosen {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
  @Column(nullable = false, name = "dosen_code", length = 6)
  private String code;

  @Column(nullable = false, name = "dosen_name")
  private String name;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToMany(mappedBy = "dosen")
  private List<Matakuliah> matakuliah;

    public void setUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
