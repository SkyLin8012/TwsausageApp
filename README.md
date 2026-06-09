# TwsausageApp 🌭

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Platform: Web / Standalone](https://img.shields.io/badge/platform-Web%20%7C%20Standalone-blue)](https://github.com/)

歡迎來到 **TwsausageApp**！這是一個融合台灣在地文化與現代數位體驗的應用程式專案。

## 📖 專案簡介

`TwsausageApp` 旨在透過數位化方式呈現台灣傳統小吃（特別是台灣香腸）的獨特魅力。無論是經典的廟口骰子遊戲（十八仔）、香腸攤位地圖搜羅，還是自動化的資料處理系統，本專案提供了一套完整的解決方案。

## ✨ 核心功能

* 🎲 **數位大腸包小腸遊戲**：完美還原經典的「十八仔」骰子博弈體驗。
* 📊 **多源資料整合系統**：內建強大的數據解析模組，支援多達 166 組核心資源包（Source Data）的解碼與分類管理。
* 🚀 **跨平台支援**：支援 Web 瀏覽器端運行，並可透過工具打包為獨立的桌面執行檔 (`.exe`)。
* 🤖 **智慧型通知整合**：內建自動化串接模組（如 LINE Messaging API），即時回報系統狀態。

## 📁 專案架構

專案核心資源與架構封裝於 `TwsausageApp.7z` 中，解壓縮後的基本結構如下：

```text
TwsausageApp/
├── src/                    # 原始碼目錄
│   ├── app/                # 應用程式核心邏輯
│   └── utils/              # 自動化與資料處理工具
├── assets/                 # 靜態資源（圖片、音效、Mascot 設計）
├── data/                   # 資料庫與多源數據集
│   └── sources/            # Source 1 至 Source 166 的原始數據
├── README.md               # 專案說明文件
└── requirements.txt        # Python 依賴套件清單

***

### 🛠️ 我可以如何修改這個範本？
1. **調整簡介**：如果不完全是骰子遊戲或香腸地圖，你可以把 `📖 專案簡介` 修改為最符合你目前開發項目的文字。
2. **修改快速開始**：如果這是純 C# / Unity 專案，你可以把安裝步驟改成「使用 Unity Hub 開啟專案」。
3. **更換連結**：記得把 `your-username` 換成你真正的 GitHub 帳號名稱！
