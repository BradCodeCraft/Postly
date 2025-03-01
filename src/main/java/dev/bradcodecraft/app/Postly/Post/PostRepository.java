package dev.bradcodecraft.app.Postly.Post;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
class PostRepository {
  private JdbcClient jdbcClient;

  public PostRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // CREATE
  public void create(Post post) {
    Integer temporaryValue = this.jdbcClient.sql("INSERT INTO post VALUES (?, ?, ?, ?, ?, ?)")
        .params(List.of(post.getPostId(), post.getPostTitle(), post.getPostCategory(), post.getPostContent(),
            post.getPostPublishedDate(), post.getPostTags()))
        .update();

    Assert.state(temporaryValue == 1, "Failed to create post " + post.getPostId());
  }

  // READ
  public List<Post> readAll() {
    return this.jdbcClient.sql("SELECT * FROM post ORDER BY post_id")
        .query(Post.class)
        .list();
  }

  public Optional<Post> readById(Integer postId) {
    return this.jdbcClient.sql("SELECT * FROM post WHERE post_id = :post_id")
        .param("post_id", postId)
        .query(Post.class)
        .optional();
  }

  // UPDATE
  public void updateById(Integer postId, Post post) {
    Integer temporaryValue = this.jdbcClient.sql(
        "UPDATE post SET post_title = ?, post_category = ?, post_content = ?, post_published_date = ?, post_tags = ? WHERE post_id = ?")
        .params(List.of(post.getPostTitle(), post.getPostCategory(), post.getPostContent(), post.getPostPublishedDate(),
            post.getPostTags(), postId))
        .update();

    Assert.state(temporaryValue == 1, "Failed to update post " + post.getPostId());
  }

  // DELETE
  public void deleteById(Integer postId) {
    Integer temporaryValue = this.jdbcClient.sql("DELETE FROM post WHERE post_id = :post_id")
        .param("post_id", postId)
        .update();

    Assert.state(temporaryValue == 1, "Failed to delete post " + postId);
  }
}
