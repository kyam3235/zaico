# 在庫管理アプリ「Zaico」技術設計書

## 1. システム構成
本アプリは **Kotlin Multiplatform (KMP)** をベースとし、UIフレームワークとして **Compose Multiplatform** を採用する。

## 2. アーキテクチャ
**MVVM (Model-View-ViewModel)** アーキテクチャを採用し、ビジネスロジックとUIを分離する。

- **View (Compose)**: UIの表示およびユーザーイベントの検知を担当。
- **ViewModel**: UI状態（State）の管理およびViewからのアクションに応じたロジックの実行を担当。
- **Model (Domain Model)**: アプリケーションで扱うデータの定義。

## 3. モジュール構成
- `jp.kyamlab.zaico.domain.model`: データクラスの定義
- `jp.kyamlab.zaico.presentation.stock`: 在庫管理画面のUIおよびViewModel

## 4. 詳細設計

### 4.1. データモデル
`StockItem` クラス
- `id: Long`: 一意識別子
- `name: String`: 商品名
- `quantity: Int`: 在庫数

### 4.2. UIコンポーネント
- `StockScreen`: メイン画面。在庫一覧と商品追加ボタンを表示。
- `StockListItem`: 一覧の各行。商品名、在庫数、増減ボタン（＋/ー）、削除ボタンを表示。
- `AddItemDialog`: 商品追加用のダイアログ（商品名、初期在庫数の入力）。

### 4.3. 状態管理 (ViewModel)
`StockViewModel` が以下の状態とメソッドを保持する。

#### 状態
- `uiState: StateFlow<StockUiState>`: 在庫リストを含む画面の状態。

#### メソッド
- `incrementQuantity(itemId: Long)`: 指定した商品の在庫を+1する。
- `decrementQuantity(itemId: Long)`: 指定した商品の在庫を-1する（最小値0）。
- `addItem(name: String, initialQuantity: Int)`: 新しい商品を追加する。
- `deleteItem(item: StockItem)`: 指定した商品を削除する。

## 5. データの永続化 (将来拡張)
現在はメモリ内での管理とするが、将来的に以下の対応を検討する。
- **Android/iOS**: SQLDelight を用いたローカルDBへの保存。
