package dev.bradcodecraft.app.Postly.Post;

class PostNotFoundException extends RuntimeException {
  public PostNotFoundException() {
    super("Post Not Found!");
  }
}
