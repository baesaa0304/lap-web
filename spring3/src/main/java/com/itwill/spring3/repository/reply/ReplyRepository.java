package com.itwill.spring3.repository.reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.spring3.repository.post.Post;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
    
    // Post (id)로 검색하기:
    List<Reply> findByPostOrderByIdDesc(Post post);
    
    List<Reply> findByPostId(Long postId);
    
    // Post에 달린 댓글 개수 :
    Long countByPost(Post post);
}
