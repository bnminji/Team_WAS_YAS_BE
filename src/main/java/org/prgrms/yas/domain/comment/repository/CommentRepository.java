package org.prgrms.yas.domain.comment.repository;

import org.prgrms.yas.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
