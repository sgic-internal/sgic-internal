package com.sgic.internal.defecttracker.defect.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.repositories.CommentRepository;
import com.sgic.internal.defecttracker.defect.services.CommentService;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comments createComments(Comments comments) {
		Comments responseComments = commentRepository.save(comments);
		return responseComments;
	}

	@Override
	public List<Comments> getCommentsById(String defectId) {
		return commentRepository.findCommentsByDefectId(defectId);
	}

	@Override
	public List<Comments> getAllComments() {
		return commentRepository.findAll();
	}

	@Override
	public void deleteById(Long commentId) {
		commentRepository.deleteById(commentId);

	}

}
