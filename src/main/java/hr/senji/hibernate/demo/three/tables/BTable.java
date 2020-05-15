package hr.senji.hibernate.demo.three.tables;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class BTable {

  @Id
  @GeneratedValue
  private Long id;

  @OneToOne
  private ATable aTable;

  @OneToMany(mappedBy = "bTable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<CTable> ceovi;
}
