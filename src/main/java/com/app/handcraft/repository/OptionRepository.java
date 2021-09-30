package com.app.handcraft.repository;

import com.app.handcraft.entity.Opt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Opt, Long> {
}
