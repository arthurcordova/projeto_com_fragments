package com.proway.projetofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.proway.projetofragments.fragments.PrimeiroFragment
import com.proway.projetofragments.fragments.SegundoFragment
import com.proway.projetofragments.fragments.TerceiroFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<Button>(R.id.buttonFrag1).apply {
            setOnClickListener {
                replaceFrag(PrimeiroFragment())
            }
        }

        findViewById<Button>(R.id.buttonFrag2).apply {
            setOnClickListener {
                replaceFrag(SegundoFragment())
            }
        }

        findViewById<Button>(R.id.buttonFrag3).apply {
            setOnClickListener {
                replaceFrag(TerceiroFragment.newInstance(false))
            }
        }

    }

    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}