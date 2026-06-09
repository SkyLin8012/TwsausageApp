# 🌭 TwSausageApp - 台式炭烤香腸點餐系統

一個使用 Java Swing 開發的台灣小吃點餐系統，模擬炭烤香腸攤位的點餐流程，並結合傳統民俗遊戲「十八啦」作為優惠活動。

---

# 📖 專案介紹

TwSausageApp 是一套桌面版點餐系統，提供使用者：

* 商品點餐
* 數量增減
* 折扣計算
* 訂單明細產生
* 列印功能
* 十八啦骰子小遊戲
* 即時時間顯示

透過 Java Swing 建立圖形化介面，模擬台灣夜市香腸攤的實際點餐情境。

---

# 🎯 系統特色

✅ 圖形化點餐介面

✅ 自動計算金額

✅ 多種商品選購

✅ 會員折扣功能

✅ 訂單列印

✅ 十八啦骰子遊戲

✅ 中獎贈送香腸活動

✅ 即時時間顯示

---

# 🍢 菜單內容

| 商品     | 單價    |
| ------ | ----- |
| 古早味烤香腸 | NT$45 |
| 花生糯米腸  | NT$40 |
| 大腸包小腸  | NT$75 |
| 綜合甜不辣  | NT$30 |
| 飲料     | NT$25 |

---

# 🎲 十八啦小遊戲

完成點餐後可參加「十八啦」遊戲。

## 遊戲規則

* 玩家與老闆各擲四顆骰子
* 系統依照十八啦規則計算點數
* 比較雙方大小

### 獎勵機制

| 結果   | 獎勵       |
| ---- | -------- |
| 玩家獲勝 | 贈送指定數量香腸 |
| 平手   | 贈送香腸 1 根 |
| 玩家失敗 | 無額外贈送    |

---

# 🏗 專案架構

```text
TwSausageApp
│
├── twsausage.java
│   ├─ 訂單資料模型
│   ├─ 金額計算
│   └─ 訂單明細產生
│
├── twsausageUi.java
│   ├─ 主畫面
│   ├─ 點餐介面
│   ├─ 折扣設定
│   └─ 列印功能
│
├── si̍ppatlah.java
│   ├─ 十八啦遊戲邏輯
│   ├─ 骰子規則判定
│   └─ 勝負計算
│
├── sippatlahUi.java
│   └─ 十八啦遊戲介面
│
└── img/
    ├─ 骰子圖片
    └─ UI 圖片素材
```

---

# 🛠 開發技術

## Language

* Java

## GUI

* Java Swing

## IDE

* Eclipse IDE

## Concepts

* Object-Oriented Programming (OOP)
* Event Driven Programming
* MVC Design Concept
* Random Number Generation
* Printing API

---

# 🚀 執行方式

## 1. Clone 專案

```bash
git clone https://github.com/your-account/TwSausageApp.git
```

## 2. 使用 Eclipse 開啟

Import Existing Project

或直接匯入：

```text
File
 └ Import
    └ Existing Projects into Workspace
```

---

## 3. 執行主程式

```java
twsausageUi.java
```

或執行：

```bash
Run As → Java Application
```

---

# 📸 系統畫面

## 主點餐介面

* 輸入顧客姓名
* 選擇商品數量
* 套用折扣
* 產生訂單

## 十八啦遊戲

* 顯示玩家骰子
* 顯示老闆骰子
* 計算點數
* 顯示勝負結果

---

# 📚 學習重點

本專案練習了以下 Java 技術：

* Swing GUI 開發
* JFrame 與 JPanel 介面設計
* Mouse Event 處理
* ActionListener 事件控制
* 資料驗證
* 物件導向封裝
* 隨機骰子演算法
* 商業邏輯設計
* 列印功能實作

---

# 🔮 未來優化方向

* 資料庫儲存訂單紀錄
* 會員系統
* 庫存管理
* 報表分析
* POS 收銀功能
* 響應式介面設計
* JavaFX 重構版本

---

# 👨‍💻 Author

Sky Lin

Game Art & Software Development Learner

Taiwan

---

# 📄 License

This project is licensed for educational and learning purposes.

Feel free to fork and improve it.
