package hr.senji.hibernate.demo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OneToOneTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostDetailsRepository postDetailsRepository;

  @Test
  public void testOneToOneMapping() {

    PostDetails postDetails = new PostDetails();
    postDetails.setCreatedBy("Testronic");
    postDetails.setCreatedOn(new Date());


    Post post = new Post();
    post.setTitle("Test Title");
    post.setDetails(postDetails);

    final Post savedPost = entityManager.persist(post);

    System.out.println("post: " + savedPost);
    System.out.println("postDetails: " + savedPost.getDetails());

    Assert.assertNotNull(savedPost);

    final List<Post> allPosts = postRepository.findAll();
//
//    Assert.assertNotNull(allPosts);
//
//    PostDetails postDetailsLoaded = allPosts.get(0).getDetails();
//    Assert.assertNotNull(postDetailsLoaded);

    Optional<PostDetails> postDetailsLoaded2 = postDetailsRepository.findById(1l);
    Assert.assertTrue(postDetailsLoaded2.isPresent());
    System.out.println("Created by: " + postDetailsLoaded2.get().getCreatedBy());
  }
}
