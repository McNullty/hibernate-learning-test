package hr.senji.hibernate.demo.three.tables;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class ATable {
  @Id
  @GeneratedValue
  private Long id;

  @OneToMany(mappedBy = "aTable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<BTable> beovi;
}
