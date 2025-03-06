# 우분투 ollama 설치
1. 터미널에 curl -fsSL https://ollama.com/install.sh | sh
2. 터미널에 ollama serve (Spring AI 가 연동되는 포트 확인 : listen tcp 127.0.0.1:11434 --> application.yml 에 설정)
3. 터미널에 ollama run llama3.2
4. 다른 터미널에서 ollama list 로 LLM Name확인 (Name을 application.yml 에 설정)


# 소스 코드 다운 후 eclipse에서 실행
Spring Boot App으로 실행

# 접속 테스트
- GET 방식 : http://localhost:8080/helpdesk/chat3?message=Hello
- POST 방식 : PostMan을 실행하여 json 방식으로 key로 prompt_message, history_id 에 값을 입력하여 테스트
  예)"prompt_message": "I can't connect to my internet", "history_id": "1234"
