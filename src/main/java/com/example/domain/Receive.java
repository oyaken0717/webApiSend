package com.example.domain;

public class Receive {
//■受け取ったデータを格納するためのクラス

	// プロパティ
	private String name;
	private String type;

	// 名前の読み出し
	public String getName() {
		return name;
	}

	// 名前のセット
	public void setName(String name) {
		this.name = name;
	}

	// タイプの読み出し
	public String getType() {
		return type;
	}

	// タイプのセット
	public void setType(String type) {
		this.type = type;
	}
}