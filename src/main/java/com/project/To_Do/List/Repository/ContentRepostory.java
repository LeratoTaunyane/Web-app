package com.project.To_Do.List.Repository;

import com.project.To_Do.List.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepostory extends JpaRepository<Content, Integer> {

}
