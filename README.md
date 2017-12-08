# core-share

**分享弹窗，用来统一分享弹窗效果，具体逻辑略。**

### 外部引用

```
compile 'com.joy.support:core-share:0.2.7'
```

### 自身依赖

```
compile 'com.joy.support:core-ui:0.3.5'
```

### 版本历史

- `0.2.7` 升级core-ui:0.3.5；

- `0.2.5` 适配core-ui的更改（bindOnClickListener / bindOnLongClickListener）；

- `0.2.4` 更新ItemDecoration builder的创建方式；可以通过theme自定义share icon/text的属性（width/height...）；

- `0.2.3` 增加系统分享的一些方法和选项；新图片资源 & 通过主题动态设置spanColumn、verticalSpacing、parentPadding；

- `0.2.2` 整理代码；update resource name (nothing)；增加方法、属性；

### 结构

- **Share**

    `JoyShare`

    `ShareAdapter`

    `ShareItem`

    `ShareUtil`

### 用法

**Notice：集成此模块的Activity或者Application的主题中必须含有以下属性**

```
        <item name="shareColumn">4</item>
        <item name="shareVerticalSpacing">16dp</item>
        <item name="shareParentPadding">24dp</item>
        <item name="shareIconWidth">42dp</item>
        <item name="shareIconHeight">42dp</item>
        <item name="shareTextSize">12dp</item>
        <item name="shareTextColor">@color/black_trans40</item>
        <item name="shareViewSpacing">6dp</item>
```

详见穷游APP、蓝莓APP、core-web模块

### Joy-Library中的引用体系

![](core-share.png)
