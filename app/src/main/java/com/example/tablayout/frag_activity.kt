package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_frag.*

class frag_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)
        var bundle: Bundle? =intent.extras
        var aud= bundle?.get("audio").toString()
        var vid=bundle?.get("video").toString()
        fun fragg(f:Fragment){
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame,f)

                commit()
            }
        }
        if(aud=="audio"){
            fragg(f1())
        }else if(vid=="video"){
            fragg(f2())
        }
    }
}