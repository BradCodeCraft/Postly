package dev.bradcodecraft.app.Postly.Post;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
class Post {
  @Id
  @Column(name = "post_id")
  private Integer postId;
  @Column(name = "post_title")
  private String postTitle;
  @Column(name = "post_category")
  private String postCategory;
  @Column(name = "post_content")
  private String postContent;
  @Column(name = "post_published_date")
  private LocalDateTime postPublishedDate;
  @Column(name = "post_tags")
  private String postTags;

  public Post(Integer postId, String postTitle, String postCategory, String postContent,
      LocalDateTime postPublishedDate, String postTags) {
    this.postId = postId;
    this.postTitle = postTitle;
    this.postCategory = postCategory;
    this.postContent = postContent;
    this.postPublishedDate = postPublishedDate;
    this.postTags = postTags;
  }

  public Integer getPostId() {
    return this.postId;
  }

  public String getPostTitle() {
    return this.postTitle;
  }

  public String getPostCategory() {
    return this.postCategory;
  }

  public String getPostContent() {
    return this.postContent;
  }

  public LocalDateTime getPostPublishedDate() {
    return this.postPublishedDate;
  }

  public String getPostTags() {
    return this.postTags;
  }
}
