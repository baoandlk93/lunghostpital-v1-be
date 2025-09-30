package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.org.bvpkh.bvpkh_gov.entities.users.Author;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
}
