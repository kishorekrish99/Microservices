package com.kishore.cards.Service;

import org.springframework.stereotype.Service;

import com.kishore.cards.Dto.CardsDto;

@Service
public interface ICardService {
	
	
   void createCard(String mobileNumber);

   
   CardsDto fetchCard(String mobileNumber);

   
   boolean updateCard(CardsDto cardsDto);

   
   boolean deleteCard(String mobileNumber);

}
