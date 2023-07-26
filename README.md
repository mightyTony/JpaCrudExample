# JpaCrudExample

% version v0.0.1 %

## User CRUD 예제 프로젝트 입니다. 

## API 테스트 하는 법 

프로젝트를 Clone 한 후 gradle로 dependency에 등록된 것만 로드 하고  application.yml 에 맞게 DB만 설정 해주면 아무런 문제 없이 실행이 잘 될 것이다.

웹에 localhost:8888/swagger.html 를 치면 API를 테스트 할 수 있는 Swagger UI가 나올 것이다.

테스트용 더미 데이터는 resourecs/dummy 에 json, sql 에 두었다.

## 스웨거 화면
![thumb](https://github.com/mightyTony/JpaCrudExample/assets/105908185/2fbb92c8-7be6-47df-9460-19eff80373dc)


# 추후 예정 
- Google Auth 로그인 구현 
- HTTPS 설정 
- Aws EC2에 배포
- RDS에 DB 서버 만들기
- Jenkins를 통해 무중단 배포 

