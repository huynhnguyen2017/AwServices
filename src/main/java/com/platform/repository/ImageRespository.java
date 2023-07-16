package com.platform.repository;

import com.platform.model.ImageCatcher;
import org.springframework.data.repository.CrudRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ImageRespository extends CrudRepository<ImageCatcher, Long> {
}
