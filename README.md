# Logger

好用的 Android 日志工具类。

设计和实现请参考博客：[https://l0neman.github.io/2020/07/23/好用的-Android-日志工具](https://l0neman.github.io/2020/07/23/好用的-android-日志工具)



## 特点

1. 简单，仅由一个 100 余行的 Java 类实现，猴子都能看懂 ^\_^；
2. 额外可选日志内容，提供线程名信息和调用栈，提供当前日志打印所在类以及所在代码行数；
3. 方便，包含栈信息，直接用鼠标即可点击到日志打印所在行；
4. 安全，保证日志字符串完全被优化掉，而不是留在代码中；
5. 灵活，提供二次封装。



# 使用方法

## 单项目使用方法

对于单个应用来说，把 `Logger` 复制到项目包中，推荐重命名为与项目相关的有意义的名字，例如对于实例项目 LoggerExample 来说，把 `Logger` 类，重命名为 `LeLogger`。 

然后将主 TAG 改为应用的标识 `LE` 即可，然后按照需要自定义 `Logger` 选项。

在 logcat 中输入 `LE#` 即可过滤出应用的日志。



## 多模块项目使用方法

当一个项目存在多个模块时，推荐在每个模块中都复制进去一个 `Logger` 类，然后分别重命名为每个模块的标识。

例如有一个记事本有 Read Module 和 Edit Module 两个模块，那么分别复制两个 `Logger` 类到两个模块的包，分别重命名为 `RmLogger` 和 `WmLogger`，同时更改主 TAG 为 `RM` 和 `WM`，这样过滤日志使用主 TAG 就能区分模块的日志了。

在调用时，属于两个模块的代码分别调用各自的 `Logger` 类，互不干扰，那么就可以各自定义自己的日志开关和选项。



# Logger 选项说明

1. Logger.PRINT = true

此标记控制所在 `Logger` 类的日志开关，设为 `false` 时，使用此 `Logger` 打印的所有日志将被移除。



2. Logger.STACK_PRINT = true

此标记控制是否在日志尾部显示调用栈信息，例如 `(MainActiviy.java:20)`。显示后，可使用鼠标点击跳转，设为 `false`，将不再显示。



3. Logger.STACK_OFFSET = 4

此标记控制打印单行调用栈信息的偏移。当需要对 `Logger` 进行包装时，如果包装一层，即 `Logger` 打印代码的上一次就是包装方法的代码时，将偏移 +1，偏移随着包装方法的层次累加而递增。



4. Logger.STACK_COUNT = 1

此标记控制打印调用栈信息的数量，默认为 `1`，只显示当前日志调用行的调用栈信息。可根据需要改变栈信息数量。

设置为 `4` 时效果如下：

```java
...io.l0neman.example D/LE#MainActivity: hello world [main](Activity.java:7791)
      (Activity.java:7802)
        (MainActivity.java:21)
          (MainActivity.java:26)
```

设置为 `7` 时效果如下：

```java
...io.l0neman.example D/LE#MainActivity: hello world [main](LaunchActivityItem.java:83)
      (ActivityThread.java:3409)
        (ActivityThread.java:3245)
          (Instrumentation.java:1299)
            (Activity.java:7791)
              (Activity.java:7802)
                (MainActivity.java:21)
```


## LICENSE

```
Copyright 2020 l0neman

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
