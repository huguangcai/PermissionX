# PermissionX
PermissionX 是一个用于简化Android运行时权限用法的开源库
## 添加如下配置将PermissionX引入到你的项目当中：
```
dependencies {
    ...
    implementation 'com.guangcai.permissionx:permissionx:1.0.0'
}
```
## 然后就可以使用如下语法结构来申请运行时权限了：
```
PermissionX.request(this,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS) { allGranted, deniedList ->
    if (allGranted) {
        Toast.makeText(this, "All permissions are granted", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_SHORT).show()
    }
}
```