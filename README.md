# torderTest

1. db 설계구조

![erd](https://user-images.githubusercontent.com/64891354/161763376-e0f4d0ca-e05e-453b-83b4-8e354dcd90cd.PNG)








2. 개발환경
 - 언어 : Java, HTML, javaScript
 - 개발툴 : spring Tool Suite4
 - DBMS : postgreSQL
 - FrameWork : Spring
 - api : Spring Data JPA







3. 주요 기능

  - 메뉴 : 주문할 수 있는 메뉴 선택가능
  - 장바구니 : 선택한 메뉴들을 담는기능
  - 주문표 : 주문한 메뉴 내역을 확인하는 기능
  - 결제표 : 결제완료한 주문 내역을 확인하는 기능
  
 
 
 
3-1. 메뉴

  - 메뉴를 클릭하여 장바구니 추가 가능
  - 주문표와 결제내역 확인 가능

  ![메뉴](https://user-images.githubusercontent.com/64891354/161760244-39c33db3-84a6-4edf-9b4e-9dcef56d0ba5.PNG)







3-2. 장바구니
 

- 메뉴 선택시 선택한 메뉴 전달

![장바구니코드a](https://user-images.githubusercontent.com/64891354/161762176-15f7b996-79c3-4860-af5f-69083c28705f.PNG)


- 선택한 메뉴를 장바구니 객체에 추가

![장바구니 추가](https://user-images.githubusercontent.com/64891354/161436799-2022d1ca-8dc2-4b69-b9f4-0397fb0940e1.PNG)



- 장바구니 추가된 화면
- 
![장바구니](https://user-images.githubusercontent.com/64891354/161760335-1cf6dd2e-8ca0-48c5-a085-dc6e188970cd.PNG)







3-3. 주문

- 장바구니에 담긴 메뉴들을 받아 주문db에 입력
- 장바구니 삭제

![장바구니 con](https://user-images.githubusercontent.com/64891354/161762412-a3ed387c-2f9a-4f5a-b4d7-6621fab91a0f.PNG)




- 주문표 화면

![주문표](https://user-images.githubusercontent.com/64891354/161760598-ef847c0e-4a6d-4588-b32d-7085f6c48ea2.PNG)




3-4. 결제

- 주문표의 메뉴들을 받아 결제db에 입력
- 주문db 삭제

![결제코드](https://user-images.githubusercontent.com/64891354/161762476-8206af60-e564-41c6-9ed3-ed78374f26b3.PNG)



- 결제내역 화면

![결제](https://user-images.githubusercontent.com/64891354/161760640-0cb08f4d-8283-41b9-87c4-d45354a2237c.PNG)
