package pl.reaktor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.reaktor.model.Posts;

@Repository
public interface PostsRepo extends JpaRepository<Posts,Long> {
	
}
