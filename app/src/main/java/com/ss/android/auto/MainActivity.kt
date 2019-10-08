package com.ss.android.auto


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import com.ss.android.auto.adapter.ForecastListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var tvText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        printThreadName()
    }

    private fun initView() {
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = ForecastListAdapter(this, items)

        tvText = findViewById(R.id.tv_title)
        tvText.text = "hello kotlin"
        printId(tvText)
    }

    private fun printId(view: View?) {
        Log.d("wangzhengyi", "id:" + view?.id)
    }

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    private fun printThreadName() {
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            withContext(Dispatchers.IO) {
                Log.e("wangzhengyi", "current thread name1=" + Thread.currentThread())
            }
            withContext(Dispatchers.Main) {
                Log.e("wangzhengyi", "current thread name2=" + Thread.currentThread())
            }
            Log.e("wangzhengyi", "current thread name3=" + Thread.currentThread())
        }
    }


}
