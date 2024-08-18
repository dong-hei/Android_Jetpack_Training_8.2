package com.dk.diffutilandlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * DiffUtil / ListAdapter
 * db에서 값을 받아와 새롭게 rv에 보여줄 일이있는데 이걸 매번 새롭게 그려주는 작업이 비효율적이기 때문에
 * 이런 연산을 효율적으로 하기 위해서 사용한다.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.menRv)
        val adapter = MenListAdapter()

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        adapter.submitList(firstSetupData())

        //5초후에 데이터 변경
        Handler(Looper.getMainLooper()).postDelayed({
            adapter.submitList(SecondSetupData())
        }, 5000)
    }

    fun firstSetupData() : ArrayList<MenDataModel>{
        val men1 = MenDataModel(1,"Roman Regins", 38)
        val men2 = MenDataModel(2,"CM Punk", 45)
        val men3 = MenDataModel(3,"Bobby Lashley", 47)
        val men4 = MenDataModel(4,"Bron Breakker", 26)
        val men5 = MenDataModel(5,"Trick Williams", 29)

        val arr = ArrayList<MenDataModel>()
        arr.add(men1)
        arr.add(men2)
        arr.add(men3)
        arr.add(men4)
        arr.add(men5)

        return arr
    }

    fun SecondSetupData() : ArrayList<MenDataModel>{
        val men3 = MenDataModel(3,"Bobby Lashley", 47)
        val men5 = MenDataModel(5,"Trick Williams", 29)
        val men6 = MenDataModel(6,"Cody Rhose", 38)
        val men7 = MenDataModel(7,"LA Knight", 41)
        val men8 = MenDataModel(8,"AJ Styles", 46)
        val men4 = MenDataModel(4,"Bron Breakker", 26)
        val men9 = MenDataModel(9,"Drew Mcintyre", 38)
        val men10 = MenDataModel(10,"R-Truth", 52)

        val arr2 = ArrayList<MenDataModel>()
        arr2.add(men3)
        arr2.add(men4)
        arr2.add(men5)
        arr2.add(men6)
        arr2.add(men7)
        arr2.add(men8)
        arr2.add(men9)
        arr2.add(men10)

        return arr2
    }
}