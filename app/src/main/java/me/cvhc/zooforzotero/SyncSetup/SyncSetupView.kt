package me.cvhc.zooforzotero.SyncSetup

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import me.cvhc.zooforzotero.R
import me.cvhc.zooforzotero.SyncSetup.ZoteroAPISetup.ZoteroAPISetup

class SyncSetupView : AppCompatActivity(), SyncSetupContract.View {
    override fun createAlertDialog(title: String, message: String) {
        Log.e("zotero", "got error $title - $message")
        val alert = AlertDialog.Builder(this)
        alert.setIcon(R.drawable.ic_error_black_24dp)
        alert.setTitle(title)
        alert.setMessage(message)
        alert.setPositiveButton("Ok") { _, _ -> }
        alert.show()
    }

    override fun createAPIKeyDialog(onKeySubmit: (String) -> Unit) {
        val dialogBuilder = AlertDialog.Builder(this)
            .setTitle("Enter your API Key")

        val textBox: EditText = EditText(this)
        textBox.inputType = InputType.TYPE_CLASS_TEXT
        dialogBuilder.setView(textBox)
            .setPositiveButton("Submit", { _, _ ->
                onKeySubmit(textBox.text.toString())
            })
            .setNegativeButton("Cancel", { _, _ -> })

        dialogBuilder.show()
        textBox.requestFocus()
    }

    override fun showHowToZoteroSyncDialog(onProceed: () -> Unit) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("How to access")
        dialog.setMessage(
            "You will need to login with your Zotero Account.\n" +
                    "After your login in, make sure you scroll down and click \"Save Key\"\n\n" +
                    "Once this is complete the web browser should close."
        )
        dialog.setPositiveButton(
            "Got it!"
        ) { _, _ -> onProceed() }
        dialog.show()
    }

    override fun createUnsupportedAlert() {
        val alert = AlertDialog.Builder(this@SyncSetupView)
        alert.setIcon(R.drawable.ic_error_black_24dp)
        alert.setTitle("Unsupported Syncing Option")
        alert.setMessage(
            "Sorry I have not yet implemented this syncing option yet!\n" +
                    "Currently there is only support for the Zotero API"
        )
        alert.setPositiveButton("Ok") { _, _ ->
            val button_proceed = findViewById<Button>(R.id.btn_sync_proceed)
            button_proceed.isEnabled = false
        }
        alert.show()
    }

    override fun startZoteroAPIActivity() {
        val intent = Intent(this, ZoteroAPISetup::class.java)
        startActivity(intent)
    }

    var selected_provider = SyncOption.Unset

    override fun initUI() {
        val btnProceed = findViewById<Button>(R.id.btn_sync_proceed)
        val rg_cloudproviders = findViewById<RadioGroup>(R.id.radiogroup_cloudproviders)
        rg_cloudproviders.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.radio_zotero -> selected_provider = SyncOption.ZoteroAPI
                R.id.radio_zotero_manual_apikey -> selected_provider = SyncOption.ZoteroAPIManual
                else -> throw Exception("Error, not sure what Radiobox was pressed")
            }
            btnProceed.isEnabled = true
        }

        btnProceed.setOnClickListener {
            if (selected_provider != SyncOption.Unset) {
                presenter.selectSyncSetup(selected_provider)
            }
        }

    }

    private lateinit var presenter: SyncSetupPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_setup)

        presenter = SyncSetupPresenter(this, this)
    }

    override fun onResume() {
        if (presenter.hasSyncSetup()) {
            finish()
        }
        super.onResume()
    }

}
