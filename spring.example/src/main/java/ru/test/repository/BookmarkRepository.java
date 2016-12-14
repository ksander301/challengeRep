package ru.test.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.bookmarks.Bookmark;

import java.util.Collection;

@Repository
@ComponentScan(basePackages = "ru.test.bookmarks")
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
}
