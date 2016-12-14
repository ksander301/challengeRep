package ru.test.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.bookmarks.Account;

import java.util.Optional;
@Repository
@ComponentScan(basePackages = "ru.test.bookmarks")
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
