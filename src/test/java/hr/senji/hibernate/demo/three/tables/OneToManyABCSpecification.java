package hr.senji.hibernate.demo.three.tables;

import java.util.List;

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
  private ATableRepository aTableRepository;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testSimpleEagerFetch() {
    final List<ATable> allData = aTableRepository.findAll();

    Assert.assertFalse(allData.isEmpty());
  }

}