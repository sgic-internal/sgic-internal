package com.sgic.internal.defecttracker.defect.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.controller.dto.converter.CommentDtoConverter;
import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.services.CommentService;

@Service
public class CommentMapper {
	@Autowired
	private CommentDtoConverter commentDtoConverter;
	@Autowired
	private CommentService commentService;
	
	
	public Comments createComments(CommentData commentData) {
		Comments responseComments = commentService.createComments(commentDtoConverter.DTOtoEntity(commentData));
		return responseComments;
	}

	public List<Comments> getCommentsById(String defectId) {
		return commentService.getCommentsById(defectId);
	}
	public List<CommentData> getAllById() {
		List<Comments> commentList =commentService.getAllComments();
		return commentDtoConverter.ListEntityToDTO(commentList);
	}
}
