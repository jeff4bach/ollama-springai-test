package com.ollamatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ollamatest.model.HelpDeskResponse;
import com.ollamatest.service.HelpDeskChatbotAgentService;
import com.ollamatest.model.HelpDeskRequest;

@RestController
@RequestMapping("/helpdesk")
public class HelpDeskController {

	@Autowired
	private HelpDeskChatbotAgentService helpDeskChatbotAgentService;

    // all-arg constructor

    @PostMapping("/chat")
    public ResponseEntity<HelpDeskResponse> chat(@RequestBody HelpDeskRequest helpDeskRequest) {
    	 System.out.println("request => " + helpDeskRequest.getPromptMessage());
        String chatResponse = helpDeskChatbotAgentService.call(helpDeskRequest.getPromptMessage(), helpDeskRequest.getHistoryId());
        System.out.println("response => " + chatResponse);
        return new ResponseEntity<>(new HelpDeskResponse(chatResponse), HttpStatus.OK);
    }
    
    @GetMapping("/chat3")
    public String generateString2(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
    	System.out.println("question => " + message);
    	String result =  helpDeskChatbotAgentService.call3(message);
    	System.out.println("answer => " + result);
    	return result;
    }
}
