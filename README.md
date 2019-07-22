


| 用户名   | 密码 | 权限
| :----: | :---: | :---: 
| `admin`  |123456| 全部权限
| `test`  |123456| 部分权限
| `suyu`  |123456| 只有信息相关的全部权限

#### 登录
```java
//post方式 是否记住我
127.0.0.1:8080/login?username=admin&password=123456&remember-me=true
```

#### 退出登录
```java
127.0.0.1:8080/signout
```
```java
127.0.0.1:8080/msg/list
```

```json
{
    "code": 1,
    "data": [
        {
            "createAt": 1563552549000,
            "id": 1,
            "msg": "这是第一条信息",
            "updateAt": 1563525034000
        },
        {
            "createAt": 1563527038000,
            "id": 3,
            "msg": "这是第二条信息",
            "updateAt": 1563527038000
        }
    ],
    "msg": "请求成功"
}
```




