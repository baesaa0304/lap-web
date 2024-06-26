package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class PostUpdate
 */
@WebServlet(name = "postUpdate" , urlPatterns = {"/post/update"})
public class PostUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(PostUpdate.class);
	
	private final PostService postService = PostService.getInstance();
	
	/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
       log.info("doPost()");
       
       // 요청 파라미터의 값(id, title, content)을 찾음.
       long id = Long.parseLong(request.getParameter("id"));
       String title = request.getParameter("title");
       String content = request.getParameter("content");
       
       Post post = new Post(id, title, content, null, null, null);
       
       log.info("수정할 포스트 = {}" , post);
       
       // 서비스 계층의 메서드 호출해서 실제로 DB에 업데이트.
       int result = postService.update(post);
       log.info("포스트 업데이트 결과 = {}", result);
       
       // 수정 후 상세보기 페이지로 redirect
       response.sendRedirect("/post/post/detail?id=" + id);
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
