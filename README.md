
# hatech 同创智能云容灾监控管理系统1.0

## 项目一级空间包架构

|空间包名称                |说明    |
|----------------|----------------|
|hatech|`同创智能云容灾监控管理系统`|


## hatech项目二级空间包架构

|空间包名称       |说明       |
|----------------|-----------|
|hatech-app|`同创云资源池空间包`|
|hatech-auth|`同创云认证鉴权空间包`|
|hatech-center|`同创云核心空间包`|

## hatech-app项目二级空间包架构

|微服务名称       |说明       |端口       |
|----------------|-----------|-----------|
|hatech-app-demo|`同创云demo例子微服务`|`9000`|
|hatech-app-business|`同创云business例子微服务`|`9001`|

## hatech-auth项目二级空间包架构

|微服务名称       |说明       |端口       |
|----------------|-----------|-----------|
|hatech-auth-server|`同创云认证鉴权服务端微服务`|`8070`|

## hatech-center项目二级空间包架构

|微服务名称       |说明       |端口       |
|----------------|-----------|-----------|
|hatech-center-eureka|`同创云微服务注册与发现中心`|`8761`|
|hatech-center-gateway|`同创云gateway网关微服务`|`8040`|

## 鉴权系统

## 更新日志
1：hatech-auth-server添加spring-boot-starter-webflux、spring-cloud-starter-oauth2、spring-boot-starter-data-jpa，开发鉴权认证基础服务

## 微服务间调用
### 一. 用户登录获取token
发送POST请求到 http://localhost:8040/api/auth/oauth/token, 

其中body中传入以下参数:

|key      |value       |说明      |
|----------------|-----------|-----------|
|`grant_type`|`password`|oauth2.0鉴权类型, 这里采用password类型|
|`username`|`zhangsan`|用户名, 登录系统所用的用户名|
|`password`|`123456`|密码, 登录系统所用的密码|
|`scope`|`server`|scope用来限制访问的范围. 即下面header中设置的hatech-app-demo微服务所拥有的scope|

header中配置basic auth类型的参数如下:

|类型         |值           |说明          |
|----------------|-----------|-----------|
|`username`|`hatech-app-demo`|微服务的clientId|
|`password`|`123456`|微服务的clientSecret|

经过POST发送请求后, 得到的token如下
```text
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiaGF0ZWNoLWFwcC1idXNpbmVzcyJdLCJ1c2VyX25hbWUiOiJ6aGFuZ3NhbiIsInNjb3BlIjpbInNlcnZlciJdLCJleHAiOjE1NzI5MzcxOTEsImF1dGhvcml0aWVzIjpbIlJPTEVfU1RVREVOVCJdLCJqdGkiOiIwZDkwZGJjZS1iYjIwLTQ0NzctOTQxNS05MGFmZDk3Mjk3MzEiLCJjbGllbnRfaWQiOiJoYXRlY2gtYXBwLWRlbW8ifQ.8IFrr8H3qRDst46Q2GCcspxm3W8AQDFXbNgsOPynKSs",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiaGF0ZWNoLWFwcC1idXNpbmVzcyJdLCJ1c2VyX25hbWUiOiJ6aGFuZ3NhbiIsInNjb3BlIjpbInNlcnZlciJdLCJhdGkiOiIwZDkwZGJjZS1iYjIwLTQ0NzctOTQxNS05MGFmZDk3Mjk3MzEiLCJleHAiOjE1NzI5MzcxOTEsImF1dGhvcml0aWVzIjpbIlJPTEVfU1RVREVOVCJdLCJqdGkiOiJlNWY1MWQwZS0xMTE3LTQ3YjUtYjlmNy0wOTc0YmMxNTNlOTYiLCJjbGllbnRfaWQiOiJoYXRlY2gtYXBwLWRlbW8ifQ.xlLotEbUUqEQVsn0rXLQoV6NSmWgG8fkp6IRBz-dlNg",
    "expires_in": 5999,
    "scope": "server",
    "jti": "0d90dbce-bb20-4477-9415-90afd9729731"
}
```
其中access_token即为获取到的token, token类型为bearer, token有效期为5999秒, token的scope范围为server. 

### 二. 通过refresh_token得到新的token

如果第一步的token过期, 但refresh_token未过期, 则可以通过refresh_token重新生成token:

发送POST请求到 http://localhost:8040/api/auth/oauth/token, 

其中body中传入以下参数:

|key      |value       |说明      |
|----------------|-----------|-----------|
|`grant_type`|`refresh_token`|oauth2.0鉴权类型, 这里采用refresh_token类型|
|`refresh_token`|`eyJhbGci...`|第一步得到的refresh token值|
|`scope`|`server`|scope用来限制访问范围. 即下面header中设置的hatech-app-demo微服务所拥有的scope|

header中配置basic auth类型的参数如下:

|类型         |值           |说明          |
|----------------|-----------|-----------|
|`username`|`hatech-app-demo`|微服务的clientId|
|`password`|`123456`|微服务的clientSecret|

经过POST发送请求后, 得到重新生成的token如下
```text
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiaGF0ZWNoLWFwcC1idXNpbmVzcyJdLCJ1c2VyX25hbWUiOiJ6aGFuZ3NhbiIsInNjb3BlIjpbInNlcnZlciJdLCJleHAiOjE1NzI5Mzc5MjIsImF1dGhvcml0aWVzIjpbIlJPTEVfU1RVREVOVCJdLCJqdGkiOiJjYzYxZTVmNy1kZDRjLTQ2ZjAtYmQ0NS1lMDM5MjFjNTBlOTYiLCJjbGllbnRfaWQiOiJoYXRlY2gtYXBwLWRlbW8ifQ.WAqIPQY-lGYHDS8w4GGVtnjMjRp_dotaiLb15mburpQ",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiaGF0ZWNoLWFwcC1idXNpbmVzcyJdLCJ1c2VyX25hbWUiOiJ6aGFuZ3NhbiIsInNjb3BlIjpbInNlcnZlciJdLCJhdGkiOiJjYzYxZTVmNy1kZDRjLTQ2ZjAtYmQ0NS1lMDM5MjFjNTBlOTYiLCJleHAiOjE1NzI5MzcxOTEsImF1dGhvcml0aWVzIjpbIlJPTEVfU1RVREVOVCJdLCJqdGkiOiJlNWY1MWQwZS0xMTE3LTQ3YjUtYjlmNy0wOTc0YmMxNTNlOTYiLCJjbGllbnRfaWQiOiJoYXRlY2gtYXBwLWRlbW8ifQ.sMzBYblA6EfKT2oikuJ7Mc_FfjUtwZWjOCrLKgAZmJE",
    "expires_in": 5999,
    "scope": "server",
    "jti": "cc61e5f7-dd4c-46f0-bd45-e03921c50e96"
}
```
注: token的过期时间和refresh_token的过期时间设置在hatech-auth-server项目的application-dev.yml配置文件中:
security.oauth2.validity.access-token-seconds配置了token的过期时间;security.oauth2.validity.refresh-token-seconds配置了refresh_token的过期时间

### 三. 微服务间通过feign结合token实现相互调用
例如, 在hatech-app-demo服务中利用第一步用户登录后得到的token, 通过feign去调用hatech-app-business服务中的接口:

发送GET请求到 http://127.0.0.1:8040/api/app/demo/feign,

其中header中配置bearer token类型的参数如下:

|key        |value                         |说明             |
|----------------|------------------------|---------------------|
|`Authorization`|`Bearer eyJhbGciOiJIU...`|字符Bearer+空格+第一步得到的token|

经过GET请求后得到的response如下:
```text
{
    "msg": "hi, i am from port: 9001",
    "port": "9001"
}
```
该请求会通过feign从hatech-app-demo服务(端口为9000)的/feign接口转发到hatech-app-business服务(端口为9001)的/hi接口.


