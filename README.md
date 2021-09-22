# springbootlocalization

springboot auto configuration 에서 messagesource 는 기본으로 resourcebundlemessagesource 빈을 생성한다. message 를 읽는 위치는 spring.messages.basename 으로 설정 (기본은 messages)
springboot main class 에서 autowired 를 하려면, @PostConstrut 를 이용할것 (모든 Properties 를 셋팅한 후에 실행함)

