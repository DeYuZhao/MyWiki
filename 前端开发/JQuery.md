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
## 树形结构下拉框实现(使用bootstrap-treeview插件)
```js
var defaultData = [
    {
        text: '地域特色',
        nodes: [
            {
                text: '华北馆',
                nodes: [
                    {
                        text: '北京'
                    }
                ]
            }
        ]
    }
 ];
var $checkableTree = $('#treeview-checkable').treeview({
    data: defaultData,
    showIcon: false,
    showCheckbox: true,
    state: {
        checked: false,
        disabled: false,
        expanded: false,
        selected: false
    },
    levels: 0,
    expandIcon: 'mdi mdi-caret-right',// 展开图标
    collapseIcon: 'mdi mdi-caret-down',// 收缩图标
    onNodeChecked: function(event, node) { //勾选事件
    },
    onNodeUnchecked: function (event, node) { //取消勾选事件
    }
});
```

[bootstrap-treeview 中文API文档](https://www.cnblogs.com/tangzeqi/p/8021637.html)
