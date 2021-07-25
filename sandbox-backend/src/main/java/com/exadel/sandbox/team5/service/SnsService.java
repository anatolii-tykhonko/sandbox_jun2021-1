package com.exadel.sandbox.team5.service;

import com.amazonaws.services.sns.model.PublishResult;
import com.exadel.sandbox.team5.dto.DiscountDto;
import com.exadel.sandbox.team5.util.Message;
import org.springframework.beans.factory.annotation.Value;

public interface SnsService {

    PublishResult sendToAllUsers(Message message);

    void sendToSubscribers(DiscountDto discountDto);

    void subscribeUser(String email);
}
