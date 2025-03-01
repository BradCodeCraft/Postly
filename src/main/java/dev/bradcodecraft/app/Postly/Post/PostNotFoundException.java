package dev.bradcodecraft.app.Postly.Post;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class PostNotFoundException extends RuntimeException {
  public PostNotFoundException() {
    super("Post Not Found!");
  }
}
