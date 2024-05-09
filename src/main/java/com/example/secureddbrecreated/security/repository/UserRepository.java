package com.example.secureddbrecreated.security.repository;

import com.example.secureddbrecreated.security.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Member,Long> {
    Member findByUsername(final String username);
}
