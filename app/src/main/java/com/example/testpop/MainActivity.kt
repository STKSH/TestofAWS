package com.example.testpop

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 팝업창 띄우기 버튼
        val showPopupButton = findViewById<Button>(R.id.btnpopup)
        showPopupButton.setOnClickListener { view: View? -> showCustomPopup() }
    }

    private fun showCustomPopup() {
        // Dialog 생성
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_popup)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        // Dialog 내부 요소 설정
        val btnClose = dialog.findViewById<ImageButton>(R.id.btn_close)
        val popupContent = dialog.findViewById<TextView>(R.id.popup_content)
        val btnLike = dialog.findViewById<Button>(R.id.btn_like)
        val btnMessage = dialog.findViewById<Button>(R.id.btn_message)

        // 이벤트 처리
        btnClose.setOnClickListener { v: View? -> dialog.dismiss() }
        btnLike.setOnClickListener { v: View? ->
            // 좋아요 버튼 클릭 처리
            popupContent.text = "좋아요 눌렀습니다!"
        }
        btnMessage.setOnClickListener { v: View? ->
            // 메시지 보내기 버튼 클릭 처리
            popupContent.text = "메시지를 보냈습니다!"
        }

        // 팝업 띄우기
        dialog.show()
    }
}
