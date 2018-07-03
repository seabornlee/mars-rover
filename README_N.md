# 编译

    mvn assembly:assembly
    java -jar target/mars-rover-1.0.0.jar

**特殊说明**

输入时，假定输入的内容全部合法，坐标只能是数值型，方向为 `N` `W` `S` `E` 四个字母，指令只能是 `L` `R` `M`。*未做输入有效性校验*
