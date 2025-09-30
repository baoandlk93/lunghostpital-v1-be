package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.org.bvpkh.bvpkh_gov.entities.Tag;

public interface ITagRepository extends JpaRepository<Tag, Long> {
}
