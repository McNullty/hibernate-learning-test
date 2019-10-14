package hr.senji.hibernate.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
          fetch = FetchType.LAZY, optional = false)
  private PostDetails details;


  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public PostDetails getDetails() {
    return details;
  }

  public void setDetails(PostDetails details) {
    if (details == null) {
      if (this.details != null) {
        this.details.setPost(null);
      }
    }
    else {
      details.setPost(this);
    }
    this.details = details;
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            '}';
  }
}