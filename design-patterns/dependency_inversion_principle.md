# Dependency Inversion Principle

> High-level modules should not depend on low-level modules. Both should depend on abstraction.
> 
> Abstractions should not depend on details. Details should depend on abstraction.

### 原則

* 高層模組不應該依賴低層模組，兩者應該透過抽象層來產生關聯
* 抽象層不應該依賴細節，細節應該依賴抽象層

如果高層模組依賴低層模組，當低層模組變動時高層模組必定被影響。

<b>Note：</b>

如果低層模組是相當穩定，例如程式語言原生模組，通常不需要在透過抽象層隔離，可以直接依賴。

### References

* [Wikipedia's Dependeny Inversion Principle](https://en.wikipedia.org/wiki/Dependency_inversion_principle)
* [SOLID 之 依賴反轉原則 (Dependency inversion principle)](https://ithelp.ithome.com.tw/articles/10192844)
* [依賴反轉原則 Dependency Inversion Principle (DIP)](https://medium.com/@f40507777/%E4%BE%9D%E8%B3%B4%E5%8F%8D%E8%BD%89%E5%8E%9F%E5%89%87-dependency-inversion-principle-dip-bc0ba2e3a388)
* The Zen of Design Patterns

