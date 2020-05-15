package hr.senji.hibernate.demo.three.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CTable {

  @Id
  @GeneratedValue
  private Long id;

  @OneToOne
  private BTable bTable;
}
