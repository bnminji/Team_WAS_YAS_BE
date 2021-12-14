package org.prgrms.yas.domain.post.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import org.prgrms.yas.domain.post.domain.RoutinePost;

@Getter
public class PostDetailResponse {
  private Long postId;
  private String createdAt;
  private String updatedAt;
  private UserDto user;
  private RoutineDto routine;
  private List<CommentDto> comments;

  @Builder
  public PostDetailResponse(RoutinePost routinePost) {
    this.postId = routinePost.getId();
    this.createdAt = routinePost.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    this.updatedAt = routinePost.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    this.user = new UserDto(routinePost.getRoutine().getUser());
    this.routine = new RoutineDto(routinePost.getRoutine());
    this.comments = routinePost.getComments()
                               .stream().filter(c->c.isDeleted()==false).map(CommentDto::new)
                               .collect(Collectors.toList());
  }
}
