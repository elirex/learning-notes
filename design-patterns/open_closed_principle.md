# Open Closed Principle

> Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

當軟裡需要新功能時，應該透過擴展 (新增新的程式碼) 實現變化，而不是透過修改內部已有的程式碼實現變化。

* 對擴展開放：新功能是用加入新的程式碼擴展出來
* 對修改關閉：新功能不用修改現有程式碼

### 優點

* 降低耦合增加擴展性
* 提身維護性
* 增加可測試性

### 潛在問題

新功能擴展的不一定在設計階段就會發現，時常到了需求出現才會知道，因此在設計階段，盡量將最底層的共用邏輯抽取出來，使用繼承方式去擴展。

### Reference

* [Wikipedia's Open–closed Principle](https://en.wikipedia.org/wiki/Open–closed_principle)
* [SOLID 之 開關原則（Open-Close principle）
](https://ithelp.ithome.com.tw/articles/10192105)
* [開放封閉原則 Open-Closed Principle (OCP)](https://medium.com/@f40507777/%E9%96%8B%E6%94%BE%E5%B0%81%E9%96%89%E5%8E%9F%E5%89%87-open-closed-principle-31d61f9d37a5)
* * The Zen of Design Patterns