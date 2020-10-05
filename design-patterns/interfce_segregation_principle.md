# Interface Substitution Principle

> Clients should not be forced to depend on methods that they do not use.

### 原則

1. Interface 盡量小 - Interface 中的功能盡量小。

2. Interface 高內聚 - 在符合目前情況及可預見的未來需求上，盡量可能細分，盡可能減少公開的功能，可降低外來變動的風險。

3. Interface 訂製服務 - Interface 只提供訪問者需要的方法。

4. Interface 大小切分標準 - 根據當前情況及可預見的未來需求上找出平衡點。

<b>Note：</b>

在切分 Interface 時不能違反單一職責原則 (Single Responsibility Principle)。


### Reference

* [Wikipedia's Interface Substitution Principle](https://en.wikipedia.org/wiki/interface_substitution_principle)
* [SOLID 之 介面隔離原則 (Interface substitution principle)](https://ithelp.ithome.com.tw/articles/10192464)
* The Zen of Design Patterns