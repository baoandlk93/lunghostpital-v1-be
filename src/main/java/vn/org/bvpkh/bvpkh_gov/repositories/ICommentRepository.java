package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.org.bvpkh.bvpkh_gov.entities.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
