6752de0 (HEAD -> main, origin/main) ==REST API study end==
478378d default_batch_fetch_size를 통해서 N+1 문제를 해결할 수 있음
82e587c 55강, msg 뿐 아니라 resultCode 까지 받는 ServiceException 도입, 편리함
12040df 수 많은 예외를 다 다루기 어렵다면 RuntimeException로 예외를 처리해도 됨
4cde2cd 회원 샘플 데이터 추가
bda3bf5 운영 모드가 아닐 때는 콘솔에 StackTrace를 자세히 출력
e3f62f9 @ControllerAdvice와 @ExceptionHandler로 전역으로 예외 처리하기
651b146 AOP를 활용하여 resultCode의 앞부분을 HTTP 응답코드로 설정 되도록
aece645 ResponseEntity를 이용하면 상태코드를 변경할 수 있음
3a1517d 반환 데이터가 없는 응답을 명시적으로 표현하기 위해 제네릭과 Void 사용
ca3d947 PUT test
11524b9 ReqBody ReqBody 클래스를 레코드로 변경
05782ef RsData 클래스를 도입하여 응답 양식 통일
1149de5 DELETE test
a387425 샘플 데이터 생성 & GET test
