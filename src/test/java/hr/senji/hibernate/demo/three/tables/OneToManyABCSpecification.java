package hr.senji.hibernate.demo.three.tables;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OneToManyABCSpecification{

  private static final Logger log = LoggerFactory.getLogger(OneToManyABCSpecification.class);

  @Autowired
  private hr.senji.hibernate.demo.three.tables.ATableRepository aTableRepository;

  @Autowired
  private hr.senji.hibernate.demo.three.tables.BTableRepository bTableRepository;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testSimpleEagerFetch() {
    final List<ATable> allData = aTableRepository.findAll();

    Assert.assertFalse(allData.isEmpty());

    List<BTable> bs = allData.stream()
        .map(ATable::getBeovi)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());

    bTableRepository.findAllByBs(bs);

    Assert.assertNotNull(allData.get(0).getBeovi().get(0).getCeovi());
  }

}