package com.huseyinaydin.sha.springbootproductseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.huseyinaydin.sha.springbootproductseller.model.Role;
import com.huseyinaydin.sha.springbootproductseller.model.User;

import java.util.Optional;

/**
 * @author Hüseyin Aydın
 * @date 18.12.2021
 * @time 12:06
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    //findBy + fieldName
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param("username") String username, @Param("role")Role role);
}
