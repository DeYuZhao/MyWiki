# JQuery开发总结
## url中的参数解析（使用正则表达式）
```js
function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    //search,查询？后面的参数，并匹配正则
    var r = window.location.search.substr(1).match(reg);
    if(r!=null) return unescape(r[2]); return null;
}
```
