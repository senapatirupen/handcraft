package com.app.handcraft.dto;

public class FeedbackTransformer {
    public com.app.handcraft.web.model.Feedback transfer(com.app.handcraft.entity.Feedback fromFeedback){
        com.app.handcraft.web.model.Feedback toFeedback = new com.app.handcraft.web.model.Feedback();
        toFeedback.setFeId(fromFeedback.getFeId());
        toFeedback.setOrIds(fromFeedback.getOrIds());
        toFeedback.setPrId(fromFeedback.getPrId());
        toFeedback.setRating(fromFeedback.getRating());
        toFeedback.setReview(fromFeedback.getReview());
        toFeedback.setFeedback(fromFeedback.getFeedback());
        return toFeedback;
    }

    public com.app.handcraft.entity.Feedback transfer(com.app.handcraft.web.model.Feedback fromFeedback){
        com.app.handcraft.entity.Feedback toFeedback = new com.app.handcraft.entity.Feedback();
        toFeedback.setFeId(fromFeedback.getFeId());
        toFeedback.setOrIds(fromFeedback.getOrIds());
        toFeedback.setPrId(fromFeedback.getPrId());
        toFeedback.setRating(fromFeedback.getRating());
        toFeedback.setReview(fromFeedback.getReview());
        toFeedback.setFeedback(fromFeedback.getFeedback());
        return toFeedback;
    }
}
