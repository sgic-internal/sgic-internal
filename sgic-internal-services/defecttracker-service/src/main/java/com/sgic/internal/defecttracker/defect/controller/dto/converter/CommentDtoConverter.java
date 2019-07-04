package com.sgic.internal.defecttracker.defect.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.entities.Defect;

@Service
public class CommentDtoConverter {

	public Comments DTOtoEntity(CommentData commentData) {
		Comments comments = new Comments();
		comments.setCommentId(commentData.getCommentId());
		comments.setCommentedDate(commentData.getCommentedDate());
		comments.setComments(commentData.getComments());

		Defect defect = new Defect();
		defect.setDefectId(commentData.getDefectId());
		comments.setDefect(defect);

		return comments;
	}

	public CommentData EntitytoDTO(Comments comments) {

		CommentData commentDto = new CommentData();
		commentDto.setCommentId(comments.getCommentId());
		commentDto.setCommentedDate(comments.getCommentedDate());
		commentDto.setComments(comments.getComments());
		commentDto.setDefectId(comments.getDefect().getDefectId());

		return commentDto;
	}

	public List<CommentData> ListEntityToDTO(List<Comments> comments) {

		ArrayList<CommentData> list = new ArrayList<>();
		for (Comments comment : comments) {

			CommentData commentData = new CommentData();

			commentData.setCommentId(comment.getCommentId());
			commentData.setComments(comment.getComments());
			commentData.setDefectId(comment.getDefect().getDefectId());
			commentData.setCommentedDate(comment.getCommentedDate());

			list.add(commentData);
		}
		return list;
	}

}
