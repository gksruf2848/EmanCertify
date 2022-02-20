package org.tain.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.jpa.domain.TblUser;

@RepositoryRestResource
public interface TblUserRepository extends JpaRepository<TblUser, Long>{

}
