package com.dat3.webclient.repository;

import com.dat3.webclient.entity.CombinedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepo extends JpaRepository<CombinedInfo, String> {
}
