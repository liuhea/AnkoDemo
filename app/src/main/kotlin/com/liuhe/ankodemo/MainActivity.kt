package com.liuhe.ankodemo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createUI())
    }

    private fun createUI(): View {
        return UI {
            verticalLayout {
                padding = dip(30)
                backgroundResource = android.R.color.holo_blue_bright
                var title = editText {
                    id = R.id.todo_title
                    hintResource = R.string.title_hint
                }

                var content = editText {
                    id = R.id.todo_content
                    hintResource = R.string.content_hint
                }

                button {
                    id = R.id.todo_add
                    textResource = R.string.add_todo
                    textColor = Color.WHITE
                    onClick {
                        if (!TextUtils.isEmpty(title.text.toString()) && !TextUtils.isEmpty(content.text.toString())) {
                            toast("${title.text}::${content.text}")
                        }
                    }
                }
            }
        }.view
    }

    fun firstCoroutineDemo0() {
        launch(CommonPool) {
            delay(3000L, TimeUnit.MILLISECONDS)
            println("hello,")
        }
        println("world!")
        Thread.sleep(5000)
    }
}
