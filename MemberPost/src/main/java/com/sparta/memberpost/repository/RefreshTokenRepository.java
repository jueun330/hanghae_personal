package com.sparta.memberpost.repository;

import com.sparta.memberpost.domain.Member;
import com.sparta.memberpost.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByMember(Member member);
}
