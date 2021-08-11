package com.proway.projetofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.proway.projetofragments.fragments.PrimeiroFragment
import com.proway.projetofragments.fragments.SegundoFragment
import com.proway.projetofragments.fragments.TerceiroFragment
import com.proway.projetofragments.fragments.TipoLista

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<Button>(R.id.buttonFrag1).apply {
            setOnClickListener {
                /**
                 * Usamos o mesmo fragment para criar listas de objetos diferentes
                 * Passamos o TipoLista (Enum) para identificar dentor do fragment
                 *
                 * LISTA DE PRODUTOS
                 */
                replaceFrag(TerceiroFragment.newInstance(TipoLista.PRODUTOS))
            }
        }


        findViewById<Button>(R.id.buttonFrag3).apply {
            setOnClickListener {
                /**
                 * Usamos o mesmo fragment para criar listas de objetos diferentes
                 * Passamos o TipoLista (Enum) para identificar dentor do fragment
                 *
                 * LISTA DE CARROS
                 */
                replaceFrag(TerceiroFragment.newInstance(TipoLista.CARROS))
            }
        }

        findViewById<Button>(R.id.buttonDialogFrag).apply {
            setOnClickListener {
                /**
                 * Executamos uma instancia do DialogFragmentApp para mostrar na tela.
                 */
                DialogFragmentApp().show(supportFragmentManager, "")
            }
        }

    }

    /**
     * Reponsável em fazer a manipulaçao dos fragments na tela
     */
    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            /**
             * Busca por um Layout na tela com id R.id.container
             * e irá injetar nele o fragment que passamos por parametro
             */
            .replace(R.id.container, fragment)
            .commitNow()
    }
}