package com.proway.projetofragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogFragmentApp : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Message error")
            .setView(R.layout.dialog_sample)
            .setMessage(getString(R.string.app_name))
            .setPositiveButton("Ok") { _, _ -> }
            .create().apply{
            }


}