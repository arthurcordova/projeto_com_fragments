package com.proway.projetofragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

/**
 * Classe criada para usar como dialog. Herdamos tudo da classe DialogFragment
 */
class DialogFragmentApp : DialogFragment() {


    /**
     * Sobrescrevemos este méto para customizar o dialog
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Message error")
            /**
             * Add uma view customizada, foi criada manualmente
             */
            .setView(R.layout.dialog_sample)
            .setMessage(getString(R.string.app_name))
            /**
             * Add Uma Action para o button
             * Button positive é o da direita
             */
            .setPositiveButton("Ok") { _, _ -> }
            /**
             * Add Uma Action para o button
             * Button positive é o da esquerda
             */
            .setNegativeButton("Cancelar") { _, _ -> }
            .create().apply{
                /**
                 * Aqui dentro podemos manipular o elementos da view
                 * Ex: view?.findViewById<>()
                 */


            }


}