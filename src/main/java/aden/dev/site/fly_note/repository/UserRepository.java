package aden.dev.site.fly_note.repository;

import aden.dev.site.fly_note.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}

