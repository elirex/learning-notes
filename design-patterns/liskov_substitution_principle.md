# Liskov Substitution Principle

> If S is a subtype of T, then objects of type T may be replaced with objects of type S.


### 原則

1. 子類別必須完全實現父類別方法。

2. 子類別可以有自己的屬性及方法。

3. 覆寫或實現寫父類別方法，參數要與父類別一樣或是更寬鬆。

```
例如父類別定義 List，子類別可以是 List 或 Collection
```

4. 覆寫或實現寫父類別方法，回傳結果要跟父類別一樣或是更窄。

```
例如父類別回傳 List，子類別可以是 List 或 ArryList
```

<b>Note：</b>

1. 在調用其他類務必要使用其父類，如果不能使用父類表示違反 LSP 原則。

2. 如果子類不能完整實現父類方法，或父類方法在子類中發生異變，建議斷開父子類的繼承關係，可採用依賴、聚集或組合等方式替代。

### 優點

增加程式的強健性，在擴展時可以有較好的兼容性。

### Reference

* [Wikipedia's Liskov Substitution Principle](https://en.wikipedia.org/wiki/Liskov_substitution_principle)
* [SOLID 之 里氏替換原則 (Liskov substitution principle)](https://ithelp.ithome.com.tw/articles/10192317)
* The Zen of Design Patterns